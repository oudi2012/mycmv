package com.ddky.fms.refund.service.student;

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
     * 根据名称获取各级信息
     * @param provinceName provinceName
     * @param cityName cityName
     * @param townName townName
     * @return
     */
    List<AreaInfo> listByNames(String provinceName, String cityName, String townName);

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
     * 更新
     * @param areaInfo areaInfo
     * @return AreaInfo
     */
    AreaInfo editByCode(AreaInfo areaInfo);

    /***
     * 删除
     * @param areaCode areaCode
     */
    void removeByCode(int areaCode);

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
