package com.ddky.fms.refund.mapper.exam;

import com.ddky.fms.refund.model.exam.entry.PageSelectItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/***
 * PageSelectItem
 * @author oudi
 */
public interface PageSelectItemMapper {

    /***
     * 列表
     * @param item item
     * @return List
     */
    List<PageSelectItem> list(PageSelectItem item);

    /***
     * 详细
     * @param id id
     * @return obj
     */
    PageSelectItem findById(int id);

    /***
     * 添加
     * @param item item
     */
    void insert(PageSelectItem item);

    /***
     * 批量添加
     * @param list list
     */
    void batchInsert(@Param("list")List<PageSelectItem> list);
}
