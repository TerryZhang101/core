package com.nms.core.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Order {
    private String orderNo;

    private String outTradeNo;

    private Integer custNo;

    private String bizType;

    private String payType;

    private String organId;

    private Date orderDate;

    private Date orderTime;

    private BigDecimal transAmt;

    private Integer orderState;

    private Integer refundTimes;

    private BigDecimal refundAmt;

    private String payId;

    private String remark;

    public Order(String orderNo, String outTradeNo, Integer custNo, String bizType, String payType, String organId, Date orderDate, Date orderTime, BigDecimal transAmt, Integer orderState, Integer refundTimes, BigDecimal refundAmt, String payId, String remark) {
        this.orderNo = orderNo;
        this.outTradeNo = outTradeNo;
        this.custNo = custNo;
        this.bizType = bizType;
        this.payType = payType;
        this.organId = organId;
        this.orderDate = orderDate;
        this.orderTime = orderTime;
        this.transAmt = transAmt;
        this.orderState = orderState;
        this.refundTimes = refundTimes;
        this.refundAmt = refundAmt;
        this.payId = payId;
        this.remark = remark;
    }

    public Order() {
        super();
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo == null ? null : outTradeNo.trim();
    }

    public Integer getCustNo() {
        return custNo;
    }

    public void setCustNo(Integer custNo) {
        this.custNo = custNo;
    }

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType == null ? null : bizType.trim();
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType == null ? null : payType.trim();
    }

    public String getOrganId() {
        return organId;
    }

    public void setOrganId(String organId) {
        this.organId = organId == null ? null : organId.trim();
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public BigDecimal getTransAmt() {
        return transAmt;
    }

    public void setTransAmt(BigDecimal transAmt) {
        this.transAmt = transAmt;
    }

    public Integer getOrderState() {
        return orderState;
    }

    public void setOrderState(Integer orderState) {
        this.orderState = orderState;
    }

    public Integer getRefundTimes() {
        return refundTimes;
    }

    public void setRefundTimes(Integer refundTimes) {
        this.refundTimes = refundTimes;
    }

    public BigDecimal getRefundAmt() {
        return refundAmt;
    }

    public void setRefundAmt(BigDecimal refundAmt) {
        this.refundAmt = refundAmt;
    }

    public String getPayId() {
        return payId;
    }

    public void setPayId(String payId) {
        this.payId = payId == null ? null : payId.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}