package com.nms.core.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.nms.core.dao.NbMapper;
import com.nms.core.service.NbService;
import com.nms.core.util.kit.StrKit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * 诺宝Service实现
 * Created by K on 2017/9/21.
 */

@Service
public class NbServiceImpl implements NbService {

    private static final Logger logger = LoggerFactory.getLogger(NbServiceImpl.class);



    @Autowired
    NbMapper nbMapper;

    /**
     * 诺宝充值生成支付订单
     *
     * @param jsonObject  接收数据
     * @param responseMap 返回数据
     */
    @Override
    @Transactional
    public void create_nb_order_prepay(JSONObject jsonObject, Map<String, Object> responseMap) {
        final Map requestMap = jsonObject.toJavaObject(Map.class);

        String out_trade_no = (String)requestMap.get("out_trade_no");
        String organ_id = (String)requestMap.get("organ_id");
        String prepay_id = StrKit.generateFlowNo(organ_id);
        requestMap.put("prepay_id",prepay_id);

        logger.debug("prepay_id="+prepay_id);

        nbMapper.insertOrder(requestMap);
        responseMap.put("prepay_id",prepay_id);
        //TODO 诺宝充值生成支付订单

    }

    /**
     * 诺宝充值支付结果通知
     *
     * @param jsonObject 接收数据
     */
    @Override
    public void notify_nb_order_payed_result(JSONObject jsonObject) {

        //TODO 诺宝充值支付结果通知
    }

    /**
     * 诺宝提现申请
     *
     * @param jsonObject 接收数据
     */
    @Override
    public void nb_withdraw_apply(JSONObject jsonObject) {

        //TODO 诺宝提现申请

    }

    /**
     * 诺宝提现税率查询
     *
     * @param jsonObject  接收数据
     * @param responseMap 返回数据
     */
    @Override
    public void nb_withdraw_feerate_qry(JSONObject jsonObject, Map<String, Object> responseMap) {

        //TODO 诺宝提现税率查询
    }

    /**
     * 诺宝提现银行卡查询
     *
     * @param jsonObject  接收数据
     * @param responseMap 返回数据
     */
    @Override
    public void nb_withdraw_card_qry(JSONObject jsonObject, Map<String, Object> responseMap) {

        //TODO 诺宝提现银行卡查询

    }

    /**
     * 诺宝往来伙伴查询
     *
     * @param jsonObject  接收数据
     * @param responseMap 返回数据
     */
    @Override
    public void nb_partner_qry(JSONObject jsonObject, Map<String, Object> responseMap) {

        //TODO 诺宝往来伙伴查询

    }

    /**
     * 诺宝转账
     *
     * @param jsonObject 接收数据
     */
    @Override
    public void nb_transfer(JSONObject jsonObject) {

        //TODO 诺宝转账

    }

    /**
     * 诺宝明细
     *
     * @param jsonObject  接收数据
     * @param responseMap 返回数据
     */
    @Override
    public void nb_detail_qry(JSONObject jsonObject, Map<String, Object> responseMap) {

        //TODO 诺宝明细

    }
}
