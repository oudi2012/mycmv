package com.ddky.fms.refund.mapper.exam;

import com.ddky.fms.refund.model.exam.entry.FillQuestion;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/***
 * FillQuestion
 * @author oudi
 */
public interface FillQuestionMapper {

    /***
     * 列表
     * @param item item
     * @return List
     */
    List<FillQuestion> list(FillQuestion item);

    /***
     * 详细
     * @param id id
     * @return obj
     */
    FillQuestion findById(int id);

    /***
     * 添加
     * @param item item
     */
    void insert(FillQuestion item);

    /***
     * 批量添加
     * @param list list
     */
    void batchInsert(@Param("list")List<FillQuestion> list);
}
