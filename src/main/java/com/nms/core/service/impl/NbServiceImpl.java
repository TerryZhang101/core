package com.nms.core.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.nms.core.dao.OrderMapper;
import com.nms.core.dao.TransactionJourMapper;
import com.nms.core.dao.UserMapper;
import com.nms.core.entity.Order;
import com.nms.core.entity.TransactionJour;
import com.nms.core.entity.User;
import com.nms.core.enums.CoreConstantEnum;
import com.nms.core.enums.ErrorCodeEnum;
import com.nms.core.exception.CoreException;
import com.nms.core.service.NbService;
import com.nms.core.util.kit.StrKit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 诺宝Service实现
 * Created by K on 2017/9/21.
 */

@Service
public class NbServiceImpl implements NbService {

    private static final Logger logger = LoggerFactory.getLogger(NbServiceImpl.class);

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    UserMapper userMapper;

    @Autowired
    TransactionJourMapper transactionJourMapper;

    /**
     * 诺宝充值生成支付订单
     *
     * @param jsonObject  接收数据
     * @param responseMap 返回数据
     */
    @Override
    @Transactional
    public void create_nb_order_prepay(JSONObject jsonObject, Map<String, Object> responseMap) {

        Order order = jsonObject.toJavaObject(Order.class);

        //用户信息校验
        User user = userMapper.selectByPrimaryKey(order.getCustNo());
        if (null == user) {
            throw new CoreException(ErrorCodeEnum.USERNOTEXITS);
        }

        String organ_id = jsonObject.getString("organ_id");
        String pay_amount = jsonObject.getString("pay_amount");
        String out_trade_no = jsonObject.getString("out_trade_no");
        String cust_no = jsonObject.getString("cust_no");
        Date date = new Date();
        Date time = new Date();
        //生成预支付订单号
        String orderNo = StrKit.generateFlowNo(organ_id);
        logger.debug("==> prepay_id = " + orderNo);
        order.setOrderNo(orderNo);
        order.setOrderDate(date);
        order.setOrderTime(time);
        order.setTransAmt(new BigDecimal(pay_amount));
        //待支付
        order.setOrderState(Integer.valueOf(CoreConstantEnum.ORDER_STATUS_WAIT_PAY.getValue()));
        order.setRemark("诺宝充值");

        //保存订单数据
        orderMapper.insertSelective(order);

        //登记交易流水
        TransactionJour transactionJour = new TransactionJour();
        transactionJour.setTransBranCode(organ_id);
        transactionJour.setTransDate(date);
        transactionJour.setTransTime(time);
        transactionJour.setSetDate(date);
        transactionJour.setOperNo(organ_id);
        transactionJour.setSeqno(StrKit.generateFlowNo(organ_id));
        transactionJour.setSubSeqno("00000000");//因一笔交易只登记一次交易流水，所以子流水号为00000000
        transactionJour.setTransCode(CoreConstantEnum.TRANS_CODE_CHARGE_NB.getValue());
        transactionJour.setExtSeqno(out_trade_no);

        //查询诺宝账号
        Map<String,String> param = new HashMap<String,String>();
        param.put("cust_no",cust_no);
        param.put("acct_type",CoreConstantEnum.ACCT_TYPE_NB.getValue());
        Map<String, String> result = transactionJourMapper.selectAcctByCustNo(param);
        if(result == null) {
            throw new CoreException(ErrorCodeEnum.REC_ACCT_NOT_EXITS);
        }
        transactionJour.setAcctNo(result.get("acct_no"));
        transactionJour.setAcctSeqno(result.get("acct_seqno"));
        transactionJour.setOppAcctNo(result.get("acct_no"));
        transactionJour.setDcFlag(Integer.valueOf(CoreConstantEnum.CREDIT.getValue()));
        transactionJour.setTransAmt(new BigDecimal(pay_amount));
        transactionJour.setAbs("诺宝充值");
        transactionJour.setTransStatus(CoreConstantEnum.TRANS_STATUS_PRE.getValue());
        transactionJour.setRcvpkglen(jsonObject.toString().length());
        transactionJour.setRcvbuf1(jsonObject.toJSONString());
        transactionJour.setResponse(CoreConstantEnum.TRANS_STATUS_PRE.getValue());
        transactionJour.setRespdesc(CoreConstantEnum.TRANS_STATUS_PRE.getDesc());
        transactionJourMapper.insertSelective(transactionJour);
        
        responseMap.put("prepay_id",orderNo);

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
