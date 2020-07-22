package com.ddky.fms.refund.mapper.exam;

import com.ddky.fms.refund.model.exam.entry.FillQuestionOption;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/***
 * FillQuestionOption
 * @author oudi
 */
public interface FillQuestionOptionMapper {

    /***
     * 列表
     * @param item item
     * @return List
     */
    List<FillQuestionOption> list(FillQuestionOption item);

    /***
     * 详细
     * @param id id
     * @return obj
     */
    FillQuestionOption findById(int id);

    /***
     * 添加
     * @param item item
     */
    void insert(FillQuestionOption item);

    /***
     * 批量添加
     * @param list list
     */
    void batchInsert(@Param("list")List<FillQuestionOption> list);
}
