package com.nms.core.dao;

import org.apache.ibatis.annotations.Param;

import com.nms.core.entity.Account;
import com.nms.core.entity.AccountKey;

public interface AccountMapper {
    int deleteByPrimaryKey(AccountKey key);

    int insert(Account record);

    int insertSelective(Account record);

    Account selectByPrimaryKey(AccountKey key);

    int updateByPrimaryKeySelective(Account record);

    int updateByPrimaryKey(Account record);

	String getLastAcctNoByAcctType(@Param("acct_type")String acctType);

	String getLastSubAcctSeqNoByAcctNo(@Param("acct_no")String acctNo);
}