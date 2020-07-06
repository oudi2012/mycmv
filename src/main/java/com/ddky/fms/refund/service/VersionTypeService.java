package com.ddky.fms.refund.service;

import com.ddky.fms.refund.model.books.VersionType;

import java.util.List;

/***
 * 版本类型
 * @author oudi
 */
public interface VersionTypeService {

    /***
     * 列表获取
     * @return list
     */
    List<VersionType> list();

    /***
     * 详细
     * @param id id
     * @return GradeInfo
     */
    VersionType findById(int id);

    /***
     * 添加
     * @param item item
     */
    void insert(VersionType item);

    /***
     * 批量添加
     * @param list list
     */
    void batchInsert(List<VersionType> list);

}
