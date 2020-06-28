package com.ddky.fms.refund.mapper;

import com.ddky.fms.refund.model.userlogs.entry.HomeWork;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/***
 * ClassInfo
 * @author oudi
 */
public interface HomeWorkMapper {

    /***
     * 列表
     * @return List
     */
    List<HomeWork> list();

    /***
     * 详细
     * @param id id
     * @return obj
     */
    HomeWork findById(int id);

    /***
     * 添加
     * @param item item
     */
    void insert(HomeWork item);

    /***
     * 批量添加
     * @param list list
     */
    void batchInsert(@Param("list")List<HomeWork> list);
}
