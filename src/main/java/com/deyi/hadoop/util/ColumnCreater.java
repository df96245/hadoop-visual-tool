package com.deyi.hadoop.util;

import com.deyi.hadoop.bean.BeanColumn;
import com.deyi.hadoop.contants.Constants.FormatType;

public class ColumnCreater {
	public static BeanColumn[] createClusterMetricsColumnArray() {
		BeanColumn[] columns = new BeanColumn[] {
				new BeanColumn("callApiTime", "callApiTime", FormatType.TEXT),
				new BeanColumn("appsSubmitted", "appsSubmitted", FormatType.INTEGER),
				new BeanColumn("appsCompleted", "appsCompleted", FormatType.INTEGER),
				new BeanColumn("appsPending", "appsPending", FormatType.INTEGER),
				new BeanColumn("appsRunning", "appsRunning", FormatType.INTEGER),
				new BeanColumn("appsFailed", "appsFailed", FormatType.INTEGER),
				new BeanColumn("appsKilled", "appsKilled", FormatType.INTEGER),
				new BeanColumn("reservedMB", "reservedMB", FormatType.INTEGER),
				new BeanColumn("availableMB", "availableMB", FormatType.INTEGER),
				new BeanColumn("allocatedMB", "allocatedMB", FormatType.INTEGER),
				new BeanColumn("reservedVirtualCores", "reservedVirtualCores", FormatType.INTEGER),
				new BeanColumn("availableVirtualCores", "availableVirtualCores", FormatType.INTEGER),
				new BeanColumn("allocatedVirtualCores", "allocatedVirtualCores", FormatType.INTEGER),
				new BeanColumn("containersAllocated", "containersAllocated", FormatType.INTEGER),
				new BeanColumn("containersReserved", "containersReserved", FormatType.INTEGER),
				new BeanColumn("containersPending", "containersPending", FormatType.INTEGER),
				new BeanColumn("totalMB", "totalMB", FormatType.INTEGER),
				new BeanColumn("totalVirtualCores", "totalVirtualCores", FormatType.INTEGER),
				new BeanColumn("totalNodes", "totalNodes", FormatType.INTEGER),
				new BeanColumn("lostNodes", "lostNodes", FormatType.INTEGER),
				new BeanColumn("unhealthyNodes", "unhealthyNodes", FormatType.INTEGER),
				new BeanColumn("decommissionedNodes", "decommissionedNodes", FormatType.INTEGER),
				new BeanColumn("rebootedNodes", "rebootedNodes", FormatType.INTEGER),
				new BeanColumn("activeNodes", "activeNodes", FormatType.INTEGER) 
				};
		
		return columns;
	}
	
	public static BeanColumn[] createApplicationsColumnArray() {
		BeanColumn[] columns = new BeanColumn[] {
				new BeanColumn("appType", "appType", FormatType.TEXT),
				new BeanColumn("personInCharge", "负责人", FormatType.TEXT),
				new BeanColumn("id", "id", FormatType.TEXT),
				new BeanColumn("user", "user", FormatType.TEXT),
				new BeanColumn("name", "name", FormatType.TEXT),
				new BeanColumn("queue", "queue", FormatType.TEXT),
				new BeanColumn("state", "state", FormatType.TEXT),
				new BeanColumn("finalStatus", "finalStatus", FormatType.TEXT),
				new BeanColumn("progress", "progress", FormatType.INTEGER),
				new BeanColumn("trackingUI", "trackingUI", FormatType.TEXT),
				new BeanColumn("trackingUrl", "trackingUrl", FormatType.TEXT),
				new BeanColumn("diagnostics", "diagnostics", FormatType.TEXT),
				new BeanColumn("clusterId", "clusterId", FormatType.TEXT),
				new BeanColumn("applicationType", "applicationType", FormatType.TEXT),
				new BeanColumn("applicationTags", "applicationTags", FormatType.TEXT),
				new BeanColumn("priority", "priority", FormatType.INTEGER),
				new BeanColumn("startedTime", "startedTime", FormatType.TEXT),
				new BeanColumn("finishedTime", "finishedTime", FormatType.TEXT),
				new BeanColumn("elapsedTime", "elapsedTime（秒）", FormatType.TEXT),
				new BeanColumn("amContainerLogs", "amContainerLogs", FormatType.TEXT),
				new BeanColumn("amHostHttpAddress", "amHostHttpAddress", FormatType.TEXT),
				new BeanColumn("allocatedMB", "allocatedMB", FormatType.INTEGER),
				new BeanColumn("allocatedVCores", "allocatedVCores", FormatType.INTEGER),
				new BeanColumn("runningContainers", "runningContainers", FormatType.INTEGER),
				new BeanColumn("memorySeconds", "memorySeconds", FormatType.INTEGER), 
				new BeanColumn("vcoreSeconds", "vcoreSeconds", FormatType.INTEGER),
				new BeanColumn("preemptedResourceMB", "preemptedResourceMB", FormatType.INTEGER),
				new BeanColumn("preemptedResourceVCores", "preemptedResourceVCores", FormatType.INTEGER),
				new BeanColumn("numNonAMContainerPreempted", "numNonAMContainerPreempted", FormatType.INTEGER),
				new BeanColumn("numAMContainerPreempted", "numAMContainerPreempted", FormatType.INTEGER)
				};
		
		return columns;
	}

}
