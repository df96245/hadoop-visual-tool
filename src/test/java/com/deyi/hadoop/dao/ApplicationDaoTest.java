package com.deyi.hadoop.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.deyi.hadoop.bean.Application;
import com.deyi.hadoop.service.ApplicationService;

@ContextConfiguration(locations = {"classpath:spring/dispatcher-servlet.xml","classpath:spring/applicationContext.xml"})
public class ApplicationDaoTest extends AbstractJUnit4SpringContextTests  {
	@Autowired
	private ApplicationService service;
	
	@Test
	public void testAddApplication() {
		Application app = new Application();
		app.setAppId("deyi-test");
		service.saveAppRecord2DB(app);
	}
	@Test
	public void findAppById() {
		Application application =service.findApp(10036, "");
		System.out.println("=================="+application);
	}
	
	@Test
	public void testRmApplication() {
		Application application =service.findApp(10035, "");
		service.rmAppRecordFromDB(application);
	}
	
	@Test
	public void testUpdateApplication() {
		Application application =service.findApp(10037, "");
		application.setAppId("deyi-test2");
		service.refAppInfo(application);
	}
}
