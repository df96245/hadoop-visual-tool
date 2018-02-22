package com.deyi.hadoop.bean;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.annotation.PostConstruct;
import javax.xml.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.deyi.hadoop.service.ApplicationService;

@XmlRootElement(name = "apps")
@Component
//用于延迟加载避免在启动时间耗时过多
@Lazy
public class Applications {
	
	@Autowired
	private ApplicationService service;

	private List<Application> applications;

	@XmlElement(name = "app")
	public List<Application> getApplications() {
		return applications;
	}

	public void setApplications(List<Application> applications) {
		this.applications = applications;
	}

	@Override
	public String toString() {
		return "MyApplications [applications=" + applications + "]";
	}

	@PostConstruct
	public void initMethod() {
		service.countAppOfQueue();
	}
}
