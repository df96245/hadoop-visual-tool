package com.deyi.hadoop.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.deyi.hadoop.bean.ClusterMetrics;
import com.deyi.hadoop.util.DateUtil;
import com.deyi.hadoop.util.Exportdata;
import com.deyi.hadoop.util.HttpUtil;
import com.deyi.hadoop.util.StaxonUtils;

public class EnrichDataThread implements Runnable{
	private Logger logger=LoggerFactory.getLogger(EnrichDataThread.class);
	private String url;
	private int timeIntervalApiCall;
	
	public EnrichDataThread(String url,int timeIntervalApiCall) {
		this.url=url;
		this.timeIntervalApiCall=timeIntervalApiCall;
	}
	
	public void run() {
		while(true) {
			try {
				logger.info("=======================================================");
				logger.info("now is "+DateUtil.getDate());
				String jsonResponse=HttpUtil.getJsonReseponse(url);
				String xmlResponse = StaxonUtils.json2xml(jsonResponse);
				logger.info("Response has been converted : \n "+xmlResponse);
				Exportdata.getInstance().enrichData(xmlResponse, ClusterMetrics.class);
				Thread.sleep(timeIntervalApiCall);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}