package com.ajashop.web.common.util;

/**
 * First Editor : dereklee
 * Last Editor  : dereklee
 * Date         : 2017-07-30
 * Description  :
 * Copyright ⓒ 2013-2015 dereklee All rights reserved.
 * version      : v0.1
 */

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DateUtils {
	final static String TZ_UTC = "UTC";
	final static String TZ_SEOUL = "Asia/Seoul";
	final static String TZ_SHANGHAI = "Asia/Shanghai";
	
	public static String convertTimezone(TimeZone from, TimeZone to, String dateformat, String datetime) throws ParseException {
		DateFormat dateFormat  = new SimpleDateFormat(dateformat);
		Date utcDate = DateUtils.datetime2date(dateFormat, from, datetime);
		return DateUtils.date2string(dateFormat, to, utcDate);
	}
	
	public static String utc2seoul(String dateformat, String datetime) throws ParseException {
		TimeZone utcTimeZone = TimeZone.getTimeZone(TZ_UTC); 
		TimeZone asiaSeoulTimeZone = TimeZone.getTimeZone(TZ_SEOUL); 
		return DateUtils.convertTimezone(utcTimeZone, asiaSeoulTimeZone, dateformat, datetime);
	}
	public static String utc2beijing(String dateformat, String datetime) throws ParseException {
		TimeZone utcTimeZone = TimeZone.getTimeZone(TZ_UTC); 
		TimeZone asiaShanghaiTimeZone = TimeZone.getTimeZone(TZ_SHANGHAI);  
		return DateUtils.convertTimezone(utcTimeZone, asiaShanghaiTimeZone, dateformat, datetime);
	}
	
	public static Date datetime2date(DateFormat dateFormat, TimeZone timeZone, String datetime) throws ParseException {
		dateFormat.setTimeZone(timeZone);
		return dateFormat.parse(datetime);
	}
	public static String date2string(DateFormat dateFormat, TimeZone timeZone, Date date) {
		dateFormat.setTimeZone(timeZone);
		return dateFormat.format(date);
	}
	
	public static void main(String... args) throws ParseException {
		// UTC -> 한국표준시
		System.out.println("한국표준시:" + DateUtils.utc2seoul("yyyy-MM-dd HH:mm:ss", "2016-02-23 07:33:16"));
		System.out.println("한국표준시:" + DateUtils.utc2seoul("yyyyMMddHHmmss", "20160223084157"));
		
		// UTC -> 중국표준시 (베이징, 상하이?)
		System.out.println("중국표준시:" + DateUtils.utc2beijing("yyyy-MM-dd HH:mm:ss", "2016-02-23 07:33:16"));
		System.out.println("중국표준시:" + DateUtils.utc2beijing("yyyyMMddHHmmss", "20160223084157"));
		
		
		TimeZone asiaSeoulTimeZone = TimeZone.getTimeZone(DateUtils.TZ_SEOUL); 
		TimeZone asiaShanghaiTimeZone = TimeZone.getTimeZone(DateUtils.TZ_SHANGHAI);
		System.out.println(DateUtils.convertTimezone(asiaSeoulTimeZone, asiaShanghaiTimeZone, "yyyy-MM-dd HH:mm:ss", "2016-02-23 07:33:16"));
		
	}
}
