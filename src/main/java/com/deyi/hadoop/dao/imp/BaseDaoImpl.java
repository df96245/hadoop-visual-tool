package com.deyi.hadoop.dao.imp;

import java.lang.reflect.ParameterizedType;  
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.deyi.hadoop.dao.BaseDao;
@Repository("baseDao")
@SuppressWarnings("all")
public class BaseDaoImpl<T> implements BaseDao<T> {
	private String hql;
	 private Class<T> clz;
	
	private Class<T> getClz() {
        if (clz == null) {
            clz = ((Class<T>)(((ParameterizedType) (this.getClass().getGenericSuperclass())).getActualTypeArguments()[0]));
        }
        return clz;
    }
	

	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void add(T t) {
		getSession().save(t);
	}

	@Override
	public void delete(T t) {
		getSession().delete(t);
	}

	@Override
	public void update(T t) {
		getSession().update(t);
	}

	@Override
	public T findById(Integer id) {
		return (T) getSession().get(getClz(), id);
	}
	
	public T findById(String id) {
		return (T) getSession().get(getClz(), id);
	}
}
