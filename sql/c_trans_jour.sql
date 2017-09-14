-- ----------------------------
-- Table structure for c_trans_jour
-- 登记交易流水信息，一笔交易只登记一笔交易流水。
-- ----------------------------
DROP TABLE IF EXISTS c_trans_jour;
CREATE TABLE c_trans_jour
(
    trans_bran_code varchar(10)  NOT NULL COMMENT '交易机构',
    trans_date date  NOT NULL COMMENT '交易日期',
    trans_time time NOT NULL COMMENT '交易时间',
    set_date date  NOT NULL COMMENT '会计日期',
    oper_no varchar(10) NOT NULL COMMENT '柜员号',
    seqno int(11) NOT NULL COMMENT '流水号-后台生产唯一',
    sub_seqno int(11) NOT NULL COMMENT '子流水号-每笔交易后++',
    trans_code varchar(8) NOT NULL COMMENT '交易码',
    ext_seqno varchar(32) NOT NULL COMMENT '外部系统、其他渠道流水号',
    acct_no varchar(32)  NOT NULL COMMENT '账号',
    acct_seqno varchar(8)  NOT NULL COMMENT '账号序号',
    dc_flag varchar(2)  NOT NULL COMMENT '借贷标志: D=借；C=贷',
    trans_amt decimal(16,2) DEFAULT 0.00 COMMENT '交易金额',
    opp_acct_no varchar(32)  DEFAULT NULL COMMENT '对方账号',
    abs varchar(60)  DEFAULT NULL COMMENT '摘要',
    trans_status varchar(2) NOT NULL COMMENT '交易状态：0=成功；1=冲正；9=无效；P=预登记',
    rcvPkglen int(11) DEFAULT NULL COMMENT '请求报文长度',
    rcvbuf1 varchar(255) DEFAULT NULL COMMENT '请求报文part 1',
    rcvbuf2 varchar(255) DEFAULT NULL COMMENT '请求报文part 2',
    sndPkglen int(11) DEFAULT NULL COMMENT '响应报文长度',
    sndbuf1 varchar(255) DEFAULT NULL COMMENT '响应报文part 1',
    sndbuf2 varchar(255) DEFAULT NULL COMMENT '响应报文part 2',
    response varchar(8) NOT NULL COMMENT '响应吗',
    respdesc varchar(80) NOT NULL COMMENT '响应信息',

    PRIMARY KEY (set_date,oper_no,seqno,sub_seqno)
)
  ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='交易流水表';
