package com.imooc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.imooc.dao.ArticleDao;
import com.imooc.dto.Result;
import com.imooc.entity.Article;
import com.imooc.enums.BlogEnum;
import com.imooc.exception.FailException;
import com.imooc.exception.NoDataException;
import com.imooc.service.ArticleService;

@Service
public class ArticleServiceImpl implements ArticleService {
	
	@Autowired
	private ArticleDao articleDao;
	
	private static final Logger log = Logger.getLogger(ArticleServiceImpl.class);
	
	@Override
	public Result<List<Article>> queryDefault(String sortName,String number) {
		
		//判断sortName是否为非法字符
		log.info("<-------queryDefault----------->判断sortName是否为非法字符");
		List<Article> list;
		if(number==null||number.equals(""))
			return new Result<List<Article>>(BlogEnum.FAIL,null);
		int number1;
		try{
			 number1 = Integer.parseInt(number)*10;
		}catch(Exception e){
			number1 = 10;
		}
		if(sortName.equals("date")){
			list = articleDao.queryDefaultByDate(number1);
		}else if(sortName.equals("graded"))
			list = articleDao.queryDefaultByGraded(number1);
		else
			list = articleDao.queryDefaultByDate(number1);
			
		try{
			for(Article art:list){
				art.setContent("");
			}
		}catch(FailException e){
			return new Result<List<Article>>(BlogEnum.FAIL,new ArrayList<Article>());
		}
		if(list.size()<=0)
			return new Result<List<Article>>(BlogEnum.NoData,list);
		return new Result<List<Article>>(BlogEnum.SUCCESS,list);
	}

	@Override
	public Result<List<Article>> queryByClassification(String className, String sortName, String nubmer) {
		
		//判断参数是否为非法字符
		log.info("<-------queryDefault----------->判断参数是否为非法字符");
		if(className == null||className.equals("")){
			className="网站制作";
		}
		if(sortName == null||sortName.equals("")){
			sortName="date";
		}
		int num;
		try{
			num = Integer.parseInt(nubmer);
			num = num>0?num:1;
		}catch(Exception e){
			log.info(e.getMessage());
			num = 1;
		}
		List<Article> list ;
		if(sortName.equals("graded"))
			list =  articleDao.queryClassificationByGraded(className, num*10);
		else if(sortName.equals("date"))
			list = articleDao.queryClassificationByGraded(className, num*10);
		else
			list = articleDao.queryClassificationByGraded(className, num*10);
		
		try{
			for(Article art:list){
				art.setContent("");
			}
		}catch(FailException e){
			return new Result<List<Article>>(BlogEnum.FAIL,new ArrayList<Article>());
		}
		
		if(list.size()<=0)
			return new Result<List<Article>>(BlogEnum.NoData,list);
		return new Result<List<Article>>(BlogEnum.SUCCESS,list);
	}

	
	
	
	@Override
	public Result<Article> queryByIdArticle(String id) {
		
		//判断参数是否为非法字符
		log.info("<-------queryByIdArticle----------->判断参数是否为非法字符");
		int num;
		try{
			num = Integer.parseInt(id);
			num = num>0?num:1;
		}catch(Exception e){
			log.info(e.getMessage());
			num = 1;
		}
		//更新访问人数
		articleDao.updateByIdVisit(num);
		Article art = articleDao.queryByArticle(num);
		if(art == null)
			return new Result<Article>(BlogEnum.NoData);
		return new Result<Article>(BlogEnum.SUCCESS,art);//;
	}

	
	
	
	@Override
	public Result<String> updateGraded(String id,String grade) {
		
		//判断参数是否为非法字符
		log.info("<-------queryByIdArticle----------->判断参数是否为非法字符");
		int num;
		try{
			num = Integer.parseInt(id);
			num = num>0?num:1;
		}catch(Exception e){
			log.info(e.getMessage());
			num = 1;
		}
		double grades;
		try{
			grades = Integer.parseInt(grade);
			grades = grades>0?grades:0;
		}catch(Exception e){
			log.info(e.getMessage());
			grades = 0;
		}
		
		double gradess = articleDao.queryByArticle(num).getGraded();
		double result = ((grades+gradess)/2)%6;
		int i = articleDao.updateByIdGraded(num,result );
		
		if(i==0)
			return new Result<String>(BlogEnum.FAIL,"");
		return new Result<String>(BlogEnum.SUCCESS,result+"");
	}
	
}
