package com.ddky.fms.refund.mapper.exam;

import com.ddky.fms.refund.model.exam.entry.PaperInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/***
 * PaperInfo
 * @author oudi
 */
public interface PaperInfoMapper {

    /***
     * 列表
     * @param item item
     * @return List
     */
    List<PaperInfo> list(PaperInfo item);

    /***
     * 详细
     * @param id id
     * @return obj
     */
    PaperInfo findById(int id);

    /***
     * 添加
     * @param item item
     */
    void insert(PaperInfo item);

    /***
     * 批量添加
     * @param list list
     */
    void batchInsert(@Param("list")List<PaperInfo> list);
}
