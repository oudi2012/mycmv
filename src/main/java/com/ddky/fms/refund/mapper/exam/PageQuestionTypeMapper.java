package com.ddky.fms.refund.mapper.exam;

import com.ddky.fms.refund.model.exam.entry.PageQuestionType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/***
 * PageQuestionType
 * @author oudi
 */
public interface PageQuestionTypeMapper {

    /***
     * 列表
     * @param item item
     * @return List
     */
    List<PageQuestionType> list(PageQuestionType item);

    /***
     * 详细
     * @param id id
     * @return obj
     */
    PageQuestionType findById(int id);

    /***
     * 添加
     * @param item item
     */
    void insert(PageQuestionType item);

    /***
     * 批量添加
     * @param list list
     */
    void batchInsert(@Param("list")List<PageQuestionType> list);
}
