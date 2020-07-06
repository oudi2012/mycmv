package com.ddky.fms.refund.service;

import com.ddky.fms.refund.model.books.SubjectInfo;

import java.util.List;

/***
 * 科目
 * @author oudi
 */
public interface HtmlSubjectService {

    /***
     * 根据xpath 获取科目信息
     * @param pageIndex
     * @return
     */
    List<SubjectInfo> listSubjectInfo(int pageIndex);
}
