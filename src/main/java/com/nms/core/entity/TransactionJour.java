package com.nms.core.entity;

import java.math.BigDecimal;
import java.util.Date;

public class TransactionJour extends TransactionJourKey {
    private String transBranCode;

    private Date transDate;

    private Date transTime;

    private String transCode;

    private String extSeqno;

    private String acctNo;

    private String acctSeqno;

    private Integer dcFlag;

    private BigDecimal transAmt;

    private String oppAcctNo;

    private String abs;

    private String transStatus;

    private Integer rcvpkglen;

    private String rcvbuf1;

    private String rcvbuf2;

    private Integer sndpkglen;

    private String sndbuf1;

    private String sndbuf2;

    private String response;

    private String respdesc;

    public TransactionJour(Date setDate, String operNo, String seqno, String subSeqno, String transBranCode, Date transDate, Date transTime, String transCode, String extSeqno, String acctNo, String acctSeqno, Integer dcFlag, BigDecimal transAmt, String oppAcctNo, String abs, String transStatus, Integer rcvpkglen, String rcvbuf1, String rcvbuf2, Integer sndpkglen, String sndbuf1, String sndbuf2, String response, String respdesc) {
        super(setDate, operNo, seqno, subSeqno);
        this.transBranCode = transBranCode;
        this.transDate = transDate;
        this.transTime = transTime;
        this.transCode = transCode;
        this.extSeqno = extSeqno;
        this.acctNo = acctNo;
        this.acctSeqno = acctSeqno;
        this.dcFlag = dcFlag;
        this.transAmt = transAmt;
        this.oppAcctNo = oppAcctNo;
        this.abs = abs;
        this.transStatus = transStatus;
        this.rcvpkglen = rcvpkglen;
        this.rcvbuf1 = rcvbuf1;
        this.rcvbuf2 = rcvbuf2;
        this.sndpkglen = sndpkglen;
        this.sndbuf1 = sndbuf1;
        this.sndbuf2 = sndbuf2;
        this.response = response;
        this.respdesc = respdesc;
    }

    public TransactionJour() {
        super();
    }

    public String getTransBranCode() {
        return transBranCode;
    }

    public void setTransBranCode(String transBranCode) {
        this.transBranCode = transBranCode == null ? null : transBranCode.trim();
    }

    public Date getTransDate() {
        return transDate;
    }

    public void setTransDate(Date transDate) {
        this.transDate = transDate;
    }

    public Date getTransTime() {
        return transTime;
    }

    public void setTransTime(Date transTime) {
        this.transTime = transTime;
    }

    public String getTransCode() {
        return transCode;
    }

    public void setTransCode(String transCode) {
        this.transCode = transCode == null ? null : transCode.trim();
    }

    public String getExtSeqno() {
        return extSeqno;
    }

    public void setExtSeqno(String extSeqno) {
        this.extSeqno = extSeqno == null ? null : extSeqno.trim();
    }

    public String getAcctNo() {
        return acctNo;
    }

    public void setAcctNo(String acctNo) {
        this.acctNo = acctNo == null ? null : acctNo.trim();
    }

    public String getAcctSeqno() {
        return acctSeqno;
    }

    public void setAcctSeqno(String acctSeqno) {
        this.acctSeqno = acctSeqno == null ? null : acctSeqno.trim();
    }

    public Integer getDcFlag() {
        return dcFlag;
    }

    public void setDcFlag(Integer dcFlag) {
        this.dcFlag = dcFlag;
    }

    public BigDecimal getTransAmt() {
        return transAmt;
    }

    public void setTransAmt(BigDecimal transAmt) {
        this.transAmt = transAmt;
    }

    public String getOppAcctNo() {
        return oppAcctNo;
    }

    public void setOppAcctNo(String oppAcctNo) {
        this.oppAcctNo = oppAcctNo == null ? null : oppAcctNo.trim();
    }

    public String getAbs() {
        return abs;
    }

    public void setAbs(String abs) {
        this.abs = abs == null ? null : abs.trim();
    }

    public String getTransStatus() {
        return transStatus;
    }

    public void setTransStatus(String transStatus) {
        this.transStatus = transStatus == null ? null : transStatus.trim();
    }

    public Integer getRcvpkglen() {
        return rcvpkglen;
    }

    public void setRcvpkglen(Integer rcvpkglen) {
        this.rcvpkglen = rcvpkglen;
    }

    public String getRcvbuf1() {
        return rcvbuf1;
    }

    public void setRcvbuf1(String rcvbuf1) {
        this.rcvbuf1 = rcvbuf1 == null ? null : rcvbuf1.trim();
    }

    public String getRcvbuf2() {
        return rcvbuf2;
    }

    public void setRcvbuf2(String rcvbuf2) {
        this.rcvbuf2 = rcvbuf2 == null ? null : rcvbuf2.trim();
    }

    public Integer getSndpkglen() {
        return sndpkglen;
    }

    public void setSndpkglen(Integer sndpkglen) {
        this.sndpkglen = sndpkglen;
    }

    public String getSndbuf1() {
        return sndbuf1;
    }

    public void setSndbuf1(String sndbuf1) {
        this.sndbuf1 = sndbuf1 == null ? null : sndbuf1.trim();
    }

    public String getSndbuf2() {
        return sndbuf2;
    }

    public void setSndbuf2(String sndbuf2) {
        this.sndbuf2 = sndbuf2 == null ? null : sndbuf2.trim();
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response == null ? null : response.trim();
    }

    public String getRespdesc() {
        return respdesc;
    }

    public void setRespdesc(String respdesc) {
        this.respdesc = respdesc == null ? null : respdesc.trim();
    }

    @Override
    public String toString() {
        return "TransactionJour{" +
                "transBranCode='" + transBranCode + '\'' +
                ", transDate=" + transDate +
                ", transTime=" + transTime +
                ", transCode='" + transCode + '\'' +
                ", extSeqno='" + extSeqno + '\'' +
                ", acctNo='" + acctNo + '\'' +
                ", acctSeqno='" + acctSeqno + '\'' +
                ", dcFlag=" + dcFlag +
                ", transAmt=" + transAmt +
                ", oppAcctNo='" + oppAcctNo + '\'' +
                ", abs='" + abs + '\'' +
                ", transStatus='" + transStatus + '\'' +
                ", rcvpkglen=" + rcvpkglen +
                ", rcvbuf1='" + rcvbuf1 + '\'' +
                ", rcvbuf2='" + rcvbuf2 + '\'' +
                ", sndpkglen=" + sndpkglen +
                ", sndbuf1='" + sndbuf1 + '\'' +
                ", sndbuf2='" + sndbuf2 + '\'' +
                ", response='" + response + '\'' +
                ", respdesc='" + respdesc + '\'' +
                '}';
    }
}