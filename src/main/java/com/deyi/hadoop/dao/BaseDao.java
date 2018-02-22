package com.deyi.hadoop.dao;

public interface BaseDao<T> {
	void add(T t);
	
	void delete(T t);
	
	void update(T app);
	
	T findById(Integer id);
	
}
