package com.deyi.hadoop.dao.imp;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import com.deyi.hadoop.bean.ClusterMetrics;
import com.deyi.hadoop.dao.ClusterMetricDaoTest;

@Repository
public class ClusterMetricDaoImpl extends BaseDaoImpl<ClusterMetrics> implements ClusterMetricDaoTest {

	@Override
	public List<ClusterMetrics> listAllClusterMetrics() {
		Criteria criteria = getSession().createCriteria(ClusterMetrics.class);
		List<ClusterMetrics> list = criteria.list();
		return list;
	}

}
