package com.ucas.prms.server.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import com.ucas.prms.entity.Privilege;
import com.ucas.prms.entity.Role;
import com.ucas.prms.entity.User;
import com.ucas.prms.service.PrivilegeService;
import com.ucas.prms.service.RoleService;
import com.ucas.prms.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@Transactional(transactionManager="transactionManager")
@Rollback(false)
@TestExecutionListeners(listeners={TransactionalTestExecutionListener.class})
public class ServiceTest extends AbstractJUnit4SpringContextTests {

	@Autowired
	private UserService userService; 
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private PrivilegeService privilegeService;
	
	@Test
	public void testSaveUser(){
		User user=new User();
		user.setName("Tom");
		user.setLoginName("Tom01");
		user.setPassword("beauty");
		userService.save(user);
	}
	
	@Test
	public void testLogin(){
		String loginName="Jimmy01";
		String password="love";
		User user=userService.findByLoginNameAndPassword(loginName, password);
		System.out.println(user.getName());
	}
	
	@Test
	public void testRoleSave(){
		Role role=new Role();
		role.setName("超级管理员");
		roleService.save(role);
	}
	
	@Test
	public void testRoleGet(){
		Role role = roleService.getById(1l);
		System.out.println(role.getName());
		for(User user:role.getUsers()){
			System.out.println(user.getName());
		}
		for(Privilege privilege:role.getPrivileges()){
			System.out.println(privilege.getName());
		}
	}
	
	@Test
	public void testPrivilegeSave(){
		Privilege privilege=new Privilege();
		privilege.setName("人员管理");
		privilegeService.save(privilege);
	}
}
