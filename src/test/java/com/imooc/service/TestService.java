package com.imooc.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.imooc.dto.Result;
import com.imooc.entity.Article;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({	"classpath:config/spring-dao.xml",
	"classpath:config/spring-service.xml"})
public class TestService {
	
	@Autowired
	private ArticleService articleService;
	private static final Logger log = Logger.getLogger(TestService.class);
	@Test
	public void testqueryDefault(){
		Result<List<Article>> result  = articleService.queryDefault("");
		/*for(Article art:result.getData()){
			log.info("id:"+art.getId());
		}*/
		log.info("=============:"+result.getData()+",,"+result.getInfo());
	}
	
	
	@Test
	public void testqueryByClassification(){
		Result<List<Article>> result  = articleService.queryByClassification("网站制作", "w", "-1");
		log.info("aaa:"+result.getInfo());
		for(Article art:result.getData()){
			log.info("graded:"+art.getGraded()+",,,,id:"+art.getId()+"   "+art.getClassification());
		}
	}
	
	@Test 
	public void testqueryByIdArticle(){
		Result<Article> result = articleService.queryByIdArticle("9");
		log.info("message:"+result.getData()+"resut:"+result.getInfo());
		//System.out.println("id:"+result.getData().getId());
	}
	
	@Test
	public void trestupdateGraded(){
		Result<String> result = articleService.updateGraded("3","123");
		log.info("结果:"+result.getInfo()+",,,:"+result.getData());
	}
}
