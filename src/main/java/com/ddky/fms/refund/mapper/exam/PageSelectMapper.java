package com.ddky.fms.refund.mapper.exam;

import com.ddky.fms.refund.model.exam.entry.PageSelect;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/***
 * PageSelect
 * @author oudi
 */
public interface PageSelectMapper {

    /***
     * 列表
     * @param item item
     * @return List
     */
    List<PageSelect> list(PageSelect item);

    /***
     * 详细
     * @param id id
     * @return obj
     */
    PageSelect findById(int id);

    /***
     * 添加
     * @param item item
     */
    void insert(PageSelect item);

    /***
     * 批量添加
     * @param list list
     */
    void batchInsert(@Param("list")List<PageSelect> list);
}
