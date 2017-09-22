package com.nms.core.dao;

import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository("systemMapper")
public interface SystemMapper {

    //日志记录
    int journal(Map<String, String> param);
}