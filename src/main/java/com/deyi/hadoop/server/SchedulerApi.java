package com.deyi.hadoop.server;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.deyi.hadoop.thread.EnrichDataThread;
import com.deyi.hadoop.util.LoadPropertiesFileUtil;

public class SchedulerApi {
    public static void main(String[] args) throws IOException {
    	String url=LoadPropertiesFileUtil.getProperty("scheduler.url");
    	String timeIntervalCal=LoadPropertiesFileUtil.getProperty("time.intervals.api.call");
    	new Thread(new EnrichDataThread(url,Integer.parseInt(timeIntervalCal))).start();
    }
}
