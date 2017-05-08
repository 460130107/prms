package com.ucas.prms.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.ucas.prms.dao.BaseDao;

@Transactional
@SuppressWarnings("unchecked")
public abstract class BaseDaoImpl<T> implements BaseDao<T> {

	private Logger logger = Logger.getLogger(this.getClass());
	
	@Resource
	private SessionFactory sessionFactory;
	private Class<T> clazz;
		
	public BaseDaoImpl() {
		// Get true class of T by reflect skill.
		ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass(); 
		this.clazz = (Class<T>) pt.getActualTypeArguments()[0]; 
		logger.info("clazz ---> " + clazz);
	}


	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public void save(T entity) {
		getSession().save(entity);
	}

	public void update(T entity) {
		getSession().update(entity);
	}

	public void delete(Long id) {
		Object obj = getById(id);
		if (obj != null) {
			getSession().delete(obj);
		}
	}

	public T getById(Long id) {
		if (id == null) {
			return null;
		} else {
			return (T) getSession().get(clazz, id);
		}
	}

	public List<T> getByIds(Long[] ids) {
		if (ids == null || ids.length == 0) {
			return Collections.EMPTY_LIST;
		} else {
			return getSession().createQuery(//
					"FROM " + clazz.getSimpleName() + " WHERE id IN (:ids)")//
					.setParameterList("ids", ids)//
					.list();
		}
	}

	public List<T> findAll() {
		return getSession().createQuery(//
				"FROM " + clazz.getSimpleName())//
				.list();
	}


}
