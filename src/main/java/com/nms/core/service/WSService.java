package com.nms.core.service;

import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by syx on 17/8/3.
 */
@org.springframework.stereotype.Service("websocketService")
public interface WSService {

    Map proxyQuery(String data);

}
