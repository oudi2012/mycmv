package com.ddky.fms.refund.service.impl;

import com.alibaba.fastjson.JSON;
import com.ddky.fms.refund.constants.LogConstants;
import com.ddky.fms.refund.mapper.students.GuardianInfoMapper;
import com.ddky.fms.refund.model.students.entry.GuardianInfo;
import com.ddky.fms.refund.service.GuardianInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/***
 * 监护人
 * @author a
 */
@Service
public class GuardianInfoServiceImpl implements GuardianInfoService {

    private static final Logger logger = LoggerFactory.getLogger(LogConstants.STU_LOG);

    private static final String LOG_LIST_PARAM = "GuardianInfoServiceImpl -> list param {},{},{}";
    private static final String LOG_LIST_RESULT = "GuardianInfoServiceImpl -> list result {}";
    private static final String LOG_FIND_ID = "GuardianInfoServiceImpl -> findById param {}";
    private static final String LOG_FIND_ID_RESULT = "GuardianInfoServiceImpl -> findById result {}";
    private static final String LOG_FIND_PHONE = "GuardianInfoServiceImpl -> findByPhone param {}";
    private static final String LOG_FIND_PHONE_RESULT = "GuardianInfoServiceImpl -> findByPhone result {}";
    private static final String LOG_FIND_USERNAME = "GuardianInfoServiceImpl -> userName param {}";
    private static final String LOG_FIND_USERNAME_RESULT = "GuardianInfoServiceImpl -> userName result {}";
    private static final String LOG_INSERT = "GuardianInfoServiceImpl -> insert param {}";
    private static final String LOG_INSERT_LIST = "GuardianInfoServiceImpl -> batchInsert param {}";
    private static final String LOG_EDIT = "GuardianInfoServiceImpl -> edit param {}";
    private static final String LOG_REMOVE = "GuardianInfoServiceImpl -> delete param {}";

    @Autowired
    private GuardianInfoMapper guardianInfoMapper;

    @Override
    public PageInfo<GuardianInfo> list(GuardianInfo guardianInfo, int pageIndex, int pageSize) {
        logger.info(LOG_LIST_PARAM, JSON.toJSONString(guardianInfo), pageIndex, pageSize);
        PageHelper.startPage(pageIndex, pageSize).setOrderBy(" id desc");
        List<GuardianInfo> guardianInfos = guardianInfoMapper.list(guardianInfo);
        logger.info(LOG_LIST_RESULT, JSON.toJSONString(guardianInfos));
        if (CollectionUtils.isEmpty(guardianInfos)) {
            return new PageInfo<>();
        }
        return new PageInfo<>(guardianInfos);
    }

    @Override
    public GuardianInfo findById(Long id) {
        logger.info(LOG_FIND_ID, id);
        GuardianInfo result = guardianInfoMapper.findById(id);
        logger.info(LOG_FIND_ID_RESULT, result);
        return result;
    }

    @Override
    public GuardianInfo findByPhone(String phone) {
        logger.info(LOG_FIND_PHONE, phone);
        GuardianInfo param = new GuardianInfo();
        param.setPhone(phone);
        GuardianInfo result = guardianInfoMapper.findOne(param);
        logger.info(LOG_FIND_PHONE_RESULT, result);
        return result;
    }

    @Override
    public GuardianInfo findByUserName(String userName) {
        logger.info(LOG_FIND_USERNAME, userName);
        GuardianInfo param = new GuardianInfo();
        param.setUserName(userName);
        GuardianInfo result = guardianInfoMapper.findOne(param);
        logger.info(LOG_FIND_USERNAME_RESULT, result);
        return result;
    }

    @Override
    public void insert(GuardianInfo item) {
        logger.info(LOG_INSERT, JSON.toJSONString(item));
        guardianInfoMapper.insert(item);
    }

    @Override
    public void batchInsert(List<GuardianInfo> list) {
        logger.info(LOG_INSERT_LIST, JSON.toJSONString(list));
        guardianInfoMapper.batchInsert(list);
    }

    @Override
    public int edit(GuardianInfo item) {
        logger.info(LOG_EDIT, JSON.toJSONString(item));
        return guardianInfoMapper.edit(item);
    }

    @Override
    public int delete(List<Long> idList) {
        logger.info(LOG_REMOVE, JSON.toJSONString(idList));
        return guardianInfoMapper.delete(idList);
    }
}
