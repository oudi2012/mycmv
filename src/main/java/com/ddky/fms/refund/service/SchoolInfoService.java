package com.ddky.fms.refund.service;

import com.ddky.fms.refund.model.students.entry.SchoolInfo;

import java.util.List;

/***
 * 学校
 * @author oudi
 */
public interface SchoolInfoService {

    /***
     * 列表
     * @return List
     */
    List<SchoolInfo> list();

    /***
     * 详细
     * @param id areaCode
     * @return SchoolInfo
     */
    SchoolInfo findById(int id);

    /***
     * 添加
     * @param item item
     */
    void insert(SchoolInfo item);

    /***
     * 批量添加
     * @param list list
     */
    void batchInsert(List<SchoolInfo> list);

}
