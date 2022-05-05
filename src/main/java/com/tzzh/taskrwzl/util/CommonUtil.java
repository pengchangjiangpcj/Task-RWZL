package com.tzzh.taskrwzl.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: PCJ
 * @Create: 2022-03-31 15:56
 * @ClassName: 工具类
 **/
public class CommonUtil {
    /**
     * 获取当前服务器时间
     * @return date
     */
    public static Date getNowTime(){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sdf.format(date);
        Date time = null;
        try {
            time = sdf.parse(format);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return time;
    }

    /**
     * 获取当前服务器时间
     * @return string
     */
    public static String getNowTimeStr(){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd-HHmmss");
        String format = sdf.format(date);
        return format;
    }

    public static int getTotalPage(int pageSize,int totalRow){
        int totalPage = 0;
        if (totalRow == 0) {
            totalPage = 1;
        } else if (totalRow % pageSize == 0) {
            totalPage = totalRow / pageSize;
        } else {
            totalPage = totalRow / pageSize + 1;
        }
        return totalRow;
    }

    public static <T> Map pageMap(List<T> current, int pageNumber, int pageSize, int totalRow, int totalPage){
        HashMap<Object, Object> map = new HashMap<>();
        map.put("current",current);
        map.put("pageNumber",pageNumber);
        map.put("pageSize",pageSize);
        map.put("totalRow",totalRow);
        map.put("totalPage",totalPage);
        return map;
    }



}
