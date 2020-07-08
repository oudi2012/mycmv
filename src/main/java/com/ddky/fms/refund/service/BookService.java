package com.ddky.fms.refund.service;

import com.ddky.fms.refund.model.books.BookInfo;
import com.github.pagehelper.PageInfo;

import java.util.List;

/***
 * 课本接口
 * @author oudi
 */
public interface BookService<T extends BookInfo> {

    /***
     * 分页显示
     * @param t t
     * @param pageIndex pageIndex
     * @param pageSize pageSize
     * @return PageInfo
     */
    PageInfo<T> pageList(T t, int pageIndex, int pageSize);

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
