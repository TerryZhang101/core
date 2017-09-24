package com.nms.core.enums;

/**
 * Created by K on 2017/9/23.
 */
public enum CoreConstantEnum {
    DEBIT("1","借"),
    CREDIT("2","贷款"),
    TRANS_STATUS_SUCC("0","成功"),
    TRANS_STATUS_FAIL("1","冲正"),
    TRANS_STATUS_PRE("P","预登记"),
    TRANS_STATUS_REV("9","无效"),
    ACCT_TYPE_NB("01","诺宝账户"),
    ACCT_TYPE_NQ("02","诺券账户"),
    ACCT_TYPE_NJF("03","诺积分账户"),
    ACCT_TYPE_NBH("04","内部户账户"),
    TRANS_CODE_CHARGE_NB("20101001","诺宝充值"),
    ORDER_STATUS_SUCC("0","成功"),
    ORDER_STATUS_FAIL("1","失败"),
    ORDER_STATUS_WAIT_PAY("2","待支付"),
    ORDER_STATUS_RET_PART("3","已部分退款"),
    ORDER_STATUS_RETING("4","退款处理中"),
    ORDER_STATUS_RET_ALL("5","已全额退款"),;

    private String value;

    private String desc;

    CoreConstantEnum(String value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
