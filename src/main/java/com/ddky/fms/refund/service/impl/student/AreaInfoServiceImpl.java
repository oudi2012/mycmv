package com.ddky.fms.refund.service.impl.student;

import com.ddky.fms.refund.mapper.students.AreaInfoMapper;
import com.ddky.fms.refund.model.students.entry.AreaInfo;
import com.ddky.fms.refund.service.student.AreaInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author a
 */
@Service
public class AreaInfoServiceImpl implements AreaInfoService {

    @Autowired
    private AreaInfoMapper areaInfoMapper;

    @Override
    public List<AreaInfo> listProvince() {
        AreaInfo areaInfo = new AreaInfo();
        areaInfo.setParentCode(0);
        return areaInfoMapper.list(areaInfo);
    }

    @Override
    public List<AreaInfo> listCities(Integer provinceId) {
        AreaInfo areaInfo = new AreaInfo();
        areaInfo.setParentCode(provinceId);
        return areaInfoMapper.list(areaInfo);
    }

    @Override
    public List<AreaInfo> listTown(Integer cityId) {
        AreaInfo areaInfo = new AreaInfo();
        areaInfo.setParentCode(cityId);
        return areaInfoMapper.list(areaInfo);
    }

    @Override
    public PageInfo<AreaInfo> list(AreaInfo areaInfo) {
        PageHelper.startPage(areaInfo.getPageIndex(), areaInfo.getPageSize()).setOrderBy(" areaCode asc");
        List<AreaInfo> areaInfoList = areaInfoMapper.list(areaInfo);
        if (CollectionUtils.isEmpty(areaInfoList)) {
            return new PageInfo<>();
        }
        return new PageInfo<>(areaInfoList);
    }

    @Override
    public AreaInfo findByCode(int areaCode) {
        return areaInfoMapper.findByCode(areaCode);
    }

    @Override
    public void insert(AreaInfo areaInfo) {
        areaInfoMapper.insert(areaInfo);
    }

    @Override
    public void batchInsert(List<AreaInfo> list) {
        areaInfoMapper.batchInsert(list);
    }

    @Override
    public List<AreaInfo> listByNames(String provinceName, String cityName, String townName) {
        return areaInfoMapper.listByNames(provinceName, cityName, townName);
    }
}
