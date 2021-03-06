package com.nms.core.service.impl;

import com.nms.core.service.WSService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

    /**
 * Created by ddk on 17/8/17.
 */
public class ServiceImpl implements WSService {

    private final static Logger logger = LoggerFactory.getLogger(ServiceImpl.class);



    public Map proxyQuery(String data) {

        logger.debug("begin to call serviceImpl!");
        Map map = new HashMap();
        logger.debug("显示页面传值："+data);
        map.put("result","传值成功！值为"+data);
        return map;
    }

}
