package com.ddky.fms.refund.service.impl.student;

import com.alibaba.fastjson.JSON;
import com.ddky.fms.refund.constants.LogConstants;
import com.ddky.fms.refund.exception.BusinessException;
import com.ddky.fms.refund.mapper.students.TeacherInfoMapper;
import com.ddky.fms.refund.model.students.entry.TeacherInfo;
import com.ddky.fms.refund.service.student.TeacherInfoService;
import com.ddky.fms.refund.utils.CmvDesUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;


/**
 * TeacherInfoService
 * @author a
 */
@Service
public class TeacherInfoServiceImpl implements TeacherInfoService {

    private static final Logger logger = LoggerFactory.getLogger(LogConstants.TEACH_LOG);

    @Autowired
    private TeacherInfoMapper teacherInfoMapper;

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

    @Override
    public PageInfo<TeacherInfo> list(TeacherInfo teacherInfo, int pageIndex, int pageSize) {
        logger.info(LOG_LIST_PARAM, JSON.toJSONString(teacherInfo), pageIndex, pageSize);
        PageHelper.startPage(pageIndex, pageSize).setOrderBy(" id desc");
        List<TeacherInfo> teacherInfos = teacherInfoMapper.list(teacherInfo);
        logger.info(LOG_LIST_RESULT, JSON.toJSONString(teacherInfo));
        if (CollectionUtils.isEmpty(teacherInfos)) {
            return new PageInfo<>();
        }
        return new PageInfo<>(teacherInfos);
    }

    @Override
    public TeacherInfo findById(Long id) {
        logger.info(LOG_FIND_ID, id);
        TeacherInfo result = teacherInfoMapper.findById(id);
        logger.info(LOG_FIND_ID_RESULT, result);
        return result;
    }

    @Override
    public TeacherInfo findByPhone(String phone) {
        logger.info(LOG_FIND_PHONE, phone);
        TeacherInfo param = new TeacherInfo();
        param.setPhone(phone);
        TeacherInfo result = teacherInfoMapper.findOne(param);
        logger.info(LOG_FIND_PHONE_RESULT, result);
        return result;
    }

    @Override
    public TeacherInfo findByUserName(String userName) {
        logger.info(LOG_FIND_USERNAME, userName);
        TeacherInfo param = new TeacherInfo();
        param.setUserName(userName);
        TeacherInfo result = teacherInfoMapper.findOne(param);
        logger.info(LOG_FIND_PHONE_RESULT, result);
        return result;
    }

    @Override
    public List<TeacherInfo> listByPhoneList(List<String> list) {
        logger.info("listByPhoneList param {}", JSON.toJSONString(list));
        List<TeacherInfo> result = teacherInfoMapper.listByPhoneList(list);
        logger.info("listByPhoneList result {}", JSON.toJSONString(result));
        return result;
    }

    @Override
    public List<TeacherInfo> listByUserNameList(List<String> list) {
        logger.info("listByUserNameList param {}", JSON.toJSONString(list));
        List<TeacherInfo> result = teacherInfoMapper.listByUserNameList(list);
        logger.info("listByUserNameList result {}", JSON.toJSONString(result));
        return result;
    }

    @Override
    @Transactional(rollbackFor = BusinessException.class)
    public void insert(TeacherInfo item) {
        logger.info(LOG_INSERT, JSON.toJSONString(item));
        if (!StringUtils.isEmpty(item.getPhone())) {
            TeacherInfo tmpItem = findByPhone(item.getPhone());
            if (!ObjectUtils.isEmpty(tmpItem)) {
                throw new BusinessException(501, "手机号" + item.getPhone() + "已经注册");
            }
        }
        if (!StringUtils.isEmpty(item.getUserName())) {
            TeacherInfo tmpItem = findByUserName(item.getUserName());
            if (!ObjectUtils.isEmpty(tmpItem)) {
                throw new BusinessException(501, "用户名" + item.getUserName() + "已经注册");
            }
        }
        item.setPassWord(CmvDesUtils.encrypt(item.getPassWord()));
        teacherInfoMapper.insert(item);
    }

    @Override
    @Transactional(rollbackFor = BusinessException.class)
    public void batchInsert(List<TeacherInfo> list) {
        logger.info(LOG_INSERT_LIST, JSON.toJSONString(list));
        List<String> phoneList = list.stream().filter(a -> a.getPhone() != null).map(TeacherInfo::getPhone).collect(Collectors.toList());
        if (!CollectionUtils.isEmpty(phoneList)) {
            List<TeacherInfo> studentInfos = this.listByPhoneList(phoneList);
            if (!CollectionUtils.isEmpty(studentInfos)) {
                StringBuilder sbInfo = new StringBuilder();
                sbInfo.append("手机号：");
                studentInfos.forEach(item -> {
                    sbInfo.append(item.getPhone()).append(",");
                });
                sbInfo.deleteCharAt(sbInfo.length() - 1);
                sbInfo.append("已经注册");
                throw new BusinessException(501, sbInfo.toString());
            }
        }
        List<String> userNameList = list.stream().filter(a -> a.getUserName() != null).map(TeacherInfo::getUserName).collect(Collectors.toList());
        if (!CollectionUtils.isEmpty(userNameList)) {
            List<TeacherInfo> studentInfos = this.listByUserNameList(userNameList);
            if (!CollectionUtils.isEmpty(studentInfos)) {
                StringBuilder sbInfo = new StringBuilder();
                sbInfo.append("用户名：");
                studentInfos.forEach(item -> {
                    sbInfo.append(item.getUserName()).append(",");
                });
                sbInfo.deleteCharAt(sbInfo.length() - 1);
                sbInfo.append("已经注册");
                throw new BusinessException(501, sbInfo.toString());
            }
        }
        list.forEach(item -> {
            item.setPassWord(CmvDesUtils.encrypt(item.getPassWord()));
        });
        teacherInfoMapper.batchInsert(list);
    }

    @Override
    @Transactional(rollbackFor = BusinessException.class)
    public int edit(TeacherInfo item) {
        logger.info(LOG_EDIT, JSON.toJSONString(item));
        return teacherInfoMapper.edit(item);
    }

    @Override
    @Transactional(rollbackFor = BusinessException.class)
    public int delete(List<Long> idList) {
        logger.info(LOG_REMOVE, JSON.toJSONString(idList));
        return teacherInfoMapper.delete(idList);
    }
}
