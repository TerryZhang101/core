package com.nms.core.service;

import com.alibaba.fastjson.JSONObject;

import java.util.Map;

/**
 * 诺宝Service
 * Created by K on 2017/9/21.
 */

public interface NbService {

    /**
     * 诺宝充值生成支付订单
     * @param jsonObject 接收数据
     * @param responseMap 返回数据
     */
    void create_nb_order_prepay(JSONObject jsonObject, Map<String, Object> responseMap);

    /**
     * 诺宝充值支付结果通知
     * @param jsonObject 接收数据
     */
    void notify_nb_order_payed_result(JSONObject jsonObject);

    /**
     * 诺宝提现申请
     * @param jsonObject 接收数据
     */
    void nb_withdraw_apply(JSONObject jsonObject);

    /**
     * 诺宝提现税率查询
     * @param jsonObject 接收数据
     * @param responseMap 返回数据
     */
    void nb_withdraw_feerate_qry(JSONObject jsonObject, Map<String, Object> responseMap);

    /**
     * 诺宝提现银行卡查询
     * @param jsonObject 接收数据
     * @param responseMap 返回数据
     */
    void nb_withdraw_card_qry(JSONObject jsonObject, Map<String, Object> responseMap);

    /**
     * 诺宝往来伙伴查询
     * @param jsonObject 接收数据
     * @param responseMap 返回数据
     */
    void nb_partner_qry(JSONObject jsonObject, Map<String, Object> responseMap);

    /**
     * 诺宝转账
     * @param jsonObject 接收数据
     */
    void nb_transfer(JSONObject jsonObject);

    /**
     * 诺宝明细
     * @param jsonObject 接收数据
     * @param responseMap 返回数据
     */
    void nb_detail_qry(JSONObject jsonObject, Map<String, Object> responseMap);

}
