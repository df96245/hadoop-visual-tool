package com.deyi.hadoop.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="app")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name="application")
public class Application {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String appId;
	private String user;
	private String name;
	private String queue;
	private String state;
	private String finalStatus;
	private String progress;
	private String trackingUI;
	private String trackingUrl;
	private String diagnostics;
	private String clusterId;
	private String applicationType;
	private String applicationTags;
	private String priority;
	private String startedTime;
	private String finishedTime;
	private String elapsedTime;
	private String amContainerLogs;
	private String amHostHttpAddress;
	private String allocatedMB;
	private String allocatedVCores;
	private String runningContainers;
	private String memorySeconds;
	private String vcoreSeconds;
	private String preemptedResourceMB;
	private String preemptedResourceVCores;
	private String numNonAMContainerPreempted;
	private String numAMContainerPreempted;
	
	private String appType;
	private String personInCharge;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getQueue() {
		return queue;
	}
	public void setQueue(String queue) {
		this.queue = queue;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getFinalStatus() {
		return finalStatus;
	}
	public void setFinalStatus(String finalStatus) {
		this.finalStatus = finalStatus;
	}
	public String getProgress() {
		return progress;
	}
	public void setProgress(String progress) {
		this.progress = progress;
	}
	public String getTrackingUI() {
		return trackingUI;
	}
	public void setTrackingUI(String trackingUI) {
		this.trackingUI = trackingUI;
	}
	public String getTrackingUrl() {
		return trackingUrl;
	}
	public void setTrackingUrl(String trackingUrl) {
		this.trackingUrl = trackingUrl;
	}
	public String getDiagnostics() {
		return diagnostics;
	}
	public void setDiagnostics(String diagnostics) {
		this.diagnostics = diagnostics;
	}
	public String getClusterId() {
		return clusterId;
	}
	public void setClusterId(String clusterId) {
		this.clusterId = clusterId;
	}
	public String getApplicationType() {
		return applicationType;
	}
	public void setApplicationType(String applicationType) {
		this.applicationType = applicationType;
	}
	public String getApplicationTags() {
		return applicationTags;
	}
	public void setApplicationTags(String applicationTags) {
		this.applicationTags = applicationTags;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getAmContainerLogs() {
		return amContainerLogs;
	}
	public void setAmContainerLogs(String amContainerLogs) {
		this.amContainerLogs = amContainerLogs;
	}
	public String getAmHostHttpAddress() {
		return amHostHttpAddress;
	}
	public void setAmHostHttpAddress(String amHostHttpAddress) {
		this.amHostHttpAddress = amHostHttpAddress;
	}
	public String getAllocatedMB() {
		return allocatedMB;
	}
	public void setAllocatedMB(String allocatedMB) {
		this.allocatedMB = allocatedMB;
	}
	public String getAllocatedVCores() {
		return allocatedVCores;
	}
	public void setAllocatedVCores(String allocatedVCores) {
		this.allocatedVCores = allocatedVCores;
	}
	public String getRunningContainers() {
		return runningContainers;
	}
	public void setRunningContainers(String runningContainers) {
		this.runningContainers = runningContainers;
	}
	public String getMemorySeconds() {
		return memorySeconds;
	}
	public void setMemorySeconds(String memorySeconds) {
		this.memorySeconds = memorySeconds;
	}
	public String getVcoreSeconds() {
		return vcoreSeconds;
	}
	public void setVcoreSeconds(String vcoreSeconds) {
		this.vcoreSeconds = vcoreSeconds;
	}
	public String getPreemptedResourceMB() {
		return preemptedResourceMB;
	}
	public void setPreemptedResourceMB(String preemptedResourceMB) {
		this.preemptedResourceMB = preemptedResourceMB;
	}
	public String getPreemptedResourceVCores() {
		return preemptedResourceVCores;
	}
	public void setPreemptedResourceVCores(String preemptedResourceVCores) {
		this.preemptedResourceVCores = preemptedResourceVCores;
	}
	public String getNumNonAMContainerPreempted() {
		return numNonAMContainerPreempted;
	}
	public void setNumNonAMContainerPreempted(String numNonAMContainerPreempted) {
		this.numNonAMContainerPreempted = numNonAMContainerPreempted;
	}
	public String getNumAMContainerPreempted() {
		return numAMContainerPreempted;
	}
	public void setNumAMContainerPreempted(String numAMContainerPreempted) {
		this.numAMContainerPreempted = numAMContainerPreempted;
	}
	
	public String getStartedTime() {
		return startedTime;
	}
	public void setStartedTime(String startedTime) {
		this.startedTime = startedTime;
	}
	public String getFinishedTime() {
		return finishedTime;
	}
	public void setFinishedTime(String finishedTime) {
		this.finishedTime = finishedTime;
	}
	public String getElapsedTime() {
		return elapsedTime;
	}
	public void setElapsedTime(String elapsedTime) {
		this.elapsedTime = elapsedTime;
	}
	
	public String getAppType() {
		return appType;
	}
	public void setAppType(String appType) {
		this.appType = appType;
	}
	
	public String getPersonInCharge() {
		return personInCharge;
	}
	public void setPersonInCharge(String personInCharge) {
		this.personInCharge = personInCharge;
	}
	@Override
	public String toString() {
		return "Application [id=" + appId + ", user=" + user + ", name=" + name + ", queue=" + queue
				+ ", state=" + state + ", finalStatus=" + finalStatus + ", progress=" + progress + ", trackingUI="
				+ trackingUI + ", trackingUrl=" + trackingUrl + ", diagnostics=" + diagnostics + ", clusterId="
				+ clusterId + ", applicationType=" + applicationType + ", applicationTags=" + applicationTags
				+ ", priority=" + priority + ", startedTime=" + startedTime + ", finishedTime=" + finishedTime
				+ ", elapsedTime=" + elapsedTime + ", amContainerLogs=" + amContainerLogs + ", amHostHttpAddress="
				+ amHostHttpAddress + ", allocatedMB=" + allocatedMB + ", allocatedVCores=" + allocatedVCores
				+ ", runningContainers=" + runningContainers + ", memorySeconds=" + memorySeconds + ", vcoreSeconds="
				+ vcoreSeconds + ", preemptedResourceMB=" + preemptedResourceMB + ", preemptedResourceVCores="
				+ preemptedResourceVCores + ", numNonAMContainerPreempted=" + numNonAMContainerPreempted
				+ ", numAMContainerPreempted=" + numAMContainerPreempted + ", appType=" + appType + ", personInCharge="
				+ personInCharge + "]";
	}
	
	
}
