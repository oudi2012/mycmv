package com.ddky.fms.refund.mapper;

import com.ddky.fms.refund.model.books.SubjectInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/***
 * SubjectInfo
 * @author oudi
 */
public interface SubjectInfoMapper {

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
    void batchInsert(@Param("list")List<SubjectInfo> list);
}
