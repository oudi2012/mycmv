package com.ddky.fms.refund.service.impl;

import com.ddky.fms.refund.mapper.books.SubjectInfoMapper;
import com.ddky.fms.refund.model.books.SubjectInfo;
import com.ddky.fms.refund.service.SubjectInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author wanghaikuo
 * @Date 2020/7/6
 **/
@Service
public class SubjectInfoServiceImpl implements SubjectInfoService {

    @Autowired
    private SubjectInfoMapper subjectInfoMapper;

    @Override
    public List<SubjectInfo> list() {
        return subjectInfoMapper.list();
    }

    @Override
    public SubjectInfo findById(int id) {
        return subjectInfoMapper.findById(id);
    }

    @Override
    public void insert(SubjectInfo item) {
        subjectInfoMapper.insert(item);
    }

    @Override
    public void batchInsert(List<SubjectInfo> list) {
        subjectInfoMapper.batchInsert(list);
    }
}
