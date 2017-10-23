package com.imooc.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.imooc.entity.Admin;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:config/spring-dao.xml")
public class TestUserDao {

	@Autowired
	private AdminDao adminDao;
	
	@Test
	public void testquery(){
		System.out.println(adminDao.queryByName("Tom"));
	}
	
	@Test
	public void TestUpdate(){
		Admin admin = new Admin(1,"Jim","中国");
		System.out.println(adminDao.modify(admin));
	}
}
