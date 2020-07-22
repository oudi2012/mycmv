package com.ddky.fms.refund.mapper.exam;

import com.ddky.fms.refund.model.exam.entry.HardLevel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/***
 * HardLevel
 * @author oudi
 */
public interface HardLevelMapper {

    /***
     * 列表
     * @param item item
     * @return List
     */
    List<HardLevel> list(HardLevel item);

    /***
     * 详细
     * @param id id
     * @return obj
     */
    HardLevel findById(int id);

    /***
     * 添加
     * @param item item
     */
    void insert(HardLevel item);

    /***
     * 批量添加
     * @param list list
     */
    void batchInsert(@Param("list")List<HardLevel> list);
}
