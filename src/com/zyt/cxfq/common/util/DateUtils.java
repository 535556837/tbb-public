package com.zyt.cxfq.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * 日期工具类，用于日期时间与字符串之间的转换
 * 
 * @author xuyang
 * 
 */
public class DateUtils extends org.apache.commons.lang3.time.DateUtils{

	/** 格式：yyyy-MM-dd HH:mm:ss.S */
	public static final String FULL_STANDARD_DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss.S";
	/** 格式：yyyy-MM-dd HH:mm:ss */
	public static final String STANDARD_DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
	/** 格式：yyyy-MM-dd HH:mm */
	public static final String INCOMPLETE_DATETIME_FORMAT = "yyyy-MM-dd HH:mm";
	/** 格式：yyyyMMddHHmmss */
	public static final String SHORT_DATETIME_FORMAT = "yyyyMMddHHmmss";
	/** 格式：yyyy-MM-dd */
	public static final String STANDARD_DATE_FORMAT = "yyyy-MM-dd";
	/** 格式：yyyyMMdd */
	public static final String SHORT_DATE_FORMAT = "yyyyMMdd";
	/** 格式：MMdd */
	public static final String SHORT_MMDD_FORMAT = "MMdd";
	/** 格式：HHmmss */
	public static final String SHORT_TIME_FORMAT = "HHmmss";
	/** 格式: yyyy-MM-dd'T'HH:mm:ss'Z' */
	public static final String UTC_DATETIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'";

	private DateUtils() {
	}
	

	/**
	 * 格式完全日期时间字符串（包含毫秒，标准格式：yyyy-MM-dd HH:mm:ss.S）
	 * 
	 * @param date
	 *            日期时间
	 * @return 完全日期时间字符串
	 */
	public static String formatFullStandardDateTime(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat(FULL_STANDARD_DATETIME_FORMAT);
		return sdf.format(date);
	}

	/**
	 * 格式日期时间字符串（标准格式：yyyy-MM-dd HH:mm:ss）
	 * 
	 * @param date
	 *            日期时间
	 * @return 日期时间字符串
	 */
	public static String formatStandardDateTime(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat(STANDARD_DATETIME_FORMAT);
		return sdf.format(date);
	}

	/**
	 * 格式日期时间字符串（短格式：yyyyMMddHHmmss）
	 * 
	 * @param date
	 *            日期时间
	 * @return 日期时间字符串
	 */
	public static String formatShortDateTime(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat(SHORT_DATETIME_FORMAT);
		return sdf.format(date);
	}

	/**
	 * 格式日期时间字符串（短格式：yyyyMMddHHmmss）
	 * 
	 * @param date
	 *            日期时间
	 * @param zone
	 *            时区
	 * @return 日期时间字符串
	 */
	public static String formatShortDateTime(Date date, TimeZone zone) {
		SimpleDateFormat sdf = new SimpleDateFormat(SHORT_DATETIME_FORMAT);
		sdf.setTimeZone(zone);
		return sdf.format(date);
	}

	/**
	 * 格式日期字符串（标准格式：yyyy-MM-dd）
	 * 
	 * @param date
	 *            日期
	 * @return 日期字符串
	 */
	public static String formatStandardDate(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat(STANDARD_DATE_FORMAT);
		return sdf.format(date);
	}

	/**
	 * 格式日期字符串（短格式：yyyyMMdd）
	 * 
	 * @param date
	 *            日期
	 * @return 日期字符串
	 */
	public static String formatShortDate(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat(SHORT_DATE_FORMAT);
		return sdf.format(date);
	}

	/**
	 * 格式日期字符串（短格式：yyyyMMdd）
	 * 
	 * @param date
	 *            日期
	 * @param zone
	 *            时区
	 * @return 日期字符串
	 */
	public static String formatShortDate(Date date, TimeZone zone) {
		SimpleDateFormat sdf = new SimpleDateFormat(SHORT_DATE_FORMAT);
		sdf.setTimeZone(zone);
		return sdf.format(date);
	}

	/**
	 * 格式日期字符串（短格式：MMdd）
	 * 
	 * @param date
	 *            日期
	 * @return 日期字符串
	 */
	public static String formatShortMMDDDate(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat(SHORT_MMDD_FORMAT);
		return sdf.format(date);
	}

	/**
	 * 格式时间字符串（短格式：HHmmss）
	 * 
	 * @param date
	 *            时间
	 * @return 时间字符串
	 */
	public static String formatShortTime(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat(SHORT_TIME_FORMAT);
		return sdf.format(date);
	}

	/**
	 * 解析完全日期时间字符串（包含毫秒，标准格式：yyyy-MM-dd HH:mm:ss.S）
	 * 
	 * @param dateTimeStr
	 *            完全日期时间字符串
	 * @return 日期时间
	 * @throws ParseException
	 */
	public static Date parseFullStandardDateTime(String dateTimeStr) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(FULL_STANDARD_DATETIME_FORMAT);
		return sdf.parse(dateTimeStr);
	}

	/**
	 * 解析日期时间字符串（标准格式：yyyy-MM-dd HH:mm:ss）
	 * 
	 * @param dateTimeStr
	 *            日期时间字符串
	 * @return 日期时间
	 * @throws ParseException
	 */
	public static Date parseStandardDateTime(String dateTimeStr) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(STANDARD_DATETIME_FORMAT);
		return sdf.parse(dateTimeStr);
	}

	/**
	 * 解析日期时间字符串 (不完整格式：yyyy-MM-dd HH:mm)
	 * 
	 * @param dateTimeStr
	 * @return
	 * @throws ParseException
	 */
	public static Date parseIncompleteDateTime(String dateTimeStr) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(INCOMPLETE_DATETIME_FORMAT);
		return sdf.parse(dateTimeStr);
	}

	/**
	 * 解析日期时间字符串（短格式：yyyyMMddHHmmss）
	 * 
	 * @param dateTimeStr
	 *            日期时间字符串
	 * @return 日期时间
	 * @throws ParseException
	 */
	public static Date parseShortDateTime(String dateTimeStr) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(SHORT_DATETIME_FORMAT);
		return sdf.parse(dateTimeStr);
	}

	/**
	 * 解析日期时间字符串（短格式：yyyyMMddHHmmss）
	 * 
	 * @param dateTimeStr
	 *            日期时间字符串
	 * @param zone
	 *            时区
	 * @return 日期时间
	 * @throws ParseException
	 */
	public static Date parseShortDateTime(String dateTimeStr, TimeZone zone) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(SHORT_DATETIME_FORMAT);
		sdf.setTimeZone(zone);
		return sdf.parse(dateTimeStr);
	}

	/**
	 * 解析日期字符串（标准格式：yyyy-MM-dd）
	 * 
	 * @param dateStr
	 *            日期字符串
	 * @return 日期
	 * @throws ParseException
	 */
	public static Date parseStandardDate(String dateStr) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(STANDARD_DATE_FORMAT);
		return sdf.parse(dateStr);
	}

	/**
	 * 解析日期字符串（短格式：yyyyMMdd）
	 * 
	 * @param dateStr
	 *            日期字符串
	 * @return 日期
	 * @throws ParseException
	 */
	public static Date parseShortDate(String dateStr) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(SHORT_DATE_FORMAT);
		return sdf.parse(dateStr);
	}

	/**
	 * 解析日期字符串（短格式：yyyyMMdd）
	 * 
	 * @param dateStr
	 *            日期字符串
	 * @param zone
	 *            时区
	 * @return 日期
	 * @throws ParseException
	 */
	public static Date parseShortDate(String dateStr, TimeZone zone) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(SHORT_DATE_FORMAT);
		sdf.setTimeZone(zone);
		return sdf.parse(dateStr);
	}

	/**
	 * 解析日期字符串（短格式：MMdd）
	 * 
	 * @param dateStr
	 *            日期字符串
	 * @return 日期
	 * @throws ParseException
	 */
	public static Date parseShortMMDDDate(String dateStr) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(SHORT_MMDD_FORMAT);
		return sdf.parse(dateStr);
	}

	/**
	 * 解析时间字符串（短格式：HHmmss）
	 * 
	 * @param dateStr
	 *            时间字符串
	 * @return 时间
	 * @throws ParseException
	 */
	public static Date parseShortTime(String dateStr) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(SHORT_TIME_FORMAT);
		return sdf.parse(dateStr);
	}

	/**
	 * 获取传入日期的上一天
	 * 
	 * @param date
	 * @return 日期
	 */
	public static Date getStandardDatePre(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, -1);
		return cal.getTime();
	}

	/**
	 * 获取传入日期的下一天
	 * 
	 * @param date
	 * @return 日期
	 */
	public static Date getStandardDateNext(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, 1);
		return cal.getTime();
	}

	/**
	 * 获取指定日期的0时0分0秒
	 * 
	 * @param date
	 * @return
	 */
	public static Date getStartTimeOfDay(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}

	/**
	 * 获取当天的0时0分0秒
	 * 
	 * @return
	 */
	public static Date getStartTimeOfToday() {
		return getStartTimeOfDay(new Date());
	}

	/**
	 * 获取当前日期时间字符串（标准格式：yyyy-MM-dd HH:mm:ss）
	 * 
	 * @return 日期时间字符串
	 */
	public static String getStandardNowDateTime() {
		return formatStandardDateTime(new Date());
	}

	/**
	 * 获取当前日期时间字符串（短格式：yyyyMMddHHmmss）
	 * 
	 * @return 日期时间字符串
	 */
	public static String getShortNowDateTime() {
		return formatShortDateTime(new Date());
	}

	/**
	 * 获取当前日期字符串（标准格式：yyyy-MM-dd）
	 * 
	 * @return 日期字符串
	 */
	public static String getStandardNowDate() {
		return formatStandardDate(new Date());
	}

	/**
	 * 获取当前日期字符串（短格式：yyyyMMdd）
	 * 
	 * @return 日期字符串
	 */
	public static String getShortNowDate() {
		return formatShortDate(new Date());
	}

	/**
	 * 获取当前日期时间字符串（格式：yyyy-MM-dd'T'HH:mm:ss'Z'）
	 * <p>
	 * UTC时间对应的时区是GMT-0:00
	 * 
	 * @return 日期时间字符串
	 */
	public static String getUTCDateTime() {
		SimpleDateFormat sdf = new SimpleDateFormat(UTC_DATETIME_FORMAT);
		sdf.setTimeZone(TimeZone.getTimeZone("GMT-0:00"));
		return sdf.format(new Date());
	}

	
	private static String[] parsePatterns = {
		"yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy-MM", 
		"yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyy/MM",
		"yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm", "yyyy.MM"};

	/**
	 * 日期型字符串转化为日期 格式
	 * { "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", 
	 *   "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm",
	 *   "yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm" }
	 */
	public static Date parseDate(Object str) {
		if (str == null){
			return null;
		}
		try {
			return parseDate(str.toString(), parsePatterns);
		} catch (ParseException e) {
			return null;
		}
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
    /**
     * 按照format的格式表现出日期
     * @param date
     * @param format
     * @return
     */
    public static String format(Date date,String format){
    	return new SimpleDateFormat(format).format(date);
    }
}
