package com.deyi.hadoop.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.deyi.hadoop.bean.Application;
import com.deyi.hadoop.bean.Applications;
import com.deyi.hadoop.bean.ClusterMetrics;


public class Exportdata {
	private Logger logger=LoggerFactory.getLogger(DateUtil.class);
	public static List<ClusterMetrics> myClusterMetricsdataList = new ArrayList<ClusterMetrics>();
	public static List<Application> myApplicationsList = new ArrayList<Application>();
	private static Exportdata exportdata;
	
	private Exportdata() {
		
	}
	
	public static Exportdata getInstance() {
		if (exportdata==null) {
			return new Exportdata();
		}
		return exportdata;
	}
	
	public void exportClusterDataToXlxs() {
		String sheetName = genSheetName("Cluster_Metrics_");
		String excelFileName=genExcelFileName(sheetName);
		List<ClusterMetrics> data = DataGenerator.createTestClusterMetricsData();
		Bean2xlsx beanexcel = new Bean2xlsx();
		beanexcel.bean2xlsx(data, ColumnCreater.createClusterMetricsColumnArray(), excelFileName, sheetName);
	}
	
	public void enrichData(String beconvertedXmlContent , Class clazz) {
		if (beconvertedXmlContent.isEmpty()|| null==beconvertedXmlContent) {
			return ;
		}
		if (clazz.getName().contains("MyClusterMetrics")) {
			logger.info("received "+ clazz.getName()+", it will conver to object now . ");
			ClusterMetrics bean=(ClusterMetrics)XMLUtil.convertXmlStrToObject(clazz, beconvertedXmlContent);
			bean.setCallApiTime(DateUtil.getDate());
			myClusterMetricsdataList.add(bean);
		}else if (clazz.getName().contains("MyApplications")) {
			logger.info("received "+ clazz.getName()+", it will conver to object now . ");
			Applications bean=(Applications)XMLUtil.convertXmlStrToObject(clazz, beconvertedXmlContent);
			myApplicationsList=bean.getApplications();
		}else {
			logger.error("目前只支持MyclusterMetrics和Applications，其他目前还未支持");;
		}
	}
	
	//TODO wai fot test
	public void exportClusterDataToXlxs(List dataList) {
		String sheetName = genSheetName("Cluster_Metrics_");
		String excelFileName=genExcelFileName(sheetName);
		new Bean2xlsx().bean2xlsx(dataList, ColumnCreater.createClusterMetricsColumnArray(), excelFileName, sheetName);
	}
	public void exportApplicationDataToXlxs(List dataList) {
		String sheetName = genSheetName("Applications");
		String excelFileName=genExcelFileName(sheetName);
		new Bean2xlsx().bean2xlsx(dataList, ColumnCreater.createApplicationsColumnArray(), excelFileName, sheetName);
	}

	private String genSheetName(String sheetNamePrefix) {
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String dateFormated=simpleDateFormat.format(date);
//		String sheetNamePrefix="Cluster_Metrics_";
		String sheetNameSuffix=dateFormated;
		String sheetName=sheetNamePrefix+sheetNameSuffix;
		return sheetName;
	}
	
	private String genExcelFileName(String sheetName) {
		String excelFilePrefixPath=LoadPropertiesFileUtil.getProperty("export.file.path");
		String excelFileSuffixPath=".xlsx";
		String excelFileName=excelFilePrefixPath+sheetName+excelFileSuffixPath;
		return excelFileName;
	}

	
	public static void main(String[] args) {
		List<ClusterMetrics> dataList = new ArrayList<>();
		dataList=DataGenerator.createTestClusterMetricsData();
		new Exportdata().exportClusterDataToXlxs(dataList);
	}
	
}
