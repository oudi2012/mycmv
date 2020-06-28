package com.ddky.fms.refund.mapper.userlogs;

import com.ddky.fms.refund.model.students.entry.TeacherInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/***
 * GradeInfo
 * @author oudi
 */
public interface TeacherInfoMapper {

    /***
     * 列表
     * @return List
     */
    List<TeacherInfo> list();

    /***
     * 详细
     * @param id id
     * @return obj
     */
    TeacherInfo findById(int id);

    /***
     * 添加
     * @param item item
     */
    void insert(TeacherInfo item);

    /***
     * 批量添加
     * @param list list
     */
    void batchInsert(@Param("list")List<TeacherInfo> list);
}
