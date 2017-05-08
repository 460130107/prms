package com.ucas.prms.service.impl;

import org.springframework.stereotype.Service;

import com.ucas.prms.dao.impl.BaseDaoImpl;
import com.ucas.prms.entity.User;
import com.ucas.prms.service.UserService;

@Service
public class UserServiceImpl extends BaseDaoImpl<User> implements UserService {

	@Override
	public User findByLoginNameAndPassword(String loginName, String password) {
		return (User) getSession().createQuery(//
				"FROM User u WHERE u.loginName=? AND u.password=?")//
				.setParameter(0, loginName)//
				.setParameter(1, password)//
				.uniqueResult();
	}
	

}
