package com.nms.core.util;

import com.nms.core.enums.ErrorCodeEnum;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author cja
 * @date 2017年9月17日
 */
public class ResponseFormatUtil{
	public static Map<String, Object> formatResponse(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ec", "0");
		return formatResponse(map);
	}
	
	public static <T> Map<String, Object> formatResponse(List<T> list){
		Map<String, Object> map = new HashMap<String, Object>();
		if(list != null){
			map.put("list", list);
		}
		map.put("ec", "0");
		map.put("em", "SUCCESS");
		return map;
	}
	
	public static Map<String, Object> formatResponse(Map<String, Object> map){
		if(map == null){
			map = new HashMap<String, Object>();
		}
		if(map.get("error") != null && map.get("error") instanceof ErrorCodeEnum) {
			ErrorCodeEnum ece = (ErrorCodeEnum) map.get("error");
			HashMap<String, Object> errorMap = new HashMap<String, Object>();
			errorMap.put("ec", ece.getValue());
			errorMap.put("em", ece.getText());
			return errorMap;
		}
		
		if(map.get("error") != null && map.get("error") instanceof String) {
			HashMap<String, Object> errorMap = new HashMap<String, Object>();
			errorMap.put("ec", "-1");
			errorMap.put("em", map.get("error"));
			return errorMap;
		}
		
		map.put("ec", "0");
		map.put("em", "SUCCESS");
		return map;
	}
	
	public static <T> Map<String, Object> formatResponseDomain(T t) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("entity", t);
		map.put("ec", "0");
		map.put("em", "SUCCESS");
		return map;
	}
	
	public static Map<String, Object> formatResponseError(ErrorCodeEnum ece) {
		HashMap<String, Object> errorMap = new HashMap<String, Object>();
		errorMap.put("ec", ece.getValue());
		errorMap.put("em", ece.getText());
		return errorMap;
	}
}
