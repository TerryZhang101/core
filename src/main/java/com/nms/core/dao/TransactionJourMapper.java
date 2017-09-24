package com.nms.core.dao;

import com.nms.core.entity.TransactionJour;
import com.nms.core.entity.TransactionJourKey;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository(value = "transactionJourMapper")
public interface TransactionJourMapper {
    int deleteByPrimaryKey(TransactionJourKey key);

    int insert(TransactionJour record);

    int insertSelective(TransactionJour record);

    TransactionJour selectByPrimaryKey(TransactionJourKey key);

    int updateByPrimaryKeySelective(TransactionJour record);

    int updateByPrimaryKey(TransactionJour record);

    Map<String,String> selectAcctByCustNo(Map<String,String> param);
}