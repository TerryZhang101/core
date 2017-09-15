-- ----------------------------
-- Table structure for c_subject
-- 登描述系统使用的科目的属性信息。
-- ----------------------------
DROP TABLE IF EXISTS c_subject;
CREATE TABLE c_subject
(
    sub_code varchar(8)  NOT NULL COMMENT '科目编号',
    sub_name varchar(60)  NOT NULL COMMENT '科目名称',
    sub_level int(11) NOT NULL COMMENT '科目级别：1=一级科目；2=二级科目',
    super_sub_code varchar(8)  NOT NULL COMMENT '上级科目编号',
    sub_attr int(11) NOT NULL COMMENT '科目性质：1=资产类；2=负债类；3=资产负债共同类；4=所有者权益类；5=收入类；6=支出类；0=表外科目',
    bal_direct int(11) NOT NULL COMMENT '科目余额方向：0=余额双方反映；1=余额借方反映；2=余额贷方反映',
    red_flag int(11) NOT NULL COMMENT '允许余额反向：0=允许；1=不允许',
    int_flag int(11) DEFAULT NULL COMMENT '计息标志：0=不计息；1=计息 （保留字段）',
    overdraft_flag int(11) DEFAULT NULL COMMENT '透支标志：0=不允许；1=允许 （保留字段）',
    ctrl_bit varchar(8)  NOT NULL COMMENT '科目控制位：第一位：存款控制位 0:不能通存/借 1:可以通存/借 ；第二位：取款控制位 0:不能通取/贷 1:可以通取/贷；第三位:允许开户控制 0：不许  1：允许',

    PRIMARY KEY (sub_code)
)
  ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='科目控制表';
