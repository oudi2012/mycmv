package com.ddky.fms.refund.mapper.userlogs;

import com.ddky.fms.refund.model.students.entry.ClassInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/***
 * ClassInfo
 * @author oudi
 */
public interface ClassInfoMapper {

    /***
     * 列表
     * @return List
     */
    List<ClassInfo> list();

    /***
     * 详细
     * @param id id
     * @return obj
     */
    ClassInfo findById(int id);

    /***
     * 添加
     * @param item item
     */
    void insert(ClassInfo item);

    /***
     * 批量添加
     * @param list list
     */
    void batchInsert(@Param("list")List<ClassInfo> list);
}
