package com.ddky.fms.refund.mapper.books;

import com.ddky.fms.refund.model.books.political.entry.PoliticalBook;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/***
 * ClassInfo
 * @author oudi
 */
public interface PoliticalBookMapper {

    /***
     * 列表
     * @return List
     */
    List<PoliticalBook> list();

    /***
     * 详细
     * @param bookId id
     * @return obj
     */
    PoliticalBook findById(int bookId);

    /***
     * 添加
     * @param item item
     */
    void insert(PoliticalBook item);

    /***
     * 批量添加
     * @param list list
     */
    void batchInsert(@Param("list")List<PoliticalBook> list);
}
