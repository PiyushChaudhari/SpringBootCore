package com.core.application.base;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class AbstractHibernateDao<T extends Serializable> implements HibernateDao<T> {

	private Class<T> clazz;
	@Autowired
	public SessionFactory sessionFactory;

	protected final void setClazz(final Class<T> clazzToSet) {
		this.clazz = clazzToSet;
	}

	@Override
	public T get(String id) {

		return getSession().get(clazz, id);
	}

	@Override
	public T load(String id) {
		return getSession().load(clazz, id);
	}

	@Override
	public void persist(T entity) {
		getSession().persist(entity);
	}

	@Override
	public T save(T entity) {
		getSession().save(entity);
		return entity;
	}

	@Override
	public void saveOrUpdate(T entity) {
		getSession().saveOrUpdate(entity);
	}

	@Override
	public void update(T entity) {
		getSession().update(entity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T merge(T entity) {
		return (T) getSession().merge(entity);
	}

	@Override
	public void delete(T entity) {
		getSession().delete(entity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> list() {
		return getSession().createQuery("from " + clazz.getName()).list();
	}

	@Override
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

}
