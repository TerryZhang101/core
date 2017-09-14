-- ----------------------------
-- Table structure for c_acct_info
-- ----------------------------
DROP TABLE IF EXISTS c_acct_info;
CREATE TABLE c_acct_info
(
    acct_no varchar(32)  NOT NULL COMMENT '账号',
    acct_seqno varchar(8)  NOT NULL COMMENT '账号序号',
    cust_no varchar(8)  NOT NULL COMMENT '客户号',
    cust_name varchar(64)  NOT NULL COMMENT '客户名称',
    open_bran_code varchar(10)  DEFAULT NULL COMMENT '开户机构',
    open_date datetime NOT NULL COMMENT '开户日期',
    cancel_date datetime DEFAULT NULL COMMENT '销户日期',
    last_trans_date datetime DEFAULT NULL COMMENT '登记客户最后主动发生交易的日期',
    last_acct_date datetime DEFAULT NULL COMMENT '登记该记录最后帐务发生日期',
    stop_payment_type int(11) NOT NULL COMMENT '止付标志：0=正常；1=止付',
    acct_type varchar(2)  NOT NULL COMMENT '帐户类别：01=诺宝账户；02=诺卷账户；03=诺积分账户；04=内部账户',
    acct_status int(11) NOT NULL COMMENT '帐户状态：0=正常；1=销户',
    cur_code int(11) DEFAULT NULL COMMENT '币种（保留）',
    balance_mode int(11) DEFAULT NULL COMMENT '平衡标志-该户是否参加帐务平衡：0=不参加；1=参加',
    sub_code varchar(8)  NOT NULL COMMENT '科目编号',
    acct_bal decimal(16,2) DEFAULT NULL COMMENT '余额',
    acct_pre_bal decimal(16,2) DEFAULT NULL COMMENT '昨日余额-最后帐务日期上日余额',
    then_bal decimal(16,2) DEFAULT NULL COMMENT '本日差额-最后帐务日期本日差额',
    bal_direct int(11) DEFAULT NULL COMMENT '余额方向（保留）',
    trans_count int(11) DEFAULT '0' COMMENT '除了查询交易外其他交易每次++',
    dac varchar(32)  NOT NULL COMMENT 'DAC安全码',
    ctrl_flag varchar(32)  DEFAULT NULL COMMENT '控制位（保留）',
    reserv_num1 decimal(16,2) DEFAULT NULL COMMENT '保留字段1',
    reserv_num2 int(11) DEFAULT NULL COMMENT '保留字段2',
    reserv_str1 varchar(64)  DEFAULT NULL COMMENT '保留字段3',
    reserv_str2 varchar(64)  DEFAULT NULL COMMENT '保留字段4',
    PRIMARY KEY (acct_no,acct_seqno)
)
  ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='帐户帐务信息表';
