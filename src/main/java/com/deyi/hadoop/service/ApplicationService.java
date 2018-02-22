package com.deyi.hadoop.service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deyi.hadoop.bean.Application;
import com.deyi.hadoop.bean.ApplicationNumOfQueue;
import com.deyi.hadoop.controller.AppController;
import com.deyi.hadoop.dao.ApplicationDao;
import com.mchange.v2.lang.StringUtils;

@Service
public class ApplicationService{
	private Logger logger= LoggerFactory.getLogger(ApplicationService.class);
	
	@Autowired
	private ApplicationDao dao;
	public static CopyOnWriteArrayList<ApplicationNumOfQueue> appNumOfQueueList= new CopyOnWriteArrayList<ApplicationNumOfQueue>();
	
	public void saveAppRecord2DB(Application app) {
		dao.add(app);
	}
	
	public void rmAppRecordFromDB(Application app) {
		dao.delete(app);
	}
	
	public Application findApp(Integer id ,String appId) {
		Application application=null;
		if (id!=null) {
			logger.info("Going to find application by id");
			application=dao.findById(id);
		}else if (StringUtils.nonWhitespaceString(appId)) {
			logger.info("Going to find application by app id");
			application=dao.getAppById(appId);
		}
		return application;
	}
	
	public void refAppInfo(Application app) {
		dao.update(app);
	}
	
	public void countAppOfQueue() {
		Integer jobNumOfDev4=dao.getAppsNumOfQueue("dev_4");
		Integer jobNumOfDev10=dao.getAppsNumOfQueue("dev_10");
		Integer jobNumOfDev13=dao.getAppsNumOfQueue("dev_13");
		Integer jobNumOfDev16=dao.getAppsNumOfQueue("dev_16");
		
		appNumOfQueueList.add(new ApplicationNumOfQueue("dev_4",jobNumOfDev4));
		appNumOfQueueList.add(new ApplicationNumOfQueue("dev_10",jobNumOfDev10));
		appNumOfQueueList.add(new ApplicationNumOfQueue("dev_13",jobNumOfDev13));
		appNumOfQueueList.add(new ApplicationNumOfQueue("dev_16",jobNumOfDev16));
		
	}
	
	public List<Application> listAppOfQueue(String queueName){
		return dao.getAppsByQueue(queueName);
	}
	
}
