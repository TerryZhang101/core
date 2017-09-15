-- ----------------------------
-- Table structure for c_amount_list
-- 登记总账明细。日终生成总账数据后，登记该日总账明细.
-- ----------------------------
DROP TABLE IF EXISTS c_amount_list;
CREATE TABLE c_amount_list
(
    set_date date  NOT NULL COMMENT '会计日期',
    cur_code int(11) NOT NULL COMMENT '币种（保留）',
    bran_code varchar(10)  NOT NULL COMMENT '核算主体的机构号',
    sub_code varchar(8)  NOT NULL COMMENT '科目编号',
    dc_flag int(11)  NOT NULL COMMENT '借贷标志: 1=借；2=贷',
    debit_cnt int(11) DEFAULT 0 COMMENT '日借方笔数-本日发生的借方笔数',
    debit_amt decimal(16,2) DEFAULT 0.00 COMMENT '日借方发生额-本日发生的借方发生额',
    credit_cnt int(11) DEFAULT 0 COMMENT '日贷方笔数-本日发生的贷方笔数',
    credit_amt decimal(16,2) DEFAULT 0.00 COMMENT '日贷方发生额-本日发生的贷方发生额',
    acct_bal decimal(16,2) DEFAULT 0.00 COMMENT '余额-当前余额',
    last_mod_date datetime NOT NULL COMMENT '最近修改日期',

    PRIMARY KEY (set_date,bran_code,cur_code,sub_code)
)
  ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='总帐明细表';
