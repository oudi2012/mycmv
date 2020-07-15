package com.ddky.fms.refund.service.impl;

import com.alibaba.fastjson.JSON;
import com.ddky.fms.refund.constants.LogConstants;
import com.ddky.fms.refund.mapper.students.StudentInfoMapper;
import com.ddky.fms.refund.model.students.entry.StudentInfo;
import com.ddky.fms.refund.service.StudentInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/***
 * StudentInfoService
 * @author a
 */
@Service
public class StudentInfoServiceImpl implements StudentInfoService {

    private static final Logger logger = LoggerFactory.getLogger(LogConstants.STU_LOG);
    private static final String LOG_LIST_PARAM = "StudentInfoServiceImpl -> list param {},{},{}";
    private static final String LOG_LIST_RESULT = "StudentInfoServiceImpl -> list result {}";
    private static final String LOG_FIND_ID = "StudentInfoServiceImpl -> findById param {}";
    private static final String LOG_FIND_ID_RESULT = "StudentInfoServiceImpl -> findById result {}";
    private static final String LOG_FIND_PHONE = "StudentInfoServiceImpl -> findByPhone param {}";
    private static final String LOG_FIND_PHONE_RESULT = "StudentInfoServiceImpl -> findByPhone result {}";
    private static final String LOG_FIND_USERNAME = "StudentInfoServiceImpl -> userName param {}";
    private static final String LOG_FIND_USERNAME_RESULT = "StudentInfoServiceImpl -> userName result {}";
    private static final String LOG_INSERT = "StudentInfoServiceImpl -> insert param {}";
    private static final String LOG_INSERT_LIST = "StudentInfoServiceImpl -> batchInsert param {}";
    private static final String LOG_EDIT = "StudentInfoServiceImpl -> edit param {}";
    private static final String LOG_REMOVE = "StudentInfoServiceImpl -> delete param {}";


    @Autowired
    private StudentInfoMapper studentInfoMapper;

    @Override
    public PageInfo<StudentInfo> list(StudentInfo studentInfo, int pageIndex, int pageSize) {
        logger.info(LOG_LIST_PARAM, JSON.toJSONString(studentInfo), pageIndex, pageSize);
        PageHelper.startPage(pageIndex, pageSize).setOrderBy(" id desc");
        List<StudentInfo> studentInfos = studentInfoMapper.list(studentInfo);
        logger.info(LOG_LIST_RESULT, JSON.toJSONString(studentInfos));
        if (CollectionUtils.isEmpty(studentInfos)) {
            return new PageInfo<>();
        }
        return new PageInfo<>(studentInfos);
    }

    @Override
    public StudentInfo findById(Long id) {
        logger.info(LOG_FIND_ID, id);
        StudentInfo result = studentInfoMapper.findById(id);
        logger.info(LOG_FIND_ID_RESULT, result);
        return result;
    }

    @Override
    public StudentInfo findByPhone(String phone) {
        logger.info(LOG_FIND_PHONE, phone);
        StudentInfo param = new StudentInfo();
        param.setPhone(phone);
        StudentInfo result = studentInfoMapper.findOne(param);
        logger.info(LOG_FIND_PHONE_RESULT, result);
        return result;
    }

    @Override
    public StudentInfo findByUserName(String userName) {
        logger.info(LOG_FIND_USERNAME, userName);
        StudentInfo param = new StudentInfo();
        param.setUserName(userName);
        StudentInfo result = studentInfoMapper.findOne(param);
        logger.info(LOG_FIND_USERNAME_RESULT, result);
        return result;
    }

    @Override
    public void insert(StudentInfo item) {
        logger.info(LOG_INSERT, JSON.toJSONString(item));
        studentInfoMapper.insert(item);
    }

    @Override
    public void batchInsert(List<StudentInfo> list) {
        logger.info(LOG_INSERT_LIST, JSON.toJSONString(list));
        studentInfoMapper.batchInsert(list);
    }

    @Override
    public int edit(StudentInfo item) {
        logger.info(LOG_EDIT, JSON.toJSONString(item));
        return studentInfoMapper.edit(item);
    }

    @Override
    public int delete(List<Long> idList) {
        logger.info(LOG_REMOVE, JSON.toJSONString(idList));
        return studentInfoMapper.delete(idList);
    }
}
