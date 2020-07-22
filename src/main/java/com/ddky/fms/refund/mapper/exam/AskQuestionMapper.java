package com.ddky.fms.refund.mapper.exam;

import com.ddky.fms.refund.model.exam.entry.AskQuestion;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/***
 * AskQuestion
 * @author oudi
 */
public interface AskQuestionMapper {

    /***
     * 列表
     * @param item item
     * @return List
     */
    List<AskQuestion> list(AskQuestion item);

    /***
     * 详细
     * @param id id
     * @return obj
     */
    AskQuestion findById(int id);

    /***
     * 添加
     * @param item item
     */
    void insert(AskQuestion item);

    /***
     * 批量添加
     * @param list list
     */
    void batchInsert(@Param("list")List<AskQuestion> list);
}
