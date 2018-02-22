package com.deyi.hadoop.thread;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.deyi.hadoop.bean.Application;
import com.deyi.hadoop.util.Exportdata;

public class ExportApplicationsThread implements Runnable {
	private Logger logger=LoggerFactory.getLogger(ExportApplicationsThread.class);

	public ExportApplicationsThread() {
	}

	@Override
	public void run() {
		List<Application> dataList = Exportdata.myApplicationsList;
		Exportdata.getInstance().exportApplicationDataToXlxs(dataList);
		logger.info("文件生成完成！");
	}

}
