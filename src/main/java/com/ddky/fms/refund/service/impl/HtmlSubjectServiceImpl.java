package com.ddky.fms.refund.service.impl;

import com.ddky.fms.refund.model.books.BookInfo;
import com.ddky.fms.refund.model.books.SubjectInfo;
import com.ddky.fms.refund.model.books.VersionType;
import com.ddky.fms.refund.model.books.VolumeEnum;
import com.ddky.fms.refund.model.books.chinese.entry.ChineseBook;
import com.ddky.fms.refund.model.students.entry.GradeInfo;
import com.ddky.fms.refund.service.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 科目
 * @Author wanghaikuo
 * @Date 2020/7/6
 **/
@Service
public class HtmlSubjectServiceImpl implements HtmlSubjectService, HtmlDataService {

    private static final Logger logger = LoggerFactory.getLogger(HtmlSchoolServiceImpl.class);

    private static final String school_list_href = "http://www.dzkbw.com";

    private static final int PAGE_SIZE = 10;
    private static final int AREA_LENGTH_2 = 2;
    private static final int AREA_LENGTH_3 = 3;
    private static final int AREA_LENGTH_5 = 5;
    private static final int AREA_LENGTH_7 = 7;

    @Autowired
    private SubjectInfoService subjectInfoService;
    @Autowired
    private DownLoadImageService downLoadImageService;
    @Autowired
    private GradeService gradeService;
    @Autowired
    private VersionTypeService versionTypeService;

    private static final String ROOT_PATH = "E:/images";

    @Override
    public List<? extends BookInfo> listSubjectInfo(String verType, String subType) {
        List<GradeInfo> gradeInfos = gradeService.list();
        List<VersionType> versionTypes =  versionTypeService.list();
        Map<String, GradeInfo> gradeInfoMap = gradeInfos.stream().collect(Collectors.toMap(GradeInfo::getName, Function.identity()));
        Map<String, VersionType> versionTypeMap = versionTypes.stream().collect(Collectors.toMap(VersionType::getName, Function.identity()));
        String url = school_list_href + "/books/" + verType + "/" + subType;
        Document document = getContent(url);
        Element typeContent = document.getElementById("main").getElementsByClass("list mb_list").first();
        List<Element> elLis = typeContent.children().first().children();
        List<ChineseBook> chineseBookList = new ArrayList<>();
        for (Element typeCont : elLis) {
            Element elImg = typeCont.getElementsByTag("img").first();
            String imageUrl = school_list_href + elImg.attr("data-original");
            String imageSavePath = ROOT_PATH + elImg.attr("data-original");
            String name = elImg.attr("alt");
            downLoadImageService.download(imageUrl, imageSavePath);
            logger.info(typeCont.toString());
            ChineseBook chineseBook = new ChineseBook();
            //设置年级
            gradeInfoMap.forEach((key, value) -> {
                if (name.contains(key)) {
                    chineseBook.setBookName(name.replace(key, ""));
                    chineseBook.setGradeId(value.getGradeId());
                }
            });
            //设置版本
            versionTypeMap.forEach((key, value) -> {
                if (chineseBook.getBookName().contains(key)) {
                    chineseBook.setBookName(chineseBook.getBookName().replace(key, ""));
                    chineseBook.setPublisher(value.getVerId());
                }
            });
            //设置卷册
            for (VolumeEnum item : VolumeEnum.values()) {
                if (chineseBook.getBookName().contains(item.getTitle())) {
                    chineseBook.setBookName(chineseBook.getBookName().replace(item.getTitle(), ""));
                    chineseBook.setVolume(item.getCode());
                }
            }
            chineseBook.setShortName(chineseBook.getBookName());
            chineseBook.setTheYear(2020);
            chineseBook.setCoverImage(elImg.attr("data-original"));
            chineseBookList.add(chineseBook);
        }
        return null;
    }
}
