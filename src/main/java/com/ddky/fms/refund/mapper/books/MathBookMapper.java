package com.ddky.fms.refund.mapper.books;

import com.ddky.fms.refund.model.books.maths.entry.MathBook;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/***
 * ClassInfo
 * @author oudi
 */
public interface MathBookMapper {

    /***
     * 列表
     * @return List
     */
    List<MathBook> list();

    /***
     * 详细
     * @param bookId id
     * @return obj
     */
    MathBook findById(int bookId);

    /***
     * 添加
     * @param item item
     */
    void insert(MathBook item);

    /***
     * 批量添加
     * @param list list
     */
    void batchInsert(@Param("list")List<MathBook> list);
}
