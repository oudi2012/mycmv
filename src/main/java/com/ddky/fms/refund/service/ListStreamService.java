package com.ddky.fms.refund.service;


import com.ddky.fms.refund.model.stream.entry.Order;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 列表
 */
public interface ListStreamService {

    String LOG_LIST_NULL = "列表为空.";

    PageInfo<Order> list(int pageIndex, int pageSize);

    void listIds(List<Order> orderList) throws InterruptedException;

}
