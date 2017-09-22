package com.nms.core.util;

import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.nms.core.enums.ErrorCodeEnum;
import com.nms.core.exception.CoreException;
import com.nms.core.util.helper.SettingHelper;
import com.nms.core.util.kit.SignKit;
import com.nms.core.util.kit.StrKit;

/**
 * 验签、签名工具类
 * @author cja
 * @date 2017年9月17日
 */
public class SignUtil {
	
	private static final String key = SettingHelper.getSetting("key");
	
	/**
	 * 验签
	 * @param jsonObj
	 * @return
	 * @throws CoreException
	 */
	public static void checkSign(JSONObject jsonObj) throws CoreException{
		String checkFlag = SettingHelper.getSetting("checkFlag");
		if("1".equals(checkFlag)){
			boolean checkResult = SignKit.verify(JSON.toJavaObject(jsonObj, Map.class), key);
	    	if(!checkResult){
	    		throw new CoreException(ErrorCodeEnum.CHECKSIGNERROR);
	    	}
		}
	}
	
	/**
	 * 签名
	 * @param jsonObj
	 * @return
	 * @throws CoreException
	 */
	public static void sign(Map<String,Object> responseMap) throws CoreException{
		String signFlag = SettingHelper.getSetting("signFlag");
		if("1".equals(signFlag)){
			String nonce_str = StrKit.getRandomUUID();
			responseMap.put("nonce_str", nonce_str);
			String sign = SignKit.createSign(JSON.parseObject(JSON.toJSONString(responseMap), Map.class), key);
			responseMap.put("sign", sign);
		}
	}
}
