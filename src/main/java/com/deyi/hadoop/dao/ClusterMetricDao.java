package com.deyi.hadoop.dao;

import java.util.List;

import com.deyi.hadoop.bean.ClusterMetrics;

public interface ClusterMetricDao extends BaseDao<ClusterMetrics> {
	List<ClusterMetrics> listAllClusterMetrics();
}
