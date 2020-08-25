package com.ddky.fms.refund.controller.rest.books;

import com.ddky.fms.refund.configuration.CurrentUser;
import com.ddky.fms.refund.model.AbstractUser;
import com.ddky.fms.refund.model.ResponseObject;
import com.ddky.fms.refund.model.base.vo.IdListVo;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/***
 * 对应的接口映射
 * BookInfoApiFunc
 * @author a
 */
public interface BookInfoApiFunc<T> {

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
    ResponseObject create(@CurrentUser AbstractUser user, @RequestBody T item);

    /***
     * 编辑
     * @param user user
     * @param item item
     * @return
     */
    ResponseObject edit(@CurrentUser AbstractUser user,@RequestBody T item);

    /***
     * 批量添加
     * @param user user
     * @param list list
     * @return
     */
    ResponseObject batchCreate(@CurrentUser AbstractUser user, @RequestBody List<T> list);

    /***
     * 删除
     * @param user user
     * @param idListVo idListVo
     * @return
     */
    ResponseObject delete(@CurrentUser AbstractUser user,  @RequestBody IdListVo idListVo);

}
