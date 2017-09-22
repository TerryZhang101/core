package com.nms.core.interceptor;


import com.nms.core.dao.SystemMapper;
import com.nms.core.spring.SpringApplicationContext;

import java.util.Map;

/**
 * 异步记录日志
 * Created by K on 2017/9/20.
 */
public class AysnDBRecorder extends Thread {

    private Map<String, String> dbParam = null;

    public AysnDBRecorder(Map<String, String> dbParam){
        this.dbParam = dbParam;
    }

    public void run() {
        SystemMapper systemMapper = (SystemMapper) SpringApplicationContext.getBean("systemMapper");
//        systemMapper.journal(dbParam);//TODO 记录日志
    }
}
