package com.imooc.dao;

import java.util.Date;
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
	
	
	@Test
	public void TestdeleteById(){
		System.out.println(artDao.deleteById(4));
	}
	
	@Test
	public void TestUpdate(){
		Article article = new Article(5,"win7中装ubuntu16.04",new Date(),20,"win7中装ubuntu16.04","content","tag",23.0,23,"other");
		
		System.out.println(artDao.modifyArticle(article));
	}
	
	@Test
	public void Testinsert(){
		Article article = new Article(5,"win7中装ubuntu16.04",new Date(),20,"win7中装ubuntu16.04",
				"content","tag",23.0,23,"other");
		System.out.println(artDao.addArticle(article));
	}
}
