package com.ucas.prms.server.test;


import java.util.Date;

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

import com.ucas.prms.entity.Article;
import com.ucas.prms.entity.Privilege;
import com.ucas.prms.entity.Reply;
import com.ucas.prms.entity.Role;
import com.ucas.prms.entity.User;
import com.ucas.prms.service.ArticleService;
import com.ucas.prms.service.PrivilegeService;
import com.ucas.prms.service.ReplyService;
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
	
	@Autowired
	private ArticleService articleService;
	
	@Autowired
	private ReplyService replyService;
	
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
	
	@Test
	public void testArticleSave(){
		Article article=new Article();
		User author=userService.getById(1l);
		article.setTitle("中国科学院大学的历史");
		article.setContent("中国科学院大学成立于2012年。");
		article.setAuthor(author);
		article.setPostTime(new Date());
		articleService.save(article);
	}
	
	@Test
	public void testReplySave(){
		Reply reply=new Reply();
		User author = userService.getById(2l);
		reply.setContent("哇！这真是一所超棒的大学！");
		reply.setAuthor(author);
		reply.setArticle(articleService.getById(1l));
		reply.setPostTime(new Date());
		replyService.save(reply);
	}
}
