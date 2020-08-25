package com.ddky.fms.refund.service.book;

import com.ddky.fms.refund.model.books.entry.SubjectInfo;

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
     * 详细
     * @param name name
     * @return obj
     */
    SubjectInfo findByName(String name);

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

    /***
     * 更新
     * @param item item
     */
    void update(SubjectInfo item);

    /***
     * 删除
     * @param idList idList
     * @return int
     */
    int delete(List<Long> idList);

}
