package com.deyi.hadoop.service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.deyi.hadoop.bean.Application;
import com.deyi.hadoop.bean.ApplicationNumOfQueue;
import com.deyi.hadoop.bean.Applications;
import com.deyi.hadoop.dao.ApplicationDao;
import com.deyi.hadoop.util.XMLUtil;

@Service
public class ApplicationService{
	@Autowired
	private ApplicationDao dao;
	public static CopyOnWriteArrayList<ApplicationNumOfQueue> appNumOfQueueList= new CopyOnWriteArrayList<ApplicationNumOfQueue>();
	
	public Application getApplicationById(String appId){
		return dao.getAppById(appId);
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
