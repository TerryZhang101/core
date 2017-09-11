package com.nms.core.dao;

import org.springframework.stereotype.Repository;

/**
 * Created by ztt on 2017/4/5.
 */
@Repository("merchantMapper")
public interface MerchantMapper {

    /**
     * 验证商户状态
     * @param merCode 商户号
     * @return 商户号状态
     */
    String queryMerState(String merCode);

    //查询商户对应的账户
    String queryMerchantAcctNo(String merCode);

}
