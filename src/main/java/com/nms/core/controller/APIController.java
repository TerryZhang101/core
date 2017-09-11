package com.nms.core.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.nms.core.service.impl.serviceImpl;
import com.nms.core.service.service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by syx on 17/7/12.
 */

@Controller
public class APIController {

    private static final Logger logger = LoggerFactory.getLogger(APIController.class);

    @RequestMapping("/test.do")
    @ResponseBody
    public void test(@RequestBody JSONObject jsonObj, HttpServletRequest req, HttpServletResponse response) throws Exception {

        logger.info("begin to call WebsocketController!");
        response.setCharacterEncoding("UTF-8");
        //页面传值
        String data = jsonObj.getString("data");

        Map responseMap = new HashMap();
        try {
            service websocketService = new serviceImpl();
            responseMap = websocketService.proxyQuery(data);
            responseMap.put("message", responseMap.toString());
        } catch (Exception e) {
            logger.debug(e.getMessage());
            responseMap.put("message", "错误信息:"+e.getMessage());
            e.printStackTrace();
        }
        String toJSONString = JSON.toJSONString(responseMap);
        response.getWriter().write(toJSONString);
        response.getWriter().flush();
    }
}