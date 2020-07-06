package com.ddky.fms.refund.service;

import com.ddky.fms.refund.model.books.BookInfo;

import java.util.List;

/***
 * 科目
 * @author oudi
 */
public interface HtmlSubjectService {

    /***
     * 获取课本信息
     * @param verType
     * @param subType
     * @return
     */
    List<? extends BookInfo> listSubjectInfo(String verType, String subType);
}
