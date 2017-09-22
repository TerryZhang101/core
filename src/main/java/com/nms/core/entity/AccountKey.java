package com.nms.core.entity;

import java.io.Serializable;

public class AccountKey implements Serializable {
    private String acct_no;

    private String acct_seqno;

    private static final long serialVersionUID = 1L;

    public String getAcct_no() {
        return acct_no;
    }

    public void setAcct_no(String acct_no) {
        this.acct_no = acct_no == null ? null : acct_no.trim();
    }

    public String getAcct_seqno() {
        return acct_seqno;
    }

    public void setAcct_seqno(String acct_seqno) {
        this.acct_seqno = acct_seqno == null ? null : acct_seqno.trim();
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
        AccountKey other = (AccountKey) that;
        return (this.getAcct_no() == null ? other.getAcct_no() == null : this.getAcct_no().equals(other.getAcct_no()))
            && (this.getAcct_seqno() == null ? other.getAcct_seqno() == null : this.getAcct_seqno().equals(other.getAcct_seqno()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getAcct_no() == null) ? 0 : getAcct_no().hashCode());
        result = prime * result + ((getAcct_seqno() == null) ? 0 : getAcct_seqno().hashCode());
        return result;
    }
}