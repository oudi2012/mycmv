package com.ddky.fms.refund.mapper.books;

import com.ddky.fms.refund.model.books.history.entry.HistoryBook;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/***
 * ClassInfo
 * @author oudi
 */
public interface HistoryBookMapper {

    /***
     * 列表
     * @return List
     */
    List<HistoryBook> list();

    /***
     * 详细
     * @param bookId id
     * @return obj
     */
    HistoryBook findById(int bookId);

    /***
     * 添加
     * @param item item
     */
    void insert(HistoryBook item);

    /***
     * 批量添加
     * @param list list
     */
    void batchInsert(@Param("list")List<HistoryBook> list);
}
