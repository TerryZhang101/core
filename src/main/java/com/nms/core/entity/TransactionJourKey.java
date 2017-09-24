package com.nms.core.entity;

import java.util.Date;

public class TransactionJourKey {
    private Date setDate;

    private String operNo;

    private String seqno;

    private String subSeqno;

    public TransactionJourKey(Date setDate, String operNo, String seqno, String subSeqno) {
        this.setDate = setDate;
        this.operNo = operNo;
        this.seqno = seqno;
        this.subSeqno = subSeqno;
    }

    public TransactionJourKey() {
        super();
    }

    public Date getSetDate() {
        return setDate;
    }

    public void setSetDate(Date setDate) {
        this.setDate = setDate;
    }

    public String getOperNo() {
        return operNo;
    }

    public void setOperNo(String operNo) {
        this.operNo = operNo == null ? null : operNo.trim();
    }

    public String getSeqno() {
        return seqno;
    }

    public void setSeqno(String seqno) {
        this.seqno = seqno == null ? null : seqno.trim();
    }

    public String getSubSeqno() {
        return subSeqno;
    }

    public void setSubSeqno(String subSeqno) {
        this.subSeqno = subSeqno == null ? null : subSeqno.trim();
    }

    @Override
    public String toString() {
        return "TransactionJourKey{" +
                "setDate=" + setDate +
                ", operNo='" + operNo + '\'' +
                ", seqno='" + seqno + '\'' +
                ", subSeqno='" + subSeqno + '\'' +
                '}';
    }
}