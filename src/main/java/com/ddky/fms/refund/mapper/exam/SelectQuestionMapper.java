package com.ddky.fms.refund.mapper.exam;

import com.ddky.fms.refund.model.exam.entry.SelectQuestion;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/***
 * SelectQuestion
 * @author oudi
 */
public interface SelectQuestionMapper {

    /***
     * 列表
     * @param item item
     * @return List
     */
    List<SelectQuestion> list(SelectQuestion item);

    /***
     * 详细
     * @param id id
     * @return obj
     */
    SelectQuestion findById(int id);

    /***
     * 添加
     * @param item item
     */
    void insert(SelectQuestion item);

    /***
     * 批量添加
     * @param list list
     */
    void batchInsert(@Param("list")List<SelectQuestion> list);
}
