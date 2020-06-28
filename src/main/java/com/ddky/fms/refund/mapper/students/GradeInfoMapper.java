package com.ddky.fms.refund.mapper.students;

import com.ddky.fms.refund.model.students.entry.GradeInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/***
 * GradeInfo
 * @author oudi
 */
public interface GradeInfoMapper {

    /***
     * 列表
     * @return List
     */
    List<GradeInfo> list();

    /***
     * 详细
     * @param id id
     * @return obj
     */
    GradeInfo findById(int id);

    /***
     * 添加
     * @param item item
     */
    void insert(GradeInfo item);

    /***
     * 批量添加
     * @param list list
     */
    void batchInsert(@Param("list")List<GradeInfo> list);
}
