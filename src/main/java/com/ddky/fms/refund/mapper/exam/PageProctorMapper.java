package com.ddky.fms.refund.mapper.exam;

import com.ddky.fms.refund.model.exam.entry.PageProctor;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/***
 * PageProctor
 * @author oudi
 */
public interface PageProctorMapper {

    /***
     * 列表
     * @param item item
     * @return List
     */
    List<PageProctor> list(PageProctor item);

    /***
     * 详细
     * @param id id
     * @return obj
     */
    PageProctor findById(int id);

    /***
     * 添加
     * @param item item
     */
    void insert(PageProctor item);

    /***
     * 批量添加
     * @param list list
     */
    void batchInsert(@Param("list")List<PageProctor> list);
}
