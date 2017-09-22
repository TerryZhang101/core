/**
 * 
 */
package com.nms.core.util;

import com.nms.core.enums.ErrorCodeEnum;
import com.nms.core.exception.CoreException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

	/**
	 * 转换为时间（天,时:分:秒.毫秒）
	 * @param timeMillis
	 * @return
	 */
	public static String formatDateTime(long timeMillis){
		long day = timeMillis/(24*60*60*1000);
		long hour = (timeMillis/(60*60*1000)-day*24);
		long min = ((timeMillis/(60*1000))-day*24*60-hour*60);
		long s = (timeMillis/1000-day*24*60*60-hour*60*60-min*60);
		long sss = (timeMillis-day*24*60*60*1000-hour*60*60*1000-min*60*1000-s*1000);
		return (day>0?day+",":"")+hour+":"+min+":"+s+"."+sss;
	}
}
