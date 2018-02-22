package com.deyi.hadoop.dao;

import java.util.List;

import com.deyi.hadoop.bean.Application;

public interface ApplicationDao extends BaseDao<Application> {
	List<Application> getAllApps();
	
	List<Application> getAppsByQueue(String queueName);
	
	Integer getAppsNumOfQueue(String queueName);
	
	Application getAppById(String appId);
}
