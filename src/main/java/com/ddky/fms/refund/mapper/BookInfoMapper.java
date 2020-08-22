package com.ddky.fms.refund.mapper;


import com.ddky.fms.refund.model.books.BookInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/***
 * @author a
 * @param <T>
 */
public interface BookInfoMapper<T extends BookInfo> {

    /***
     * 列表
     * @param t t
     * @return List
     */
    List<T> list(T t);

    /***
     * 详细
     * @param bookId id
     * @return obj
     */
    T findById(int bookId);

    /***
     * 添加
     * @param item item
     */
    void insert(T item);

    /***
     * 批量添加
     * @param list list
     */
    void batchInsert(@Param("list")List<T> list);
}