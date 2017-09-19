package com.nms.core.util;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSONObject;

/**
 * 
 * @author cja
 * @date 2017年9月17日
 */
public class ParamCheckUtil {
	public static boolean isEmpty(Object obj) {
		if(obj instanceof Integer ) {
			return obj == null || (Integer)obj == 0;
		} else if(obj instanceof String) {
			return StringUtils.isEmpty((String)obj);
		}
		return obj == null;
	}
	
	public static boolean isEmpty(JSONObject jsonObj, Object... objs) {
		boolean flag = false;
		for(Object obj : objs ) {
			if(isEmpty(jsonObj.get(obj))) flag = true;
		}
		
		return flag;
	}
}
