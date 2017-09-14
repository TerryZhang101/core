-- ----------------------------
-- Table structure for c_acct_jour
-- 登记分录流水信息。一般按账户登记，交易中涉及到几个账户进行账务类的交易就登记几次流水。
-- ----------------------------
DROP TABLE IF EXISTS c_acct_jour;
CREATE TABLE c_acct_jour
(
    trans_bran_code varchar(10)  NOT NULL COMMENT '交易机构',
    acct_bran_code varchar(10)  NOT NULL COMMENT '账户机构',
    trans_date date  NOT NULL COMMENT '交易日期',
    trans_time time NOT NULL COMMENT '交易时间',
    set_date date  NOT NULL COMMENT '会计日期',
    oper_no varchar(10) NOT NULL COMMENT '柜员号',
    seqno int(11) NOT NULL COMMENT '流水号-后台生产唯一',
    sub_seqno int(11) NOT NULL COMMENT '子流水号-每笔交易后++',
    trans_code varchar(8) NOT NULL COMMENT '交易码',
    cust_no varchar(8)  NOT NULL COMMENT '客户号',
    acct_no varchar(32)  NOT NULL COMMENT '账号',
    acct_seqno varchar(8)  NOT NULL COMMENT '账号序号',
    acct_type varchar(2)  NOT NULL COMMENT '帐户类别：01=诺宝账户；02=诺卷账户；03=诺积分账户；04=内部账户',
    sub_code varchar(8)  NOT NULL COMMENT '科目编号',
    trans_src int(11) NOT NULL COMMENT '交易来源',
    func_flag int(11) DEFAULT NULL COMMENT '开销户标志：1=开户；2=销户',
    cur_code int(11) DEFAULT NULL COMMENT '币种（保留）',
    dc_flag varchar(2)  NOT NULL COMMENT '借贷标志: D=借；C=贷',
    trans_amt decimal(16,2) DEFAULT 0.00 COMMENT '交易金额',
    fee decimal(16,2) DEFAULT 0.00 COMMENT '手续费',
    int_amt decimal(16,2) DEFAULT 0.00 COMMENT '利息',
    tax_amt decimal(16,2) DEFAULT 0.00 COMMENT '利息税',
    acct_bal decimal(16,2) DEFAULT 0.00 COMMENT '账户余额',
    acct_accum decimal(16,2) DEFAULT 0.00 COMMENT '利息基数',
    start_int_date date DEFAULT NULL COMMENT '起息日期',
    due_date date DEFAULT NULL COMMENT '到期日期',
    opp_acct_no varchar(32)  DEFAULT NULL COMMENT '对方账号',
    opp_acct_name varchar(64)  DEFAULT NULL COMMENT '对方户名',
    opp_bank_no varchar(10)  DEFAULT NULL COMMENT '对方机构',
    opp_bank_name varchar(64)  DEFAULT NULL COMMENT '对方机构名称',
    abs varchar(60)  DEFAULT NULL COMMENT '摘要',

    PRIMARY KEY (set_date,oper_no,seqno,sub_seqno)
)
  ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='分录流水表';
