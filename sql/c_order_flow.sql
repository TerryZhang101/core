-- ----------------------------
-- Table structure for c_order_flow
-- 订单表（诺宝充值、诺券充值记录）
-- ----------------------------
DROP TABLE IF EXISTS c_order_flow;
CREATE TABLE c_order_flow
(
    order_no varchar(32)  NOT NULL COMMENT '预支付订单号',
    out_trade_no varchar(32)  NOT NULL COMMENT '外部系统流水号',
    cust_no int(11) NOT NULL COMMENT '客户号',
    biz_type varchar(2) NOT NULL COMMENT '订单类型：00=诺宝充值；01=诺券充值；',
    pay_type varchar(2) NOT NULL COMMENT '支付类型：00=微信；01=支付宝；02=诺宝',
    organ_id varchar(32)  NOT NULL COMMENT '法人代码（多法人标识）',
    order_date date  NOT NULL COMMENT '订单日期',
    order_time time NOT NULL COMMENT '交易时间',
    trans_amt decimal(16,2) DEFAULT 0.00 COMMENT '交易金额',
    order_state int(11) NOT NULL COMMENT '订单状态：0=成功；1=失败；2=待支付；3=已部分退款；4=退款处理中；5=已全额退款；',
    refund_times int(11) DEFAULT 0 COMMENT '已退款次数',
    refund_amt decimal(16,2) DEFAULT 0.00 COMMENT '已退款金额',
    pay_id varchar(32)  DEFAULT NULL COMMENT '微信、支付宝平台订单号',
    remark varchar(255) DEFAULT NULL COMMENT '备注',

    PRIMARY KEY (order_no)
)
  ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单表';
