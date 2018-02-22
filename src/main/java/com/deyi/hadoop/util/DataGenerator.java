package com.deyi.hadoop.util;

import java.util.ArrayList;
import java.util.List;

import com.deyi.hadoop.bean.ClusterMetrics;

public class DataGenerator {
	
	public static List<ClusterMetrics> createTestClusterMetricsData() {
		List<ClusterMetrics> tempList = new ArrayList<ClusterMetrics>();
		// create MyClusterMetrics
		ClusterMetrics clusterMetrics = new ClusterMetrics();
		ClusterMetrics clusterMetrics2 = new ClusterMetrics();
		clusterMetrics.setAppsSubmitted(206792);
		clusterMetrics.setAppsCompleted(206569);
		clusterMetrics.setAppsPending(0);
		clusterMetrics.setAppsRunning(2);
		clusterMetrics.setAppsFailed(1);
		clusterMetrics.setAppsKilled(220);
		clusterMetrics.setReservedMB(0);
		clusterMetrics.setAvailableMB(16560128);
		clusterMetrics.setAllocatedMB(28672);
		clusterMetrics.setReservedVirtualCores(0);
		clusterMetrics.setAvailableVirtualCores(16165);
		clusterMetrics.setAllocatedVirtualCores(35);
		clusterMetrics.setContainersAllocated(7);
		clusterMetrics.setContainersReserved(0);
		clusterMetrics.setContainersPending(0);
		clusterMetrics.setTotalMB(16588800);
		clusterMetrics.setTotalVirtualCores(16200);
		clusterMetrics.setTotalNodes(90);
		clusterMetrics.setLostNodes(0);
		clusterMetrics.setUnhealthyNodes(0);
		clusterMetrics.setDecommissionedNodes(0);
		clusterMetrics.setRebootedNodes(0);
		clusterMetrics.setActiveNodes(90);
		
		clusterMetrics2.setAppsSubmitted(206792);
		clusterMetrics2.setAppsCompleted(206569);
		clusterMetrics2.setAppsPending(0);
		clusterMetrics2.setAppsRunning(2);
		clusterMetrics2.setAppsFailed(1);
		clusterMetrics2.setAppsKilled(220);
		clusterMetrics2.setReservedMB(0);
		clusterMetrics2.setAvailableMB(16560128);
		clusterMetrics2.setAllocatedMB(28672);
		clusterMetrics2.setReservedVirtualCores(0);
		clusterMetrics2.setAvailableVirtualCores(16165);
		clusterMetrics2.setAllocatedVirtualCores(35);
		clusterMetrics2.setContainersAllocated(7);
		clusterMetrics2.setContainersReserved(0);
		clusterMetrics2.setContainersPending(0);
		clusterMetrics2.setTotalMB(16588800);
		clusterMetrics2.setTotalVirtualCores(16200);
		clusterMetrics2.setTotalNodes(90);
		clusterMetrics2.setLostNodes(0);
		clusterMetrics2.setUnhealthyNodes(0);
		clusterMetrics2.setDecommissionedNodes(0);
		clusterMetrics2.setRebootedNodes(0);
		clusterMetrics2.setActiveNodes(90);
		

		// add cars to list
		tempList.add(clusterMetrics);
		tempList.add(clusterMetrics2);
		return tempList;
	}
}