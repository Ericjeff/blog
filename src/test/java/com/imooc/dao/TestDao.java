package com.imooc.dao;

import java.util.List;
import org.junit.Test;
import org.apache.log4j.Logger;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.imooc.entity.Article;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:config/spring-dao.xml")
public class TestDao {
	
	@Autowired
	private ArticleDao artDao;
	private static final Logger log = Logger.getLogger(Test.class);
	
	@Test
	public void testQueryDefault(){
		List<Article> lists = artDao.queryDefaultByGraded();//artDao.queryDefaultByDate();
		for(Article art:lists){
			//System.out.println(art.getId());
			log.info(art.getId());
		}
	}
	
	@Test
	public void testClassification(){
		
		List<Article> lists = artDao.queryClassificationByGraded("网站制作",10);
		
		for(Article art:lists){
			System.out.println(art.getId());
		}
	}
	
	
	@Test
	public void testId(){
		
		Article art = artDao.queryByArticle(3);
		
			System.out.println(art.getId());
	}
	
	@Test
	public void testupdateByIdGraded(){
		int i = artDao.updateByIdGraded(2, 20);
		System.out.println(i);
	}
	
	@Test
	public void testRequest(){
		int i = artDao.updateByIdVisit(2);
		System.out.println(i);
	}
	
	@Test
	public void testgetCount(){
		log.info(artDao.getCount("网站制作"));
	}
}
