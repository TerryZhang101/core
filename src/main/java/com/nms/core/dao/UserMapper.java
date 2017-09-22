package com.nms.core.dao;

import com.nms.core.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository(value = "userMapper")
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User selectByMobile(@Param("recmd_mobile_no")String recmd_mobile_no);

	User selectByMobileAndLogonPwd(@Param("mobile_no")String mobile_no, @Param("logon_pwd")String logon_pwd);

	int updateLogonPwdById(@Param("id")Integer cust_no, @Param("logon_pwd")String logon_pwd);

	User selectByIdAndLogonPwd(@Param("id")Integer cust_no, @Param("logon_pwd")String logon_pwd);

	User selectByIdAndTranPwd(@Param("id")Integer cust_no, @Param("tran_pwd")String tran_pwd);

	int updateTranPwdById(@Param("id")Integer cust_no, @Param("tran_pwd")String tran_pwd);

	int updateMobileById(@Param("id")Integer cust_no, @Param("mobile_no")String mobile_no_new);
}