package com.ucas.prms.server.test;

import org.hibernate.SessionFactory;
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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@Transactional(transactionManager="transactionManager")
@Rollback(false)
@TestExecutionListeners(listeners={TransactionalTestExecutionListener.class})
public class DBTest extends AbstractJUnit4SpringContextTests{

	@Autowired
	private SessionFactory sessionFactory;

	@Test
	public void testConnect(){
		System.out.println(sessionFactory);
	}

}
