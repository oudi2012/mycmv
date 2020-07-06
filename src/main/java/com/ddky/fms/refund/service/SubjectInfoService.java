package com.ddky.fms.refund.service;

import com.ddky.fms.refund.model.books.SubjectInfo;

import java.util.List;

/***
 * 科目
 * @author oudi
 */
public interface SubjectInfoService {

    /***
     * 列表
     * @return List
     */
    List<SubjectInfo> list();

    /***
     * 详细
     * @param id id
     * @return obj
     */
    SubjectInfo findById(int id);

    /***
     * 添加
     * @param item item
     */
    void insert(SubjectInfo item);

    /***
     * 批量添加
     * @param list list
     */
    void batchInsert(List<SubjectInfo> list);

}
