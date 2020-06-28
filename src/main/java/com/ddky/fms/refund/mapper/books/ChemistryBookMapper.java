package com.ddky.fms.refund.mapper.books;

import com.ddky.fms.refund.model.books.chemistry.entry.ChemistryBook;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/***
 * ClassInfo
 * @author oudi
 */
public interface ChemistryBookMapper {

    /***
     * 列表
     * @return List
     */
    List<ChemistryBook> list();

    /***
     * 详细
     * @param bookId id
     * @return obj
     */
    ChemistryBook findById(int bookId);

    /***
     * 添加
     * @param item item
     */
    void insert(ChemistryBook item);

    /***
     * 批量添加
     * @param list list
     */
    void batchInsert(@Param("list")List<ChemistryBook> list);
}
