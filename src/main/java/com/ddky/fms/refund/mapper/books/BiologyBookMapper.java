package com.ddky.fms.refund.mapper.books;

import com.ddky.fms.refund.model.books.biology.entry.BiologyBook;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/***
 * ClassInfo
 * @author oudi
 */
public interface BiologyBookMapper {

    /***
     * 列表
     * @return List
     */
    List<BiologyBook> list();

    /***
     * 详细
     * @param bookId id
     * @return obj
     */
    BiologyBook findById(int bookId);

    /***
     * 添加
     * @param item item
     */
    void insert(BiologyBook item);

    /***
     * 批量添加
     * @param list list
     */
    void batchInsert(@Param("list")List<BiologyBook> list);
}
