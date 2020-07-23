package com.ddky.fms.refund.service.impl.student;

import com.ddky.fms.refund.mapper.students.SchoolInfoMapper;
import com.ddky.fms.refund.model.students.entry.SchoolInfo;
import com.ddky.fms.refund.service.student.SchoolInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

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
    public PageInfo<SchoolInfo> list(SchoolInfo schoolInfo, int pageIndex, int pageSize) {
        PageHelper.startPage(pageIndex, pageSize).setOrderBy(" schoolId desc ");
        List<SchoolInfo> schoolInfoList = schoolInfoMapper.list(schoolInfo);
        if (CollectionUtils.isEmpty(schoolInfoList)) {
            return new PageInfo<>();
        }
        return new PageInfo<>(schoolInfoList);
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
