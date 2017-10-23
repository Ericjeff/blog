package com.imooc.service;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.imooc.dto.Result;
import com.imooc.entity.Admin;
import com.imooc.entity.Article;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({	"classpath:config/spring-dao.xml",
	"classpath:config/spring-service.xml"})
public class TestAdmin {

	@Autowired
	private AdminService adminService;
	
	@Test
	public void LoginAdmin(){
		Admin admin = new Admin(1,"Tom","中国");
		Result<String> re = adminService.dologin(admin);
		System.out.println("info:"+re.getInfo());
	}
	
	@Test
	public void modifyAdmin(){
		Admin admin = new Admin(1,"Jim","中国+1");
		Result<String> re = adminService.modify(admin);
		System.out.println("info:"+re.getInfo());
	}
	
	@Test
	public void delete(){
		
		Result<String> re = adminService.deleteByIdArticle("2");
		System.out.println("info:"+re.getInfo());
	}
	
	@Test 
	public void add(){
		Article article = new Article(5,"win7中装ubuntu16.04",new Date(),20,"win7中装ubuntu16.04",
				"content","tag",23.0,23,"other");
		
		Result<String> re = adminService.addArticle(article);
		System.out.println("info:"+re.getInfo());
	}
	
	@Test
	public void modify(){
		Article article = new Article(8,"win7中装ubuntu16.04",new Date(),20,"win7中装ubuntu16.04",
				"content","tag",23.0,23,"other");
		
		Result<String> re = adminService.updateArticle(article);
		System.out.println("info:"+re.getInfo());
	}
}
