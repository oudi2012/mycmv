package com.ddky.fms.refund.service;

import com.ddky.fms.refund.model.books.BookInfo;

import java.util.List;

/***
 * 课本接口
 * @author oudi
 */
public interface BookService<T extends BookInfo> {

    /***
     * 列表
     * @return List
     */
    List<T> list();

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
    void batchInsert(List<T> list);

}
