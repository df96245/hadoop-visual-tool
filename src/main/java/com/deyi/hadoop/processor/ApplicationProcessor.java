package com.deyi.hadoop.processor;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.deyi.hadoop.bean.Application;
import com.deyi.hadoop.bean.Applications;
import com.deyi.hadoop.contants.Constants;
import com.deyi.hadoop.util.DateUtil;
import com.deyi.hadoop.util.Exportdata;

public class ApplicationProcessor {
	private static ApplicationProcessor processor;
	// 能力平台任务
	private static String regEx_NLPT = "^\\d{12}\\@\\d{16}.*$";
	private static String regEx_HIVE = "^\\/app\\/newland\\/script\\/bin\\/.*$";
	private static String regEx_ETL_TRANS = "^streamHadoopTransform\\d{12}@\\d{16}$";
	private static String regEx_ETL_URL_RESET = "^hn_uri_reset\\d{12}@\\d{16}$";
	private static String regEx_NETLOG_COLLECT = "^FT_MID_XDR_COLLECT_.*$";
	private static String regEx_NETLOG_LOAD = "^ODS_LOAD_.*$";
	private static String regEx_MID_VGOP = "^ft_mid_vgop_.*$";
	private static String regEx_MID_4G = "^ft_mid_4G_.*$";
	private static String regEx_MID_USER_STAT = "^ft_mid_user_stat_.*$";
	private static String regEx_XDR = "^FT_MID_XDR.*$";
	private static String regEx_USER_LABEL = "^fact_user_label.*$";
	private static String regEx_QRY_NET_LOG = "^QRY_NET_LOG.*$";
	private static String regEx_NL_WIDE_POTENTIAL = "^nl_wide_potential.*$";
	private static String regEx_TM_GPRS_24H = "^TM_GPRS_24H.*$";
	
	public static ApplicationProcessor getInstance() {
		if (processor == null) {
			return new ApplicationProcessor();
		}
		return processor;
	}

	private ApplicationProcessor() {
		super();
	}

	public void processAppData(Applications applications) {
		List<Application> xmlApplicationList = applications.getApplications();
		for (Application application : xmlApplicationList) {
			appDataConvert(application);
			appTypeIndicate(application);
			Exportdata.myApplicationsList.add(application);
		}
	}

	/**
	 * convert data in here if needed .
	 */
	private void appDataConvert(Application application) {
		application.setStartedTime(DateUtil.getDate(application.getStartedTime()));
		application.setFinishedTime(DateUtil.getDate(application.getFinishedTime()));
		application.setElapsedTime(Long.valueOf(application.getElapsedTime()) / 1000 + "");
	}

	/**
	 * indicate application type here , eg. 平台任务， hive脚本任务，Mhive 查询任务, 清洗转换任务...
	 */
	private void appTypeIndicate(Application application) {
		Pattern pattern_NLPT = Pattern.compile(regEx_NLPT);
		Pattern pattern_HIVE = Pattern.compile(regEx_HIVE);
		Pattern pattern_ETL_TRANS = Pattern.compile(regEx_ETL_TRANS);
		Pattern pattern_ETL_URL_RESET = Pattern.compile(regEx_ETL_URL_RESET);
		Pattern pattern_NETLOG_LOAD = Pattern.compile(regEx_NETLOG_LOAD);
		Pattern pattern_NETLOG_COLLECT = Pattern.compile(regEx_NETLOG_COLLECT);
		Pattern pattern_MID_VGOP = Pattern.compile(regEx_MID_VGOP);
		Pattern pattern_MID_4G = Pattern.compile(regEx_MID_4G);
		Pattern pattern_MID_USER_STAT = Pattern.compile(regEx_MID_USER_STAT);
		
		Pattern pattern_XDR = Pattern.compile(regEx_XDR);
		Pattern pattern_USER_LABLE = Pattern.compile(regEx_USER_LABEL);
		Pattern pattern_QRY_NET_LOG = Pattern.compile(regEx_QRY_NET_LOG);
		Pattern pattern_NL_WIDE_POTENTIAL = Pattern.compile(regEx_NL_WIDE_POTENTIAL);
		Pattern pattern_TM_GPRS_24H = Pattern.compile(regEx_TM_GPRS_24H);
		
		
		
		
		
		String appName = application.getName().trim();
		String lowerCaseAppName=appName.toLowerCase();
		String user=application.getUser();
		String queue=application.getQueue();
		if (pattern_HIVE.matcher(appName).matches()) {
			application.setAppType(Constants.HIVE_JOB);
		}
		if (pattern_NLPT.matcher(appName).matches()) {
			application.setAppType(Constants.NLPT_JOB);
		}
		if (pattern_ETL_TRANS.matcher(appName).matches()) {
			application.setAppType(Constants.ETL_TRANSFORM_JOB);
		}
		if (pattern_ETL_URL_RESET.matcher(appName).matches()) {
			application.setAppType(Constants.ETL_URL_REST_JOB);
		}
		if (pattern_NETLOG_LOAD.matcher(appName).matches()) {
			application.setAppType(Constants.NETLOG_LOAD_JOB);
		}
		if (pattern_NETLOG_COLLECT.matcher(appName).matches()) {
			application.setAppType(Constants.NETLOG_COLLECT_JOB);
		}
		if (pattern_MID_VGOP.matcher(appName).matches()) {
			application.setAppType(Constants.MID_VGOP_JOB);
			application.setPersonInCharge("陈业仁");
		}
		if (pattern_MID_4G.matcher(appName).matches()) {
			application.setAppType(Constants.MID_4G_JOB);
		}
		if (pattern_MID_USER_STAT.matcher(appName).matches()) {
			application.setAppType(Constants.MID_USER_STAT_JOB);
		}
		
		if (pattern_XDR.matcher(appName).matches()) {
			application.setAppType(Constants.XDR_JOB);
		}
		if (pattern_USER_LABLE.matcher(appName).matches()) {
			application.setAppType(Constants.USER_LABEL_JOB);
		}
		if (pattern_QRY_NET_LOG.matcher(appName).matches()) {
			application.setAppType(Constants.QRY_NET_LOG_JOB);
		}
		
		if (pattern_NL_WIDE_POTENTIAL.matcher(appName).matches()) {
			application.setAppType(Constants.NL_WIDE_POTENTIAL_JOB);
		}
		
		if (pattern_TM_GPRS_24H.matcher(appName).matches()) {
			application.setAppType(Constants.TM_GPRS_24H_JOB);
		}
		
		if (lowerCaseAppName.contains("select")||lowerCaseAppName.contains("insert")||lowerCaseAppName.contains("create")&&queue.contains("dev_4")) {
			application.setAppType(Constants.MHIVE_JOB);
		}
		if (user.trim().equalsIgnoreCase("bi")) {
			application.setAppType(Constants.BI_JOB);
		}
		if (user.trim().equalsIgnoreCase("spark")) {
			application.setAppType(Constants.SPARK_JOB);
		}
//		application.setAppType(Constants.UNDEFINED_JOB);
	}
}
