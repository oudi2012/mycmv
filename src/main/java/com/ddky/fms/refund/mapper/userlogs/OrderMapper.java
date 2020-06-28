package com.ddky.fms.refund.mapper.userlogs;

import com.ddky.fms.refund.model.stream.entry.Order;

import java.util.List;


/***
 * @author a
 */
public interface OrderMapper {

    List<Order> list();

    Order find(Long id);
}
