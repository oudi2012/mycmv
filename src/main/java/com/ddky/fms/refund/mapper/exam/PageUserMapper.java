package com.ddky.fms.refund.mapper.exam;

import com.ddky.fms.refund.model.exam.entry.PageUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/***
 * PageUser
 * @author oudi
 */
public interface PageUserMapper {

    /***
     * 列表
     * @param item item
     * @return List
     */
    List<PageUser> list(PageUser item);

    /***
     * 详细
     * @param id id
     * @return obj
     */
    PageUser findById(int id);

    /***
     * 添加
     * @param item item
     */
    void insert(PageUser item);

    /***
     * 批量添加
     * @param list list
     */
    void batchInsert(@Param("list")List<PageUser> list);
}
