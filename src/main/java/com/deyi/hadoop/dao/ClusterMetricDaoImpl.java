package com.deyi.hadoop.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.deyi.hadoop.bean.ClusterMetrics;

@Repository
public class ClusterMetricDaoImpl extends BaseDaoImpl implements ClusterMetricDao {

	@Override
	public List<ClusterMetrics> listAllClusterMetrics() {
		Criteria criteria = getSession().createCriteria(ClusterMetrics.class);
		List<ClusterMetrics> list = criteria.list();
		return list;
	}

}
