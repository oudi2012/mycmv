package com.ddky.fms.refund.service.impl;

import com.alibaba.fastjson.JSON;
import com.ddky.fms.refund.mapper.userlogs.OrderMapper;
import com.ddky.fms.refund.model.stream.entry.Order;
import com.ddky.fms.refund.service.ListStreamService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class ListStreamServiceImpl implements ListStreamService {

    private static final Logger logger = LoggerFactory.getLogger(ListStreamServiceImpl.class);

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public PageInfo<Order> list(int pageIndex, int pageSize) {
        PageHelper.startPage(pageIndex, pageSize);
        List<Order> orderList = orderMapper.list();
        return new PageInfo<>(orderList);
    }

    @Override
    public void listIds(List<Order> orderList) {
        if (CollectionUtils.isEmpty(orderList)) {
            logger.info(LOG_LIST_NULL);
            return;
        }
        logger.info("orderIds 开始转化，size is {}", orderList.size());
        List<Long> orderIds = orderList.parallelStream().map(Order::getId).collect(Collectors.toList());
        logger.info(JSON.toJSONString(orderIds));
        logger.info("orderIds 转化完成，size is {}", orderIds.size());
        //Thread.sleep(3000);
    }
}
