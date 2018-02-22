package com.deyi.hadoop.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.deyi.hadoop.thread.EnrichDataThread;

public class DateUtil {
	private static Logger logger=LoggerFactory.getLogger(DateUtil.class);
	
	public static String getDate() {
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return  simpleDateFormat.format(date);
	}
	public static String getDateChina() {
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒");
		return  simpleDateFormat.format(date);
	}
	
	public static String getDate(long time) {
		Date date = new Date(time);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return  simpleDateFormat.format(date);
	}
	
	public static String getDate(String time) {
		Date date = new Date(Long.valueOf(time));
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return  simpleDateFormat.format(date);
	}
	public static String getDate(Date time) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return  simpleDateFormat.format(time);
	}
	
	public static boolean isNewDate() {
		String now = getDate();
		boolean isNewDate=now.contains(LoadPropertiesFileUtil.getProperty("newdate.indicate"));
		logger.info("now is :" + now);
		logger.info("it is a new day ? "+isNewDate);
		return isNewDate;
	}
	public static boolean isMulOf10Mins() {
		String now = getDate();
		boolean isNewDate=now.contains(LoadPropertiesFileUtil.getProperty("newdate.indicate"));
		logger.info("now is :" + now);
		logger.info("it is a new day ? "+isNewDate);
		return isNewDate;
	}
	
	public static void main(String[] args) {
		String date=getDate(1516748758248L);
		logger.info(date);
	}
	
}
