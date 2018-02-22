package com.deyi.hadoop.dao;

import java.util.List;

import com.deyi.hadoop.bean.ClusterMetrics;

public interface ClusterMetricDao {
	List<ClusterMetrics> listAllClusterMetrics();
}
