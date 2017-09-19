-- ----------------------------
-- Table structure for c_cust_info
-- 描述客户的基本信息
-- ----------------------------
DROP TABLE IF EXISTS c_cust_info;
CREATE TABLE c_cust_info
(
    id int(11) PRIMARY KEY NOT NULL COMMENT '客户号' AUTO_INCREMENT,
    name varchar(64) COMMENT '姓名',
    alias varchar(64) COMMENT '别名',
    cert_no varchar(18) COMMENT '身份证号码',
    mobile_no varchar(11) NOT NULL COMMENT '注册手机号',
    star_lvl int(11) NOT NULL COMMENT '星级：1=1星；2=2星；3=3星；4=4星；5=5星',
    area_belong varchar(10) COMMENT '归属区域代码',
    state int(11) NOT NULL COMMENT '会员状态：0=正常；1=冻结；2=注销',
    up_id int(11) DEFAULT NULL COMMENT '上级会员号',
    rec_id int(11) COMMENT '推荐会员号',
    head_quarter varchar(10) COMMENT '归属城市总部',
    address varchar(255) COMMENT '地址',
    type int(11) NOT NULL COMMENT '会员类型：1=普通会员；2=诺星；3=诺商',
    logon_pwd varchar(255) NOT NULL COMMENT '登录密码',
    tran_pwd varchar(255) NOT NULL COMMENT '交易密码',
    reg_date datetime NOT NULL COMMENT '注册日期',
    due_date date COMMENT '证件有效期YYYY-MM-DD；长期9999-12-31'';',
    img_front_url varchar(255) COMMENT '身份证正面照片地址URL',
    img_back_url varchar(255) COMMENT '身份证背面照片地址URL',
    corpor_name varchar(255) COMMENT '企业名称（诺商认证使用）',
    regist_no varchar(32) COMMENT '注册号（诺商认证使用）',
    legal_person varchar(64) COMMENT '法人姓名（诺商认证使用）',
    regist_addr varchar(255) COMMENT '注册地址（诺商认证使用）',
    auth_state int(11) COMMENT '诺商认证状态 0=审核通过；1=审核不通过；2=待审核（诺商认证使用）',
    img_busi_lic_url varchar(255) COMMENT '营业执照图片URL（诺商认证使用）',
    busi_lic_due date COMMENT '营业执照有效期：YYYY-MM-DD；长期9999-12-31'
)

    ENGINE=InnoDB AUTO_INCREMENT=10000000 DEFAULT CHARSET=utf8 COMMENT='客户信息表';

CREATE UNIQUE INDEX c_cust_info_mobile_no_uindex ON c_cust_info (mobile_no);
