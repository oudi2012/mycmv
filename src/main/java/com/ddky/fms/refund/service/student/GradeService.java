package com.ddky.fms.refund.service.student;

import com.ddky.fms.refund.model.students.entry.GradeInfo;

import java.util.List;

/***
 * 年级接口
 * @author oudi
 */
public interface GradeService {

    /***
     * 列表获取
     * @return list
     */
    List<GradeInfo> list();

    /***
     * 详细
     * @param id id
     * @return GradeInfo
     */
    GradeInfo findById(int id);

    /***
     * 添加
     * @param areaInfo areaInfo
     */
    void insert(GradeInfo areaInfo);

    /***
     * 更新
     * @param areaInfo areaInfo
     */
    void update(GradeInfo areaInfo);

    /***
     * 批量添加
     * @param list list
     */
    void batchInsert(List<GradeInfo> list);

}
