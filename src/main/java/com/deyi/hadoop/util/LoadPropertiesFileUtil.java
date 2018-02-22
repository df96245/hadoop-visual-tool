package com.deyi.hadoop.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class LoadPropertiesFileUtil {
	private static Logger logger=LoggerFactory.getLogger(LoadPropertiesFileUtil.class);
	private static Properties properties= new Properties();
	
	static {
		InputStream ins =LoadPropertiesFileUtil.class.getClassLoader().getResourceAsStream("url.properties");
    	try {
    		properties.load(ins);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String getProperty(String key) {
		String value=properties.getProperty(key);
		logger.info("key:"+key +" value:"+value);
		return value;
	}
	

}
