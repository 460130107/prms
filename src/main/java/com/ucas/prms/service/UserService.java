package com.ucas.prms.service;

import com.ucas.prms.dao.BaseDao;
import com.ucas.prms.entity.User;

public interface UserService extends BaseDao<User> {
	
	/**
	 * find user by loginName and password.
	 * @param loginName
	 * @param password
	 * @return
	 */
	User findByLoginNameAndPassword(String loginName,String password);
}
