package com.njarston.datamodule.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.regex.Pattern;

/**
 * Created by syx on 17-6-13.
 */
public class MapUtil {

    public static Map<String, Object> convertRequestToMap(HttpServletRequest req){

        String k = "";
        Map<String, Object> map = new HashMap<String, Object>();
        Enumeration e = req.getParameterNames();
        while(e.hasMoreElements()){
            k = (String)e.nextElement();
            map.put(k, req.getParameter(k));
        }
        return map;
    }

    public static Map<String, Object> convertStringToMap(String str,String temp1,String temp2) {

        String[] strs = str.split(temp1);

        Map<String,Object> map = new HashMap<String,Object>();

        for (int i = 0;i<strs.length;i++){
            String string = strs[i];
            String[] strings = string.split(temp2);
            if ("Source".equals(strings[0])){
                map.put(strings[0],strings[2]+"|"+strings[3]+"|"+strings[4]);
            }else {
                map.put(strings[0],strings[2]);
            }
        }
        return map;
    }

    public static List<Map<String, Object>> listChange(List<List<String>> list) {

        List result = new ArrayList();
        List title = list.get(1);

        for (int i = 2;i<list.size();i++){
            Map map = new HashMap();
            for (int j = 0;j<title.size();j++){

                map.put(title.get(j),list.get(i).get(j));
            }
            result.add(map);
        }
        return result;
    }

    public static List<Map<String, Object>> excelStringToListLocal(String str,String TypeCode, String temp1, String temp2) {

        String[] strs = str.split(temp1);
        String[] title = strs[0].split(temp2);
        List<Map<String,Object>> list = new ArrayList<>();
        for (int i = 1;i<strs.length;i++){
            String string = strs[i];
            String[] strings = string.split(temp2);
            Map<String,Object> map = new HashMap<>();
            for (int j=0;j<title.length;j++){
                map.put(title[j],strings[j]);
            }
            map.put("TypeCode",TypeCode);
            list.add(map);
        }
        return list;
    }


    public static String attrDataTypeChange(String str) {

        //TODO 目前是sqlserver数据库类型对应
        if ("varchar".equals(str)||"char".equals(str)||"nchar".equals(str)||"nvarchar".equals(str))
            str = "0";
        else if ("int".equals(str)||"bit".equals(str)||"smallint".equals(str)||"tinyint".equals(str))
            str = "1";
        else if ("bigint".equals(str))
            str = "2";
        else if ("decimal".equals(str)||"numeric".equals(str)||"float".equals(str)||"real".equals(str)||"smallmoney".equals(str)||"money".equals(str))//货币类型归入这一类
            str = "3";
        else if ("bit".equals(str))
            str = "4";
        else if ("Smalldatetime".equals(str)||"datetime".equals(str))
            str = "5";
        else if ("date".equals(str))//sqlserver中无对应
            str = "6";
        else if ("time".equals(str))//sqlserver中无对应
            str = "7";
        else if ("binary".equals(str)||"varbinary".equals(str)||"image".equals(str))
            str = "8";
        else if ("dictionary".equals(str)||"text".equals(str)||"ntext".equals(str))//sqlserver中无对应，将text和ntext归为这一类
            str = "9";

        return str;
    }

}
