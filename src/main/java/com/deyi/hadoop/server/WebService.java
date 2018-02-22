package com.deyi.hadoop.server;

import com.deyi.hadoop.thread.EnrichDataThread;
import com.deyi.hadoop.util.LoadPropertiesFileUtil;

public class WebService {
    public static void main(String[] args) {
    	String timeIntervalCal=LoadPropertiesFileUtil.getProperty("time.intervals.api.call");
    	String url=LoadPropertiesFileUtil.getProperty("webservice.test.url");
    	new Thread(new EnrichDataThread(url,Integer.parseInt(timeIntervalCal))).start();
    }
}
