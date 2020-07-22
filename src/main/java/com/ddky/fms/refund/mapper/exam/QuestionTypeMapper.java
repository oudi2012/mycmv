package com.ddky.fms.refund.mapper.exam;

import com.ddky.fms.refund.model.exam.entry.QuestionType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/***
 * QuestionType
 * @author oudi
 */
public interface QuestionTypeMapper {

    /***
     * 列表
     * @param item item
     * @return List
     */
    List<QuestionType> list(QuestionType item);

    /***
     * 详细
     * @param id id
     * @return obj
     */
    QuestionType findById(int id);

    /***
     * 添加
     * @param item item
     */
    void insert(QuestionType item);

    /***
     * 批量添加
     * @param list list
     */
    void batchInsert(@Param("list")List<QuestionType> list);
}
