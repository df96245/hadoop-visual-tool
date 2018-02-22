package com.deyi.hadoop.bean;

public class ApplicationNumOfQueue extends Application {
	private Integer  appNum;
	private String queueName;
	public Integer getAppNum() {
		return appNum;
	}
	public void setAppNum(Integer appNum) {
		this.appNum = appNum;
	}
	public String getQueueName() {
		return queueName;
	}
	public void setQueueName(String queueName) {
		this.queueName = queueName;
	}
	public ApplicationNumOfQueue(String queueName,Integer appNum) {
		super();
		this.queueName = queueName;
		this.appNum = appNum;
	}
	
	
}
