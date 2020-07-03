package com.ddky.fms.refund.service.impl;

import com.alibaba.fastjson.JSON;
import com.ddky.fms.refund.model.books.wyw.entry.ArticleInfo;
import com.ddky.fms.refund.model.students.entry.AreaInfo;
import com.ddky.fms.refund.model.students.entry.SchoolInfo;
import com.ddky.fms.refund.service.AreaInfoService;
import com.ddky.fms.refund.service.HtmlDataService;
import com.ddky.fms.refund.service.HtmlSchoolService;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/***
 * @author a
 */
@Service
public class HtmlSchoolServiceImpl implements HtmlSchoolService, HtmlDataService {

    private static final Logger logger = LoggerFactory.getLogger(HtmlSchoolServiceImpl.class);

    private static final String school_list_href = "http://xuexiao.51sxue.com/slist/?t=2";

    private static final int PAGE_SIZE = 10;
    private static final int AREA_LENGTH_2 = 2;
    private static final int AREA_LENGTH_3 = 3;
    private static final int AREA_LENGTH_5 = 5;
    private static final int AREA_LENGTH_7 = 7;

    @Autowired
    private AreaInfoService areaInfoService;

    @Override
    public List<SchoolInfo> listSchoolInfo(int pageIndex) {
        String url = school_list_href + "&page=" + pageIndex;
        Document document = getContent(url);
        Elements typeContents = document.getElementsByClass("school_main");
        Element typeCont = typeContents.first();
        for (int idx = 1; idx <= PAGE_SIZE; idx++) {
            Element span = typeCont.getElementById("list" + idx);
            fromElement(span);
        }
        return null;
    }


    /***
     * html转换为对象数据
     * @param span span
     * @return SchoolInfo
     */
    private SchoolInfo fromElement(Element span) {
        if (ObjectUtils.isEmpty(span)) {
            return null;
        }
        Element nameEle = span.getElementsByClass("school_m_main fl").first().child(0).child(0).child(0);
        if (StringUtils.isEmpty(nameEle.ownText())) {
            return null;
        }
        SchoolInfo schoolInfo = new SchoolInfo();
        schoolInfo.setName(nameEle.ownText());
        schoolInfo.setHref(nameEle.attr("href"));
        schoolInfo.setShortName(nameEle.ownText());
        schoolInfo.setCountry(86);
        Element areaEle = span.getElementsByClass("school_m_main fl").first().child(1).child(0);
        if (!StringUtils.isEmpty(areaEle.ownText())) {
            String[] areaArr = areaEle.ownText().split(" ");
            String provinceName = areaArr[0];
            if (provinceName.length() > AREA_LENGTH_2) {
                provinceName = provinceName.substring(0, 2);
            }
            String cityName = areaArr[1];
            String townName = null;
            if (areaArr.length == AREA_LENGTH_3) {
                townName = areaArr[2];
            }
            logger.info("provinceName:{},cityName:{},townName:{}",provinceName, cityName, townName);
            List<AreaInfo> areaInfoList = areaInfoService.listByNames(provinceName, cityName, townName);
            logger.info("areaInfoList:{}", JSON.toJSONString(areaInfoList));
            if (!CollectionUtils.isEmpty(areaInfoList)) {
                Map<Integer, AreaInfo> areaInfoMap = areaInfoList.stream().collect(Collectors.toMap(AreaInfo::getAreaCode, Function.identity()));
                areaInfoMap.forEach((key, value) -> {
                    if (String.valueOf(key).length() == AREA_LENGTH_3) {
                        schoolInfo.setProvince(key);
                    }
                    if (String.valueOf(key).length() == AREA_LENGTH_5) {
                        schoolInfo.setCity(key);
                    }
                    if (String.valueOf(key).length() == AREA_LENGTH_7) {
                        schoolInfo.setTown(key);
                    }
                });
            }
        }
        Element cateEle = span.getElementsByClass("school_m_main fl").first().child(3).child(1).child(0);
        if (!StringUtils.isEmpty(cateEle.ownText())) {
            schoolInfo.setWeight(cateEle.ownText());
        }
        Element addressEle = span.getElementsByClass("school_dz").first().child(0);
        if (!StringUtils.isEmpty(addressEle.ownText())) {
            schoolInfo.setAddress(addressEle.ownText());
        }
        logger.info("schoolInfo:{}", JSON.toJSONString(schoolInfo));
        return schoolInfo;
    }
}
