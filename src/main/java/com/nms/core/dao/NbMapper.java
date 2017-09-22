package com.nms.core.dao;

import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * Created by K on 2017/9/21.
 */
@Repository(value = "nbMapper")
public interface NbMapper {

    /**
     * 插入支付订单信息
     * @param param
     * @return
     */
    int insertOrder(Map<String,Object> param);

    /**
     * 查询预支付订单号
     * @param out_trade_no
     * @return
     */
    String selectPrepayIdByOutTradeNo(String out_trade_no);

}
