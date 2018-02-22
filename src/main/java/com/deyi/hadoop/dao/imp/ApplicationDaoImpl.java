package com.deyi.hadoop.dao.imp;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.deyi.hadoop.bean.Application;
import com.deyi.hadoop.dao.ApplicationDao;
@Repository
public class ApplicationDaoImpl extends BaseDaoImpl<Application> implements ApplicationDao {

	@Override
	public List<Application> getAllApps() {
		Criteria criteria=getSession().createCriteria(Application.class);
		List<Application> list =criteria.list();
		return list;
	}

	@Override
	//id=:appId  后面的appId是别名，与下面的query.setString 中的"appId" 要一致，后面的appId则是传入的参数的值。
	public Application getAppById(String appId) {
		String hql = "FROM Application where appId=:appId ";
		Application application= (Application) getSession().createQuery(hql).setParameter("appId", appId).uniqueResult();
		return application;
	}

	@Override
	public Integer getAppsNumOfQueue(String queueName) {
		List<Application> list=getAppsByQueue(queueName);
		return list.size();
	}

	@Override
	public List<Application> getAppsByQueue(String queueName) {
		Criteria criteria=getSession().createCriteria(Application.class);
		String queueLike="%"+queueName+"%";
		List<Application> list=criteria.add(Restrictions.like("queue", queueLike)).list();
		return list;
	}

}
