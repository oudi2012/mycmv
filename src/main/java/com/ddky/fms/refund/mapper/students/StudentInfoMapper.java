package com.ddky.fms.refund.mapper.students;

import com.ddky.fms.refund.model.students.entry.StudentInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/***
 * GradeInfo
 * @author oudi
 */
public interface StudentInfoMapper {

    /***
     * 列表
     * @return List
     */
    List<StudentInfo> list();

    /***
     * 详细
     * @param id id
     * @return obj
     */
    StudentInfo findById(int id);

    /***
     * 添加
     * @param item item
     */
    void insert(StudentInfo item);

    /***
     * 批量添加
     * @param list list
     */
    void batchInsert(@Param("list")List<StudentInfo> list);
}
