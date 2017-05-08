package com.ucas.prms.dao;

import java.util.List;

/**
 * @Description:The templet of dao class to support basic operations.
 * @author:Chen Peng
 * @time:2017年5月7日 下午7:19:48
 */
public interface BaseDao<T> {

	/**
	 * save entity
	 * @param entity
	 */
	void save(T entity);
	
	
	/**
	 * delete entity
	 * @param entity
	 */
	void delete(Long id);
	
	/**
	 * update entity
	 * @param entity
	 */
	void update(T entity);
	
	/**
	 * get entity by its id
	 * @param id
	 * @return
	 */
	T getById(Long id); 
	
	
	/**
	 * get entities by its ids
	 * @param ids
	 * @return
	 */
	List<T> getByIds(Long[] ids);
	
	/**
	 * get all entities
	 * @return
	 */
	List<T> findAll();
	
	
}
