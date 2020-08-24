package com.ddky.fms.refund.controller.rest.books;

import com.ddky.fms.refund.configuration.CurrentUser;
import com.ddky.fms.refund.model.AbstractUser;
import com.ddky.fms.refund.model.ResponseObject;
import com.ddky.fms.refund.model.books.BookInfo;

import java.util.List;

/***
 * 对应的接口映射
 * BookInfoApiFunc
 * @author a
 */
public interface BookInfoApiFunc<T extends BookInfo> {

    /***
     * 分页显示
     * @param user user
     * @param t    t
     * @param pageIndex pageIndex
     * @param pageSize pageSize
     * @return
     */
    ResponseObject pageList(@CurrentUser AbstractUser user, T t, int pageIndex, int pageSize);

    /***
     * 列表
     * @param user user
     * @param t t
     * @return
     */
    ResponseObject list(@CurrentUser AbstractUser user, T t);

    /***
     * 详细
     * @param user user
     * @param bookId bookId
     * @return
     */
    ResponseObject findById(@CurrentUser AbstractUser user, int bookId);

    /***
     * 添加
     * @param user user
     * @param item item
     * @return
     */
    ResponseObject create(@CurrentUser AbstractUser user, T item);

    /***
     * 批量添加
     * @param user user
     * @param list list
     * @return
     */
    ResponseObject batchCreate(@CurrentUser AbstractUser user, List<T> list);

}
