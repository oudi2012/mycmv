package com.ddky.fms.refund.mapper.students;

import com.ddky.fms.refund.model.students.entry.SchoolInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/***
 * areaInfo
 * @author oudi
 */
public interface SchoolInfoMapper {

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
    void batchInsert(@Param("list")List<SchoolInfo> list);
}
