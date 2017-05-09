package com.ucas.prms.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ucas.prms.entity.Privilege;
import com.ucas.prms.entity.Role;
import com.ucas.prms.entity.User;

/**
 * @Description:初始化权限管理模块
 * @author:Chen Peng
 * @time:2017年5月8日 下午10:53:57
 */
@Component
public class Installer {

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public void install() {

		Session session=sessionFactory.getCurrentSession();
		
		// 保存超级管理员用户
		User user = new User();
		user.setName("超级管理员");
		user.setLoginName("admin");
		user.setPassword("admin");
		session.save(user);
		
		// 保存用户组
		Role role=new Role();
		role.setName("管理员");
		session.save(role);
		
		Role role1=new Role();
		role1.setName("注册用户");
		session.save(role1);
		
		Role role2=new Role();
		role2.setName("普通用户");
		session.save(role2);
	
		
		// 保存权限数据
		Privilege menu,menu1,menu2,menu3,menu4;
		
		menu = new Privilege("用户管理", "/user_list", null);
		menu1 = new Privilege("用户列表", "/user_list", menu);
		menu2 = new Privilege("用户删除", "/user_delete", menu);
		menu3 = new Privilege("用户添加", "/user_add", menu);
		menu4 = new Privilege("用户修改", "/user_edit", menu);
		
		session.save(menu);
		session.save(menu1);
		session.save(menu2);
		session.save(menu3);
		session.save(menu4);
		
		menu = new Privilege("新闻管理", "/article_list", null);
		menu1 = new Privilege("新闻列表", "/article_list", menu);
		menu2 = new Privilege("新闻删除", "/article_delete", menu);
		menu3 = new Privilege("新闻发布", "/article_add", menu);
		menu3 = new Privilege("新闻评论", "/article_reply", menu);
		
		
		session.save(menu);
		session.save(menu1);
		session.save(menu2);
		session.save(menu3);
		session.save(menu4);
	}
	
	
	@SuppressWarnings("resource")
	public static void main(String[] args){
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		Installer installer=(Installer) applicationContext.getBean("installer");
		installer.install();
	}
}
