package com.ddky.fms.refund.mapper;

import com.ddky.fms.refund.model.stream.entry.Order;

import java.util.List;

public interface OrderMapper {

    List<Order> list();

    Order find(Long id);
}
