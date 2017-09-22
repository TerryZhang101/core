-- ----------------------------
-- Table structure for c_acct_info
-- 登记帐户的帐务信息。一个账户只有一笔记录，在开户时插入，其他情况下均是更新记录，不允许删除记录。
-- 参加DAC的字段：
--   帐号（acct_no）
--   帐户序号（acct_seqno）
--   币种（cur_code）
--   客户姓名
--   客户编号
--   最后交易日期
--   最后账务日期
--   余额（acct_bal）
--   昨日余额
--   利息积数（acct_accum）
--   止付标志（stop_payment_type）
--   帐户状态（acct_status）
-- ----------------------------
DROP TABLE IF EXISTS c_acct_info;
CREATE TABLE c_acct_info
(
    acct_no varchar(32)  NOT NULL COMMENT '账号',
    acct_seqno varchar(8)  NOT NULL COMMENT '账号序号',
    cust_no varchar(8)  NOT NULL COMMENT '客户号',
    cust_name varchar(64)  DEFAULT NULL COMMENT '客户名称',
    open_bran_code varchar(10)  DEFAULT NULL COMMENT '开户机构',
    acct_bran_code varchar(10)  DEFAULT NULL COMMENT '账户机构，目前与开户机构一致',
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
    acct_bal decimal(16,2) DEFAULT 0.00 COMMENT '余额',
    acct_pre_bal decimal(16,2) DEFAULT NULL COMMENT '昨日余额-最后帐务日期上日余额',
    then_bal decimal(16,2) DEFAULT NULL COMMENT '本日差额-最后帐务日期本日差额',
    bal_direct int(11) DEFAULT NULL COMMENT '余额方向（保留）',
    acct_accum decimal(16,2) DEFAULT 0.00 COMMENT '利息基数',
    trans_count int(11) DEFAULT '0' COMMENT '除了查询交易外其他交易每次++',
    dac varchar(96)  NOT NULL COMMENT 'DAC安全码',
    ctrl_flag varchar(32)  DEFAULT NULL COMMENT '控制位（保留）',
    reserv_num1 decimal(16,2) DEFAULT NULL COMMENT '保留字段1',
    reserv_num2 int(11) DEFAULT NULL COMMENT '保留字段2',
    reserv_str1 varchar(64)  DEFAULT NULL COMMENT '保留字段3',
    reserv_str2 varchar(64)  DEFAULT NULL COMMENT '保留字段4',
    PRIMARY KEY (acct_no,acct_seqno)
)
  ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='帐户（分户）信息表';

