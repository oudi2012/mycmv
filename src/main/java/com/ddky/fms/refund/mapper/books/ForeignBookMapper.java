package com.ddky.fms.refund.mapper.books;

import com.ddky.fms.refund.model.books.foreign.entry.ForeignBook;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/***
 * ClassInfo
 * @author oudi
 */
public interface ForeignBookMapper {

    /***
     * 列表
     * @return List
     */
    List<ForeignBook> list();

    /***
     * 详细
     * @param bookId id
     * @return obj
     */
    ForeignBook findById(int bookId);

    /***
     * 添加
     * @param item item
     */
    void insert(ForeignBook item);

    /***
     * 批量添加
     * @param list list
     */
    void batchInsert(@Param("list")List<ForeignBook> list);
}
