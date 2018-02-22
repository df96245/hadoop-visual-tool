package com.deyi.hadoop.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.deyi.hadoop.bean.Applications;
import com.deyi.hadoop.processor.ApplicationProcessor;
import com.deyi.hadoop.thread.ExportApplicationsThread;
import com.deyi.hadoop.util.Exportdata;
import com.deyi.hadoop.util.XMLUtil;

public class ApplicationsApi {
	private static Logger logger = LoggerFactory.getLogger(ApplicationsApi.class);

	public void genXls() {
		logger.info("=====================ready to run application server!=====================");
		String filePath = "F:\\tomcat\\webapps\\all_applications_on_yarn_2018-01-24.xml";
		Applications applications = (Applications) XMLUtil.convertXmlFileToObject(Applications.class, filePath);

		ApplicationProcessor processor = ApplicationProcessor.getInstance();
		processor.processAppData(applications);

		Exportdata.myApplicationsList = applications.getApplications();
		new Thread(new ExportApplicationsThread()).start();
	}
	
}
