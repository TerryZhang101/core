package com.nms.core.dao;

import com.nms.core.entity.Order;
import org.springframework.stereotype.Repository;

@Repository(value = "orderMapper")
public interface OrderMapper {
    int deleteByPrimaryKey(String orderNo);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(String orderNo);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);
}