package com.ddky.fms.refund.mapper.students;

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
     * @param item item
     * @return List
     */
    List<TeacherInfo> list(TeacherInfo item);

    /***
     * 详细
     * @param id id
     * @return obj
     */
    TeacherInfo findById(Long id);

    /***
     * 详细
     * @param item
     * @return
     */
    TeacherInfo findOne(TeacherInfo item);

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

    /***
     * 编辑
     * @param item item
     * @return int
     */
    int edit(TeacherInfo item);

    /***
     * 删除
     * @param idList idList
     * @return int
     */
    int delete(@Param("idList") List<Long> idList);
}
