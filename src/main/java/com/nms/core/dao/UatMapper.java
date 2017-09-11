package com.nms.core.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by syx on 2017/6/13.
 */

@Repository("uatMapper")
@Transactional(value = "transactionManager_uat" ,rollbackForClassName={"java.lang.Exception"})
public interface UatMapper {

    /**
     * 查询表信息
     * @param sql 表名
     * @return
     */
    void insertDataByBatch(@Param("insertData") String sql) throws Exception;

    void insertSingleData(@Param("insertData") String sql) throws Exception;

    Integer queryUatCount(@Param("count") String sql);

    List<Map<String, Object>> queryColumnsRelation(@Param("columnsRelation") String sql);

}
