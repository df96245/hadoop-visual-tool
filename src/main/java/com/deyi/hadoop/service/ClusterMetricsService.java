package com.deyi.hadoop.service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deyi.hadoop.bean.ClusterMetrics;
import com.deyi.hadoop.dao.ClusterMetricDaoTest;
import com.deyi.hadoop.util.DateUtil;
import com.deyi.hadoop.util.RandomUtil;
import com.deyi.hadoop.util.XMLUtil;

@Service
public class ClusterMetricsService implements LoadData{
	public static CopyOnWriteArrayList<ClusterMetrics> appNumOfQueueList= new CopyOnWriteArrayList<ClusterMetrics>();
	
	@Autowired
	private ClusterMetricDaoTest dao;

	@Override
	public void LoadData(String filePath) {
		ClusterMetrics clusterMetrics = (ClusterMetrics) XMLUtil.convertXmlFileToObject(ClusterMetrics.class, filePath);
		clusterMetrics.setCallApiTime(DateUtil.getDate());
		clusterMetrics.setContainersPending(RandomUtil.genRandomRangeLong().intValue());
		appNumOfQueueList.add(clusterMetrics);
	}
	
	public void genClusterMetricsTestData() {
		appNumOfQueueList.clear();
		for (int i = 0; i < 5; i++) {
			String filePath="F:\\tomcat\\webapps\\cluster_metrics.xml";
			try {
				Thread.sleep(1000);
				LoadData(filePath);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public List<ClusterMetrics> getAllClusterMetrics(){
		return dao.listAllClusterMetrics();
	}
}
