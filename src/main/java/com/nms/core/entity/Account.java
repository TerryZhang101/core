package com.nms.core.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Account extends AccountKey implements Serializable {
    private String cust_no;

    private String cust_name;

    private String open_bran_code;

    private String acct_bran_code;

    private Date open_date;

    private Date cancel_date;

    private Date last_trans_date;

    private Date last_acct_date;

    private Integer stop_payment_type;

    private String acct_type;

    private Integer acct_status;

    private Integer cur_code;

    private Integer balance_mode;

    private String sub_code;

    private BigDecimal acct_bal;

    private BigDecimal acct_pre_bal;

    private BigDecimal then_bal;

    private Integer bal_direct;

    private BigDecimal acct_accum;

    private Integer trans_count;

    private String dac;

    private String ctrl_flag;

    private BigDecimal reserv_num1;

    private Integer reserv_num2;

    private String reserv_str1;

    private String reserv_str2;

    private static final long serialVersionUID = 1L;

    public String getCust_no() {
        return cust_no;
    }

    public void setCust_no(String cust_no) {
        this.cust_no = cust_no == null ? null : cust_no.trim();
    }

    public String getCust_name() {
        return cust_name;
    }

    public void setCust_name(String cust_name) {
        this.cust_name = cust_name == null ? null : cust_name.trim();
    }

    public String getOpen_bran_code() {
        return open_bran_code;
    }

    public void setOpen_bran_code(String open_bran_code) {
        this.open_bran_code = open_bran_code == null ? null : open_bran_code.trim();
    }

    public String getAcct_bran_code() {
        return acct_bran_code;
    }

    public void setAcct_bran_code(String acct_bran_code) {
        this.acct_bran_code = acct_bran_code == null ? null : acct_bran_code.trim();
    }

    public Date getOpen_date() {
        return open_date;
    }

    public void setOpen_date(Date open_date) {
        this.open_date = open_date;
    }

    public Date getCancel_date() {
        return cancel_date;
    }

    public void setCancel_date(Date cancel_date) {
        this.cancel_date = cancel_date;
    }

    public Date getLast_trans_date() {
        return last_trans_date;
    }

    public void setLast_trans_date(Date last_trans_date) {
        this.last_trans_date = last_trans_date;
    }

    public Date getLast_acct_date() {
        return last_acct_date;
    }

    public void setLast_acct_date(Date last_acct_date) {
        this.last_acct_date = last_acct_date;
    }

    public Integer getStop_payment_type() {
        return stop_payment_type;
    }

    public void setStop_payment_type(Integer stop_payment_type) {
        this.stop_payment_type = stop_payment_type;
    }

    public String getAcct_type() {
        return acct_type;
    }

    public void setAcct_type(String acct_type) {
        this.acct_type = acct_type == null ? null : acct_type.trim();
    }

    public Integer getAcct_status() {
        return acct_status;
    }

    public void setAcct_status(Integer acct_status) {
        this.acct_status = acct_status;
    }

    public Integer getCur_code() {
        return cur_code;
    }

    public void setCur_code(Integer cur_code) {
        this.cur_code = cur_code;
    }

    public Integer getBalance_mode() {
        return balance_mode;
    }

    public void setBalance_mode(Integer balance_mode) {
        this.balance_mode = balance_mode;
    }

    public String getSub_code() {
        return sub_code;
    }

    public void setSub_code(String sub_code) {
        this.sub_code = sub_code == null ? null : sub_code.trim();
    }

    public BigDecimal getAcct_bal() {
        return acct_bal;
    }

    public void setAcct_bal(BigDecimal acct_bal) {
        this.acct_bal = acct_bal;
    }

    public BigDecimal getAcct_pre_bal() {
        return acct_pre_bal;
    }

    public void setAcct_pre_bal(BigDecimal acct_pre_bal) {
        this.acct_pre_bal = acct_pre_bal;
    }

    public BigDecimal getThen_bal() {
        return then_bal;
    }

    public void setThen_bal(BigDecimal then_bal) {
        this.then_bal = then_bal;
    }

    public Integer getBal_direct() {
        return bal_direct;
    }

    public void setBal_direct(Integer bal_direct) {
        this.bal_direct = bal_direct;
    }

    public BigDecimal getAcct_accum() {
        return acct_accum;
    }

    public void setAcct_accum(BigDecimal acct_accum) {
        this.acct_accum = acct_accum;
    }

    public Integer getTrans_count() {
        return trans_count;
    }

    public void setTrans_count(Integer trans_count) {
        this.trans_count = trans_count;
    }

    public String getDac() {
        return dac;
    }

    public void setDac(String dac) {
        this.dac = dac == null ? null : dac.trim();
    }

    public String getCtrl_flag() {
        return ctrl_flag;
    }

    public void setCtrl_flag(String ctrl_flag) {
        this.ctrl_flag = ctrl_flag == null ? null : ctrl_flag.trim();
    }

    public BigDecimal getReserv_num1() {
        return reserv_num1;
    }

    public void setReserv_num1(BigDecimal reserv_num1) {
        this.reserv_num1 = reserv_num1;
    }

    public Integer getReserv_num2() {
        return reserv_num2;
    }

    public void setReserv_num2(Integer reserv_num2) {
        this.reserv_num2 = reserv_num2;
    }

    public String getReserv_str1() {
        return reserv_str1;
    }

    public void setReserv_str1(String reserv_str1) {
        this.reserv_str1 = reserv_str1 == null ? null : reserv_str1.trim();
    }

    public String getReserv_str2() {
        return reserv_str2;
    }

    public void setReserv_str2(String reserv_str2) {
        this.reserv_str2 = reserv_str2 == null ? null : reserv_str2.trim();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Account other = (Account) that;
        return (this.getAcct_no() == null ? other.getAcct_no() == null : this.getAcct_no().equals(other.getAcct_no()))
            && (this.getAcct_seqno() == null ? other.getAcct_seqno() == null : this.getAcct_seqno().equals(other.getAcct_seqno()))
            && (this.getCust_no() == null ? other.getCust_no() == null : this.getCust_no().equals(other.getCust_no()))
            && (this.getCust_name() == null ? other.getCust_name() == null : this.getCust_name().equals(other.getCust_name()))
            && (this.getOpen_bran_code() == null ? other.getOpen_bran_code() == null : this.getOpen_bran_code().equals(other.getOpen_bran_code()))
            && (this.getAcct_bran_code() == null ? other.getAcct_bran_code() == null : this.getAcct_bran_code().equals(other.getAcct_bran_code()))
            && (this.getOpen_date() == null ? other.getOpen_date() == null : this.getOpen_date().equals(other.getOpen_date()))
            && (this.getCancel_date() == null ? other.getCancel_date() == null : this.getCancel_date().equals(other.getCancel_date()))
            && (this.getLast_trans_date() == null ? other.getLast_trans_date() == null : this.getLast_trans_date().equals(other.getLast_trans_date()))
            && (this.getLast_acct_date() == null ? other.getLast_acct_date() == null : this.getLast_acct_date().equals(other.getLast_acct_date()))
            && (this.getStop_payment_type() == null ? other.getStop_payment_type() == null : this.getStop_payment_type().equals(other.getStop_payment_type()))
            && (this.getAcct_type() == null ? other.getAcct_type() == null : this.getAcct_type().equals(other.getAcct_type()))
            && (this.getAcct_status() == null ? other.getAcct_status() == null : this.getAcct_status().equals(other.getAcct_status()))
            && (this.getCur_code() == null ? other.getCur_code() == null : this.getCur_code().equals(other.getCur_code()))
            && (this.getBalance_mode() == null ? other.getBalance_mode() == null : this.getBalance_mode().equals(other.getBalance_mode()))
            && (this.getSub_code() == null ? other.getSub_code() == null : this.getSub_code().equals(other.getSub_code()))
            && (this.getAcct_bal() == null ? other.getAcct_bal() == null : this.getAcct_bal().equals(other.getAcct_bal()))
            && (this.getAcct_pre_bal() == null ? other.getAcct_pre_bal() == null : this.getAcct_pre_bal().equals(other.getAcct_pre_bal()))
            && (this.getThen_bal() == null ? other.getThen_bal() == null : this.getThen_bal().equals(other.getThen_bal()))
            && (this.getBal_direct() == null ? other.getBal_direct() == null : this.getBal_direct().equals(other.getBal_direct()))
            && (this.getAcct_accum() == null ? other.getAcct_accum() == null : this.getAcct_accum().equals(other.getAcct_accum()))
            && (this.getTrans_count() == null ? other.getTrans_count() == null : this.getTrans_count().equals(other.getTrans_count()))
            && (this.getDac() == null ? other.getDac() == null : this.getDac().equals(other.getDac()))
            && (this.getCtrl_flag() == null ? other.getCtrl_flag() == null : this.getCtrl_flag().equals(other.getCtrl_flag()))
            && (this.getReserv_num1() == null ? other.getReserv_num1() == null : this.getReserv_num1().equals(other.getReserv_num1()))
            && (this.getReserv_num2() == null ? other.getReserv_num2() == null : this.getReserv_num2().equals(other.getReserv_num2()))
            && (this.getReserv_str1() == null ? other.getReserv_str1() == null : this.getReserv_str1().equals(other.getReserv_str1()))
            && (this.getReserv_str2() == null ? other.getReserv_str2() == null : this.getReserv_str2().equals(other.getReserv_str2()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getAcct_no() == null) ? 0 : getAcct_no().hashCode());
        result = prime * result + ((getAcct_seqno() == null) ? 0 : getAcct_seqno().hashCode());
        result = prime * result + ((getCust_no() == null) ? 0 : getCust_no().hashCode());
        result = prime * result + ((getCust_name() == null) ? 0 : getCust_name().hashCode());
        result = prime * result + ((getOpen_bran_code() == null) ? 0 : getOpen_bran_code().hashCode());
        result = prime * result + ((getAcct_bran_code() == null) ? 0 : getAcct_bran_code().hashCode());
        result = prime * result + ((getOpen_date() == null) ? 0 : getOpen_date().hashCode());
        result = prime * result + ((getCancel_date() == null) ? 0 : getCancel_date().hashCode());
        result = prime * result + ((getLast_trans_date() == null) ? 0 : getLast_trans_date().hashCode());
        result = prime * result + ((getLast_acct_date() == null) ? 0 : getLast_acct_date().hashCode());
        result = prime * result + ((getStop_payment_type() == null) ? 0 : getStop_payment_type().hashCode());
        result = prime * result + ((getAcct_type() == null) ? 0 : getAcct_type().hashCode());
        result = prime * result + ((getAcct_status() == null) ? 0 : getAcct_status().hashCode());
        result = prime * result + ((getCur_code() == null) ? 0 : getCur_code().hashCode());
        result = prime * result + ((getBalance_mode() == null) ? 0 : getBalance_mode().hashCode());
        result = prime * result + ((getSub_code() == null) ? 0 : getSub_code().hashCode());
        result = prime * result + ((getAcct_bal() == null) ? 0 : getAcct_bal().hashCode());
        result = prime * result + ((getAcct_pre_bal() == null) ? 0 : getAcct_pre_bal().hashCode());
        result = prime * result + ((getThen_bal() == null) ? 0 : getThen_bal().hashCode());
        result = prime * result + ((getBal_direct() == null) ? 0 : getBal_direct().hashCode());
        result = prime * result + ((getAcct_accum() == null) ? 0 : getAcct_accum().hashCode());
        result = prime * result + ((getTrans_count() == null) ? 0 : getTrans_count().hashCode());
        result = prime * result + ((getDac() == null) ? 0 : getDac().hashCode());
        result = prime * result + ((getCtrl_flag() == null) ? 0 : getCtrl_flag().hashCode());
        result = prime * result + ((getReserv_num1() == null) ? 0 : getReserv_num1().hashCode());
        result = prime * result + ((getReserv_num2() == null) ? 0 : getReserv_num2().hashCode());
        result = prime * result + ((getReserv_str1() == null) ? 0 : getReserv_str1().hashCode());
        result = prime * result + ((getReserv_str2() == null) ? 0 : getReserv_str2().hashCode());
        return result;
    }
}