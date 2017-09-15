-- ----------------------------
-- Table structure for c_amount
-- 登记总账信息。日终时自动根据交易流水表生成总账数据。
-- ----------------------------
DROP TABLE IF EXISTS c_amount;
CREATE TABLE c_amount
(
    set_date date  NOT NULL COMMENT '会计日期',
    bran_code varchar(10)  NOT NULL COMMENT '核算主体的机构号',
    cur_code int(11) NOT NULL COMMENT '币种（保留）',
    sub_code varchar(8)  NOT NULL COMMENT '科目编号',
    dc_flag int(11)  NOT NULL COMMENT '借贷标志: 1=借；2=贷',
    last_y_bal decimal(16,2) DEFAULT 0.00 COMMENT '年初余额-前一年年终后得到的年末额',
    y_dc_flag int(11)  NOT NULL COMMENT '年初借贷标志: 1=借；2=贷',
    y_debit_cnt int(11) DEFAULT 0 COMMENT '年借方笔数-本年发生的借方笔数',
    y_debit_amt decimal(16,2) DEFAULT 0.00 COMMENT '年借方发生额-本年中的借方发生额',
    y_credit_cnt int(11) DEFAULT 0 COMMENT '年贷方笔数-本年发生的贷方笔数',
    y_credit_amt decimal(16,2) DEFAULT 0.00 COMMENT '年贷方发生额-本年中的贷方发生额',
    last_s_bal decimal(16,2) DEFAULT 0.00 COMMENT '季初余额-本季初的余额',
    s_dc_flag int(11)  NOT NULL COMMENT '季初借贷标志: 1=借；2=贷',
    s_debit_cnt int(11) DEFAULT 0 COMMENT '季借方笔数-本季发生的借方笔数',
    s_debit_amt decimal(16,2) DEFAULT 0.00 COMMENT '季借方发生额-本季中的借方发生额',
    s_credit_cnt int(11) DEFAULT 0 COMMENT '季贷方笔数-本季发生的贷方笔数',
    s_credit_amt decimal(16,2) DEFAULT 0.00 COMMENT '季贷方发生额-本季中的贷方发生额',
    last_m_bal decimal(16,2) DEFAULT 0.00 COMMENT '月初余额-本月初的余额',
    m_dc_flag int(11)  NOT NULL COMMENT '月初借贷标志: 1=借；2=贷',
    m_debit_cnt int(11) DEFAULT 0 COMMENT '月借方笔数-本月发生的借方笔数',
    m_debit_amt decimal(16,2) DEFAULT 0.00 COMMENT '月借方发生额-本月发生的借方发生额',
    m_credit_cnt int(11) DEFAULT 0 COMMENT '月贷方笔数-本月发生的贷方笔数',
    m_credit_amt decimal(16,2) DEFAULT 0.00 COMMENT '月贷方发生额-本月发生的贷方发生额',
    last_teen_bal decimal(16,2) DEFAULT 0.00 COMMENT '旬初余额-旬初的余额',
    teen_dc_flag int(11) NOT NULL COMMENT '旬初借贷标志: 1=借；2=贷',
    teen_debit_cnt int(11) DEFAULT 0 COMMENT '旬借方笔数-本旬发生的借方笔数',
    teen_debit_amt decimal(16,2) DEFAULT 0.00 COMMENT '旬借方发生额-本旬发生的借方发生额',
    teen_credit_cnt int(11) DEFAULT 0 COMMENT '旬贷方笔数-本旬发生的贷方笔数',
    teen_credit_amt decimal(16,2) DEFAULT 0.00 COMMENT '旬贷方发生额-本旬发生的贷方发生额',
    last_d_bal decimal(16,2) DEFAULT 0.00 COMMENT '日初余额-昨日的余额',
    d_dc_flag int(11)  NOT NULL COMMENT '日初借贷标志: 1=借；2=贷',
    debit_cnt int(11) DEFAULT 0 COMMENT '日借方笔数-本日发生的借方笔数',
    debit_amt decimal(16,2) DEFAULT 0.00 COMMENT '日借方发生额-本日发生的借方发生额',
    credit_cnt int(11) DEFAULT 0 COMMENT '日贷方笔数-本日发生的贷方笔数',
    credit_amt decimal(16,2) DEFAULT 0.00 COMMENT '日贷方发生额-本日发生的贷方发生额',
    open_acct_cnt int(11) DEFAULT 0 COMMENT '开户数-本日发生的开户笔数',
    cancel_acct_cnt int(11) DEFAULT 0 COMMENT '销户数-本日发生的销户笔数',
    spare_acct_cnt int(11) DEFAULT 0 COMMENT '结存户数-当前剩余的户数',
    acct_bal decimal(16,2) DEFAULT 0.00 COMMENT '余额-当前余额',
    last_mod_date datetime NOT NULL COMMENT '最近修改日期',

    PRIMARY KEY (bran_code,cur_code,sub_code)
)
  ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='总帐表';
