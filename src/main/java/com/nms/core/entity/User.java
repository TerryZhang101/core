package com.nms.core.entity;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    private Integer id;

    private String name;

    private String alias;

    private String cert_no;

    private String mobile_no;

    private Integer star_lvl;

    private String area_belong;

    private Integer state;

    private Integer up_id;

    private Integer rec_id;

    private String head_quarter;

    private String address;

    private Integer type;

    private String logon_pwd;

    private String tran_pwd;

    private Date reg_date;

    private Date due_date;

    private String img_front_url;

    private String img_back_url;

    private String corpor_name;

    private String regist_no;

    private String legal_person;

    private String regist_addr;

    private Integer auth_state;

    private String img_busi_lic_url;

    private Date busi_lic_due;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias == null ? null : alias.trim();
    }

    public String getCert_no() {
        return cert_no;
    }

    public void setCert_no(String cert_no) {
        this.cert_no = cert_no == null ? null : cert_no.trim();
    }

    public String getMobile_no() {
        return mobile_no;
    }

    public void setMobile_no(String mobile_no) {
        this.mobile_no = mobile_no == null ? null : mobile_no.trim();
    }

    public Integer getStar_lvl() {
        return star_lvl;
    }

    public void setStar_lvl(Integer star_lvl) {
        this.star_lvl = star_lvl;
    }

    public String getArea_belong() {
        return area_belong;
    }

    public void setArea_belong(String area_belong) {
        this.area_belong = area_belong == null ? null : area_belong.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getUp_id() {
        return up_id;
    }

    public void setUp_id(Integer up_id) {
        this.up_id = up_id;
    }

    public Integer getRec_id() {
        return rec_id;
    }

    public void setRec_id(Integer rec_id) {
        this.rec_id = rec_id;
    }

    public String getHead_quarter() {
        return head_quarter;
    }

    public void setHead_quarter(String head_quarter) {
        this.head_quarter = head_quarter == null ? null : head_quarter.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getLogon_pwd() {
        return logon_pwd;
    }

    public void setLogon_pwd(String logon_pwd) {
        this.logon_pwd = logon_pwd == null ? null : logon_pwd.trim();
    }

    public String getTran_pwd() {
        return tran_pwd;
    }

    public void setTran_pwd(String tran_pwd) {
        this.tran_pwd = tran_pwd == null ? null : tran_pwd.trim();
    }

    public Date getReg_date() {
        return reg_date;
    }

    public void setReg_date(Date reg_date) {
        this.reg_date = reg_date;
    }

    public Date getDue_date() {
        return due_date;
    }

    public void setDue_date(Date due_date) {
        this.due_date = due_date;
    }

    public String getImg_front_url() {
        return img_front_url;
    }

    public void setImg_front_url(String img_front_url) {
        this.img_front_url = img_front_url == null ? null : img_front_url.trim();
    }

    public String getImg_back_url() {
        return img_back_url;
    }

    public void setImg_back_url(String img_back_url) {
        this.img_back_url = img_back_url == null ? null : img_back_url.trim();
    }

    public String getCorpor_name() {
        return corpor_name;
    }

    public void setCorpor_name(String corpor_name) {
        this.corpor_name = corpor_name == null ? null : corpor_name.trim();
    }

    public String getRegist_no() {
        return regist_no;
    }

    public void setRegist_no(String regist_no) {
        this.regist_no = regist_no == null ? null : regist_no.trim();
    }

    public String getLegal_person() {
        return legal_person;
    }

    public void setLegal_person(String legal_person) {
        this.legal_person = legal_person == null ? null : legal_person.trim();
    }

    public String getRegist_addr() {
        return regist_addr;
    }

    public void setRegist_addr(String regist_addr) {
        this.regist_addr = regist_addr == null ? null : regist_addr.trim();
    }

    public Integer getAuth_state() {
        return auth_state;
    }

    public void setAuth_state(Integer auth_state) {
        this.auth_state = auth_state;
    }

    public String getImg_busi_lic_url() {
        return img_busi_lic_url;
    }

    public void setImg_busi_lic_url(String img_busi_lic_url) {
        this.img_busi_lic_url = img_busi_lic_url == null ? null : img_busi_lic_url.trim();
    }

    public Date getBusi_lic_due() {
        return busi_lic_due;
    }

    public void setBusi_lic_due(Date busi_lic_due) {
        this.busi_lic_due = busi_lic_due;
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
        User other = (User) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getAlias() == null ? other.getAlias() == null : this.getAlias().equals(other.getAlias()))
            && (this.getCert_no() == null ? other.getCert_no() == null : this.getCert_no().equals(other.getCert_no()))
            && (this.getMobile_no() == null ? other.getMobile_no() == null : this.getMobile_no().equals(other.getMobile_no()))
            && (this.getStar_lvl() == null ? other.getStar_lvl() == null : this.getStar_lvl().equals(other.getStar_lvl()))
            && (this.getArea_belong() == null ? other.getArea_belong() == null : this.getArea_belong().equals(other.getArea_belong()))
            && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()))
            && (this.getUp_id() == null ? other.getUp_id() == null : this.getUp_id().equals(other.getUp_id()))
            && (this.getRec_id() == null ? other.getRec_id() == null : this.getRec_id().equals(other.getRec_id()))
            && (this.getHead_quarter() == null ? other.getHead_quarter() == null : this.getHead_quarter().equals(other.getHead_quarter()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getLogon_pwd() == null ? other.getLogon_pwd() == null : this.getLogon_pwd().equals(other.getLogon_pwd()))
            && (this.getTran_pwd() == null ? other.getTran_pwd() == null : this.getTran_pwd().equals(other.getTran_pwd()))
            && (this.getReg_date() == null ? other.getReg_date() == null : this.getReg_date().equals(other.getReg_date()))
            && (this.getDue_date() == null ? other.getDue_date() == null : this.getDue_date().equals(other.getDue_date()))
            && (this.getImg_front_url() == null ? other.getImg_front_url() == null : this.getImg_front_url().equals(other.getImg_front_url()))
            && (this.getImg_back_url() == null ? other.getImg_back_url() == null : this.getImg_back_url().equals(other.getImg_back_url()))
            && (this.getCorpor_name() == null ? other.getCorpor_name() == null : this.getCorpor_name().equals(other.getCorpor_name()))
            && (this.getRegist_no() == null ? other.getRegist_no() == null : this.getRegist_no().equals(other.getRegist_no()))
            && (this.getLegal_person() == null ? other.getLegal_person() == null : this.getLegal_person().equals(other.getLegal_person()))
            && (this.getRegist_addr() == null ? other.getRegist_addr() == null : this.getRegist_addr().equals(other.getRegist_addr()))
            && (this.getAuth_state() == null ? other.getAuth_state() == null : this.getAuth_state().equals(other.getAuth_state()))
            && (this.getImg_busi_lic_url() == null ? other.getImg_busi_lic_url() == null : this.getImg_busi_lic_url().equals(other.getImg_busi_lic_url()))
            && (this.getBusi_lic_due() == null ? other.getBusi_lic_due() == null : this.getBusi_lic_due().equals(other.getBusi_lic_due()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getAlias() == null) ? 0 : getAlias().hashCode());
        result = prime * result + ((getCert_no() == null) ? 0 : getCert_no().hashCode());
        result = prime * result + ((getMobile_no() == null) ? 0 : getMobile_no().hashCode());
        result = prime * result + ((getStar_lvl() == null) ? 0 : getStar_lvl().hashCode());
        result = prime * result + ((getArea_belong() == null) ? 0 : getArea_belong().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
        result = prime * result + ((getUp_id() == null) ? 0 : getUp_id().hashCode());
        result = prime * result + ((getRec_id() == null) ? 0 : getRec_id().hashCode());
        result = prime * result + ((getHead_quarter() == null) ? 0 : getHead_quarter().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getLogon_pwd() == null) ? 0 : getLogon_pwd().hashCode());
        result = prime * result + ((getTran_pwd() == null) ? 0 : getTran_pwd().hashCode());
        result = prime * result + ((getReg_date() == null) ? 0 : getReg_date().hashCode());
        result = prime * result + ((getDue_date() == null) ? 0 : getDue_date().hashCode());
        result = prime * result + ((getImg_front_url() == null) ? 0 : getImg_front_url().hashCode());
        result = prime * result + ((getImg_back_url() == null) ? 0 : getImg_back_url().hashCode());
        result = prime * result + ((getCorpor_name() == null) ? 0 : getCorpor_name().hashCode());
        result = prime * result + ((getRegist_no() == null) ? 0 : getRegist_no().hashCode());
        result = prime * result + ((getLegal_person() == null) ? 0 : getLegal_person().hashCode());
        result = prime * result + ((getRegist_addr() == null) ? 0 : getRegist_addr().hashCode());
        result = prime * result + ((getAuth_state() == null) ? 0 : getAuth_state().hashCode());
        result = prime * result + ((getImg_busi_lic_url() == null) ? 0 : getImg_busi_lic_url().hashCode());
        result = prime * result + ((getBusi_lic_due() == null) ? 0 : getBusi_lic_due().hashCode());
        return result;
    }
}