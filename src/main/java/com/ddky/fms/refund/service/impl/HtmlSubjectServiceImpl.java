package com.ddky.fms.refund.service.impl;

import com.ddky.fms.refund.model.books.BookInfo;
import com.ddky.fms.refund.model.books.SubjectInfo;
import com.ddky.fms.refund.service.HtmlDataService;
import com.ddky.fms.refund.service.HtmlSubjectService;
import com.ddky.fms.refund.service.SubjectInfoService;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 科目
 * @Author wanghaikuo
 * @Date 2020/7/6
 **/
@Service
public class HtmlSubjectServiceImpl implements HtmlSubjectService, HtmlDataService {

    private static final Logger logger = LoggerFactory.getLogger(HtmlSchoolServiceImpl.class);

    private static final String school_list_href = "http://www.dzkbw.com/books/rjb/yuwen/";

    private static final int PAGE_SIZE = 10;
    private static final int AREA_LENGTH_2 = 2;
    private static final int AREA_LENGTH_3 = 3;
    private static final int AREA_LENGTH_5 = 5;
    private static final int AREA_LENGTH_7 = 7;

    @Autowired
    private SubjectInfoService subjectInfoService;

    @Override
    public List<? extends BookInfo> listSubjectInfo(String verType, String subType) {
        String url = school_list_href + "/" + verType + "/" + subType;
        Document document = getContent(url);
        Element typeContent = document.getElementById("main").getElementsByClass("list mb_list").first();
        List<Element> elLis = typeContent.children();
        for (Element typeCont : elLis) {
           logger.info(typeCont.toString());
        }
        return null;
    }
}
