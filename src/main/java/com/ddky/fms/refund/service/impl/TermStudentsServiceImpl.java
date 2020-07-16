package com.ddky.fms.refund.service.impl;

import com.alibaba.fastjson.JSON;
import com.ddky.fms.refund.constants.LogConstants;
import com.ddky.fms.refund.mapper.term.TermStudentsMapper;
import com.ddky.fms.refund.model.term.entry.TermStudents;
import com.ddky.fms.refund.service.TermStudentsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/***
 * 学期 TermStudents
 * @author a
 */
@Service
public class TermStudentsServiceImpl implements TermStudentsService {

    private static final Logger logger = LoggerFactory.getLogger(LogConstants.STU_LOG);

    private static final String LOG_LIST_PARAM = "list param {},{},{}";
    private static final String LOG_LIST_RESULT = "list result {}";
    private static final String LOG_FIND_ID = "findById param {}";
    private static final String LOG_FIND_ID_RESULT = "findById result {}";
    private static final String LOG_FIND_PHONE = "findByPhone param {}";
    private static final String LOG_FIND_PHONE_RESULT = "findByPhone result {}";
    private static final String LOG_FIND_USERNAME = "userName param {}";
    private static final String LOG_FIND_USERNAME_RESULT = "userName result {}";
    private static final String LOG_INSERT = "insert param {}";
    private static final String LOG_INSERT_LIST = "batchInsert param {}";
    private static final String LOG_EDIT = "edit param {}";
    private static final String LOG_REMOVE = "delete param {}";

    @Autowired
    private TermStudentsMapper termBooksMapper;

    @Override
    public PageInfo<TermStudents> list(TermStudents termStudents, int pageIndex, int pageSize) {
        logger.info(LOG_LIST_PARAM, JSON.toJSONString(termStudents), pageIndex, pageSize);
        PageHelper.startPage(pageIndex, pageSize).setOrderBy(" teamId desc");
        List<TermStudents> termStudentsList = termBooksMapper.list(termStudents);
        logger.info(LOG_LIST_RESULT, JSON.toJSONString(termStudentsList));
        if (CollectionUtils.isEmpty(termStudentsList)) {
            return new PageInfo<>();
        }
        return new PageInfo<>(termStudentsList);
    }

    @Override
    public TermStudents findById(int id) {
        logger.info(LOG_FIND_ID, id);
        return termBooksMapper.findById(id);
    }

    @Override
    public void insert(TermStudents termInfo) {
        logger.info(LOG_INSERT, JSON.toJSONString(termInfo));
        termBooksMapper.insert(termInfo);
    }

    @Override
    public void batchInsert(List<TermStudents> list) {
        logger.info(LOG_INSERT, JSON.toJSONString(list));
        termBooksMapper.batchInsert(list);
    }

}
