package com.ddky.fms.refund.mapper.exam;

import com.ddky.fms.refund.model.exam.entry.SelectQuestionOption;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/***
 * SelectQuestionOption
 * @author oudi
 */
public interface SelectQuestionOptionMapper {

    /***
     * 列表
     * @param item item
     * @return List
     */
    List<SelectQuestionOption> list(SelectQuestionOption item);

    /***
     * 详细
     * @param id id
     * @return obj
     */
    SelectQuestionOption findById(int id);

    /***
     * 添加
     * @param item item
     */
    void insert(SelectQuestionOption item);

    /***
     * 批量添加
     * @param list list
     */
    void batchInsert(@Param("list")List<SelectQuestionOption> list);
}
