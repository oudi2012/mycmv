package com.ddky.fms.refund.mapper.exam;

import com.ddky.fms.refund.model.exam.entry.AskQuestionOption;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/***
 * AskQuestionOption
 * @author oudi
 */
public interface AskQuestionOptionMapper {

    /***
     * 列表
     * @param item item
     * @return List
     */
    List<AskQuestionOption> list(AskQuestionOption item);

    /***
     * 详细
     * @param id id
     * @return obj
     */
    AskQuestionOption findById(int id);

    /***
     * 添加
     * @param item item
     */
    void insert(AskQuestionOption item);

    /***
     * 批量添加
     * @param list list
     */
    void batchInsert(@Param("list")List<AskQuestionOption> list);
}
