package com.ddky.fms.refund.service.impl;

import com.ddky.fms.refund.mapper.students.SchoolInfoMapper;
import com.ddky.fms.refund.model.students.entry.SchoolInfo;
import com.ddky.fms.refund.service.SchoolInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author wanghaikuo
 * @Date 2020/7/3
 **/
@Service
public class SchoolInfoServiceImpl implements SchoolInfoService {

    private static final Logger logger = LoggerFactory.getLogger(SchoolInfoServiceImpl.class);

    @Autowired
    private SchoolInfoMapper schoolInfoMapper;


    @Override
    public List<SchoolInfo> list() {
        return schoolInfoMapper.list();
    }

    @Override
    public SchoolInfo findById(int id) {
        return schoolInfoMapper.findById(id);
    }

    @Override
    public void insert(SchoolInfo item) {
        schoolInfoMapper.insert(item);
    }

    @Override
    public void batchInsert(List<SchoolInfo> list) {
        schoolInfoMapper.batchInsert(list);
    }
}
