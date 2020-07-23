package com.ddky.fms.refund.service.impl.term;

import com.alibaba.fastjson.JSON;
import com.ddky.fms.refund.constants.LogConstants;
import com.ddky.fms.refund.mapper.term.TermBooksMapper;
import com.ddky.fms.refund.model.term.entry.TermBooks;
import com.ddky.fms.refund.service.term.TermBooksService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/***
 * TermBooks
 * @author a
 */
@Service
public class TermBooksServiceImpl implements TermBooksService {

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
    private TermBooksMapper termBooksMapper;

    @Override
    public PageInfo<TermBooks> list(TermBooks termInfo, int pageIndex, int pageSize) {
        logger.info(LOG_LIST_PARAM, JSON.toJSONString(termInfo), pageIndex, pageSize);
        PageHelper.startPage(pageIndex, pageSize).setOrderBy(" teamId desc");
        List<TermBooks> termInfoList = termBooksMapper.list(termInfo);
        logger.info(LOG_LIST_RESULT, JSON.toJSONString(termInfoList));
        if (CollectionUtils.isEmpty(termInfoList)) {
            return new PageInfo<>();
        }
        return new PageInfo<>(termInfoList);
    }

    @Override
    public TermBooks findById(int id) {
        logger.info(LOG_FIND_ID, id);
        return termBooksMapper.findById(id);
    }

    @Override
    public void insert(TermBooks termInfo) {
        logger.info(LOG_INSERT, JSON.toJSONString(termInfo));
        termBooksMapper.insert(termInfo);
    }

    @Override
    public void batchInsert(List<TermBooks> list) {
        logger.info(LOG_INSERT_LIST, JSON.toJSONString(list));
        termBooksMapper.batchInsert(list);
    }
}
