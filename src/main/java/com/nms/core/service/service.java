package com.nms.core.service;

import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by syx on 17/8/3.
 */
@Service("websocketService")
public interface service {

    Map proxyQuery(String data);

}
