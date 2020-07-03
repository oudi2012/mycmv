package com.ddky.fms.refund.service;

import com.ddky.fms.refund.model.students.entry.AreaInfo;
import com.github.pagehelper.PageInfo;

import java.util.List;

/***
 * 地区接口
 * @author oudi
 */
public interface AreaInfoService {

    /***
     * 省级列表
     * @return List
     */
    List<AreaInfo> listProvince();

    /***
     * 地级列表
     * @param provinceId provinceId
     * @return
     */
    List<AreaInfo> listCities(Integer provinceId);

    /***
     * 县级级列表
     * @param cityId cityId
     * @return
     */
    List<AreaInfo> listTown(Integer cityId);

    /***
     * 列表获取
     * @param areaInfo areaInfo
     * @return list
     */
    PageInfo<AreaInfo> list(AreaInfo areaInfo);

    /***
     * 详细
     * @param areaCode areaCode
     * @return AreaInfo
     */
    AreaInfo findByCode(int areaCode);

    /***
     * 添加
     * @param areaInfo areaInfo
     */
    void insert(AreaInfo areaInfo);

    /***
     * 批量添加
     * @param list list
     */
    void batchInsert(List<AreaInfo> list);
}
