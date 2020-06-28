package com.ddky.fms.refund.mapper.students;

import com.ddky.fms.refund.model.students.entry.AreaInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/***
 * areaInfo
 * @author oudi
 */
public interface AreaInfoMapper {

    /***
     * 列表
     * @return List
     */
    List<AreaInfo> list();

    /***
     * 详细
     * @param areaCode areaCode
     * @return AreaInfo
     */
    AreaInfo findByCode(int areaCode);

    /***
     * 添加
     * @param areaInfo areaInfo
     */
    void insert(AreaInfo areaInfo);

    /***
     * 批量添加
     * @param list list
     */
    void batchInsert(@Param("list")List<AreaInfo> list);
}
