package com.core.application.base;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;

public interface HibernateDao<T extends Serializable> {

	T get(final String id);

	T load(final String id);

	void persist(final T entity);

	T save(final T entity);

	void saveOrUpdate(final T entity);

	void update(final T entity);

	T merge(final T entity);

	void delete(final T entity);

	List<T> list();
	
	Session getSession();
}
