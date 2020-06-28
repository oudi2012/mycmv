package com.ddky.fms.refund.mapper.books;

import com.ddky.fms.refund.model.books.physic.entry.PhysicBook;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/***
 * ClassInfo
 * @author oudi
 */
public interface PhysicBookMapper {

    /***
     * 列表
     * @return List
     */
    List<PhysicBook> list();

    /***
     * 详细
     * @param bookId id
     * @return obj
     */
    PhysicBook findById(int bookId);

    /***
     * 添加
     * @param item item
     */
    void insert(PhysicBook item);

    /***
     * 批量添加
     * @param list list
     */
    void batchInsert(@Param("list")List<PhysicBook> list);
}
