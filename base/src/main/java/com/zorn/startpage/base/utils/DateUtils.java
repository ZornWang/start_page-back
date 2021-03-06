package com.zorn.startpage.base.utils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class DateUtils extends org.apache.commons.lang3.time.DateUtils {
    public static final String yyyy_MM_dd_EN = "yyyy-MM-dd";
    public static final String yyyy_MM_dd_HH_mm_ss_EN = "yyyy-MM-dd HH:mm:ss";
    public static final String yyyy_MM_dd_CN = "yyyy年MM月dd日";
    public static final String yyyy_MM_dd_HH_mm_ss_CN = "yyyy年MM月dd日HH时mm分ss秒";
    private static Map<String, DateFormat> dateFormatMap = new HashMap();

    public DateUtils() {
    }

    public static DateFormat getDateFormat(String formatStr) {
        DateFormat df = (DateFormat) dateFormatMap.get(formatStr);
        if (df == null) {
            df = new SimpleDateFormat(formatStr);
            dateFormatMap.put(formatStr, df);
        }

        return (DateFormat) df;
    }

    public static String dateToString(Date date, String dateFormatStr) {
        DateFormat format = getDateFormat(dateFormatStr);
        return date != null ? format.format(date) : null;
    }

    public static Date stringToDate(String dateTimeStr, String dateFormatStr) {
        try {
            if (dateTimeStr != null && !dateTimeStr.equals("") && !dateTimeStr.equals("General")) {
                DateFormat format = getDateFormat(dateFormatStr);
                System.out.println(dateTimeStr);
                Date date = format.parse(dateTimeStr);
                return date;
            } else {
                return null;
            }
        } catch (ParseException var4) {
            throw new RuntimeException(var4);
        }
    }

    /**
     * 获取一天后的timestamp
     * @param timestamp
     * @return
     */
    public static Timestamp getAfterDayTimestamp(Timestamp timestamp){
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(new Date(timestamp.getTime()));
        calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) + 1);
        return new Timestamp(calendar.getTime().getTime());
    }

    /**
     * 获取一天前的timestamp
     * @param timestamp
     * @return
     */
    public static Timestamp getBeforeDayTimestamp(Timestamp timestamp){
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(new Date(timestamp.getTime()));
        calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) - 1);
        return new Timestamp(calendar.getTime().getTime());
    }

    /**
     * 获取时间的年月日
     * @param timestamp
     * @return
     */
    public static Timestamp getDate(Timestamp timestamp){
        Date date=new Date(timestamp.getTime());
        String dateStr=dateToString(date,yyyy_MM_dd_HH_mm_ss_EN);
        return new Timestamp(stringToDate(dateStr,yyyy_MM_dd_EN).getTime());
    }

    /**
     * 获得几天后的时间
     */
    public static Timestamp getTimeAfterDay(Integer day) {
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) + day);
        return new Timestamp(calendar.getTime().getTime());
    }
}
