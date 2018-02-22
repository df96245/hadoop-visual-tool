package com.deyi.hadoop.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.deyi.hadoop.bean.ClusterMetrics;
import com.deyi.hadoop.service.ApplicationService;
import com.deyi.hadoop.service.ClusterMetricsService;
import com.deyi.hadoop.util.DateUtil;

import net.sf.json.JSONArray;

@Controller
@RequestMapping("/cluster")
public class ClusterMetricController {
	
	@Autowired
	private ClusterMetricsService service;
	
	@RequestMapping(value="/metrics",method=RequestMethod.GET)
	public String metric(Map<String, Object> model) {
		service.genClusterMetricsTestData();
		JSONArray json = JSONArray.fromObject(ClusterMetricsService.appNumOfQueueList);
		model.put("jsonContext", json);
		return "/cluster/metrics";
		
	}
	
	@RequestMapping(value="/all",method=RequestMethod.GET)
	public String listAll(Map<String, Object> model) {
		List<ClusterMetrics> list=service.getAllClusterMetrics();
		JSONArray json = JSONArray.fromObject(list);
		model.put("jsonContext", json);
		return "/cluster/metrics";
		
	}
}
