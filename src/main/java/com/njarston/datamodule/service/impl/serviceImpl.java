package com.njarston.datamodule.service.impl;

import com.njarston.datamodule.service.service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

    /**
 * Created by ddk on 17/8/17.
 */
public class serviceImpl implements service {

    private final static Logger logger = LoggerFactory.getLogger(serviceImpl.class);



    public Map proxyQuery(String data) {

        logger.debug("begin to call serviceImpl!");
        Map map = new HashMap();
        logger.debug("显示页面传值："+data);
        map.put("result","传值成功！值为"+data);
        return map;
    }

}
