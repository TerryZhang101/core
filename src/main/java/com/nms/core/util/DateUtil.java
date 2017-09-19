/**
 * 
 */
package com.nms.core.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.nms.core.enums.ErrorCodeEnum;
import com.nms.core.exception.CoreException;

/**
 * 日期处理工具类
 * @author cja
 * @date 2017年9月19日
 */
public class DateUtil {
	
	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	
	public static Date string2Date(String time,String format) {
		try {
			SimpleDateFormat sd = new SimpleDateFormat(format);
			return sd.parse(time);
		} catch (ParseException e) {
			throw new CoreException(ErrorCodeEnum.DATEFORMATERROR);
		}
	}
	
	public static Date string2Date(String time) {
		try {
			return sdf.parse(time);
		} catch (ParseException e) {
			throw new CoreException(ErrorCodeEnum.DATEFORMATERROR);
		}
	}
	
	public static String Date2String(Date date,String format) {
		SimpleDateFormat sd = new SimpleDateFormat(format);
		return sd.format(date);
	}
	
	public static String Date2String(Date date) {
		return Date2String(date,"yyyyMMdd");
	}
}
