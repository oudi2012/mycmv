package com.ddky.fms.refund.mapper.exam;

import com.ddky.fms.refund.model.exam.entry.PageResultInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/***
 * PageResultInfo
 * @author oudi
 */
public interface PageResultInfoMapper {

    /***
     * 列表
     * @param item item
     * @return List
     */
    List<PageResultInfo> list(PageResultInfo item);

    /***
     * 详细
     * @param id id
     * @return obj
     */
    PageResultInfo findById(int id);

    /***
     * 添加
     * @param item item
     */
    void insert(PageResultInfo item);

    /***
     * 批量添加
     * @param list list
     */
    void batchInsert(@Param("list")List<PageResultInfo> list);
}
