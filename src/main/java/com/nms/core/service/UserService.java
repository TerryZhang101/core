package com.nms.core.service;

import java.util.Map;

import com.alibaba.fastjson.JSONObject;

/**
 * @author cja
 * @date 2017年9月13日
 */
public interface UserService {

	Integer register(JSONObject jsonObj);

	void logon(JSONObject jsonObj, Map<String, Object> responseMap);

	int logonPwdReset(JSONObject jsonObj);

	int logonPwdModify(JSONObject jsonObj);

	int tranPwdModify(JSONObject jsonObj);

	int tranPwdReset(JSONObject jsonObj);

	int regMobileChange(JSONObject jsonObj);

	int regInfoUpdate(JSONObject jsonObj);

	int nsIdentify(JSONObject jsonObj);

	void nsIdentifiedInfoQry(JSONObject jsonObj, Map<String, Object> responseMap);

}
