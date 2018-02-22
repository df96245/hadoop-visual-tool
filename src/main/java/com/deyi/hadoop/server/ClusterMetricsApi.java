package com.deyi.hadoop.server;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.deyi.hadoop.thread.EnrichDataThread;
import com.deyi.hadoop.thread.ExportDataThread;
import com.deyi.hadoop.util.LoadPropertiesFileUtil;

public class ClusterMetricsApi {
    public static void main(String[] args) throws IOException {
    	String url=LoadPropertiesFileUtil.getProperty("cluster.metrics.url");
    	String timeIntervalCal=LoadPropertiesFileUtil.getProperty("time.intervals.api.call");
    	new Thread(new EnrichDataThread(url,Integer.parseInt(timeIntervalCal))).start();
    	new Thread(new ExportDataThread()).start();
    }
}
