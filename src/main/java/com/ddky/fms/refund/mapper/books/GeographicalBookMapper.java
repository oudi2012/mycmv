package com.ddky.fms.refund.mapper.books;

import com.ddky.fms.refund.model.books.geographical.entry.GeographicalBook;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/***
 * ClassInfo
 * @author oudi
 */
public interface GeographicalBookMapper {

    /***
     * 列表
     * @return List
     */
    List<GeographicalBook> list();

    /***
     * 详细
     * @param bookId id
     * @return obj
     */
    GeographicalBook findById(int bookId);

    /***
     * 添加
     * @param item item
     */
    void insert(GeographicalBook item);

    /***
     * 批量添加
     * @param list list
     */
    void batchInsert(@Param("list")List<GeographicalBook> list);
}
