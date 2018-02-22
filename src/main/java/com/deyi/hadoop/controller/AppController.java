package com.deyi.hadoop.controller;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.deyi.hadoop.bean.Application;
import com.deyi.hadoop.bean.ApplicationNumOfQueue;
import com.deyi.hadoop.server.ApplicationsApi;
import com.deyi.hadoop.service.ApplicationService;
import com.deyi.hadoop.util.RandomUtil;

import net.sf.json.JSONArray;

@Controller
@RequestMapping("/apps")
public class AppController {
	@Autowired
	private ApplicationService service;

	@RequestMapping(value = "/gen/xls", method = RequestMethod.GET)
	public String genAppsXls() {
		ApplicationsApi api = new ApplicationsApi();
		api.genXls();
		return "success";
	}

	@RequestMapping(value = "/numofqueue", method = RequestMethod.GET)
	public String numofqueue(Map<String, Object> model) {
		JSONArray json = JSONArray.fromObject(ApplicationService.appNumOfQueueList);
		model.put("jsonContext", json);
		return "/apps/numofqueue";
	}
	
	@RequestMapping(value = "/queueList", method = RequestMethod.GET)
	public String numofqueue(Map<String, Object> model, @RequestParam (value="queue",required=true) String queueName) {
//		JSONArray json = JSONArray.fromObject(service.listAppOfQueue(queueName));
//		model.put("jsonContext", json);
		model.put("list", service.listAppOfQueue(queueName));
		return "/apps/app-all";
	}

	@RequestMapping(value = "/numofqueue/refresh", method = RequestMethod.GET)
	public String numofqueueRefresh(Map<String, Object> model) {
		ApplicationService.appNumOfQueueList.clear();
		ApplicationService.appNumOfQueueList.add(new ApplicationNumOfQueue("dev_4", RandomUtil.genRandomRangeInteger()));
		ApplicationService.appNumOfQueueList.add(new ApplicationNumOfQueue("dev_10", RandomUtil.genRandomRangeInteger()));
		ApplicationService.appNumOfQueueList.add(new ApplicationNumOfQueue("dev_13", RandomUtil.genRandomRangeInteger()));
		ApplicationService.appNumOfQueueList.add(new ApplicationNumOfQueue("dev_16", RandomUtil.genRandomRangeInteger()));
		return "redirect:/apps/numofqueue";
	}
	
	//http://localhost:8080/springmvc/apps/getApp?id=application_1511171902313_341302
	@RequestMapping(value="/getApp", method = RequestMethod.GET)
	public String getAppById(Map<String, Object> model,@RequestParam (value="id",required=true) String appId) {
		Application application=service.getApplicationById(appId);
		model.put("app", application);
		return "/apps/app-detail";
	}
	
	@RequestMapping(value="/datatable", method = RequestMethod.GET)
	public String getAppById() {
		return "/apps/datatable";
	}

}
