package com.deyi.hadoop.thread;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.deyi.hadoop.bean.ClusterMetrics;
import com.deyi.hadoop.util.DateUtil;
import com.deyi.hadoop.util.Exportdata;
import com.deyi.hadoop.util.LoadPropertiesFileUtil;

public class ExportDataThread implements Runnable{
	private Logger logger=LoggerFactory.getLogger(ExportDataThread.class);
	
	public ExportDataThread() {
	}

	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(Integer.valueOf(LoadPropertiesFileUtil.getProperty("export.data.time")));
				if (DateUtil.isNewDate()) {
					logger.info("begin export data to excel file . ");
					List<ClusterMetrics> dataList=Exportdata.myClusterMetricsdataList;
					Exportdata.getInstance().exportClusterDataToXlxs(dataList);
					dataList.clear();
					Thread.sleep(10000);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}
