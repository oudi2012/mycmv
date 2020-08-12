package com.ddky.fms.refund.service.impl;

import com.ddky.fms.refund.mapper.books.VersionTypeMapper;
import com.ddky.fms.refund.model.books.VersionType;
import com.ddky.fms.refund.service.VersionTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author wanghaikuo
 * @Date 2020/7/6
 **/
@Service
public class VersionTypeServiceImpl implements VersionTypeService {

    @Resource
    private VersionTypeMapper versionTypeMapper;

    @Override
    public List<VersionType> list() {
        return versionTypeMapper.list();
    }

    @Override
    public VersionType findById(int id) {
        return versionTypeMapper.findById(id);
    }

    @Override
    public void insert(VersionType item) {
        versionTypeMapper.insert(item);
    }

    @Override
    public void update(VersionType item) {
        versionTypeMapper.update(item);
    }

    @Override
    public void batchInsert(List<VersionType> list) {
        versionTypeMapper.batchInsert(list);
    }
}
