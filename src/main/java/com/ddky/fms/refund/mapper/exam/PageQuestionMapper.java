package com.ddky.fms.refund.mapper.exam;

import com.ddky.fms.refund.model.exam.entry.PageQuestion;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/***
 * PageQuestion
 * @author oudi
 */
public interface PageQuestionMapper {

    /***
     * 列表
     * @param item item
     * @return List
     */
    List<PageQuestion> list(PageQuestion item);

    /***
     * 详细
     * @param id id
     * @return obj
     */
    PageQuestion findById(int id);

    /***
     * 添加
     * @param item item
     */
    void insert(PageQuestion item);

    /***
     * 批量添加
     * @param list list
     */
    void batchInsert(@Param("list")List<PageQuestion> list);
}
