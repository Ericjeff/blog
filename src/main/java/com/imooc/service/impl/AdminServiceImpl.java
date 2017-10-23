package com.imooc.service.impl;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imooc.dao.AdminDao;
import com.imooc.dao.ArticleDao;
import com.imooc.dto.Result;
import com.imooc.entity.Admin;
import com.imooc.entity.Article;
import com.imooc.enums.BlogEnum;
import com.imooc.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	private static final Logger log = Logger.getLogger(AdminServiceImpl.class);
	
	@Autowired
	private AdminDao adminDao;
	@Autowired
	private ArticleDao articleDao;
	
	@Override
	public Result<String> dologin(Admin admin) {
		// TODO Auto-generated method stub
		
		if(admin==null)
			return new Result<String>(BlogEnum.FAIL,"0");
		String name = admin.getUsername();
		String password = admin.getPassword();
		if(name==null||password==null)
			return new Result<String>(BlogEnum.ADMINERROR,"0");
		String checkpw = adminDao.queryByName(name);
		if(checkpw == null)
			return new Result<String>(BlogEnum.ADMINERROR,"0");
		if(checkpw.equals(password))
			return new Result<String>(BlogEnum.SUCCESS,"1");
		return new Result<String>(BlogEnum.ADMINERROR,"0");
	}
	
	@Override
	public Result<String> modify(Admin admin) {
		// TODO Auto-generated method stub
		
		if(admin==null)
			return new Result<String>(BlogEnum.FAIL,"0");
		
		String name = admin.getUsername();
		String password = admin.getPassword();
		if(name==null||password==null)
			return new Result<String>(BlogEnum.MFERROR,"0");
		int mId = adminDao.modify(admin);
		if(mId == 0)
			return new Result<String>(BlogEnum.MFERROR,"0");
		
		return  new Result<String>(BlogEnum.SUCCESS,"1");
	}
	
	
	
	@Override
	public Result<String> deleteByIdArticle(String id) {
		// TODO Auto-generated method stub
		log.info("----------start delete--------------------");
		if(id==null||id.equals(""))
			return new Result<String>(BlogEnum.IDERROR,"0");
		try{
			int aId = Integer.parseInt(id);
			log.info("id:"+aId);
			int dId = articleDao.deleteById(aId);
			log.info("dId:"+dId);
			if(dId==0){
				log.info("没有删除");
				return new Result<String>(BlogEnum.IDERROR,"0");
			}
		}catch(Exception e){
			log.error("error:"+e.getMessage());
			return new Result<String>(BlogEnum.IDERROR,"0");
		}
		return new Result<String>(BlogEnum.SUCCESS,"1");
	}

	@Override
	public Result<String> updateArticle(Article article) {
		// TODO Auto-generated method stub
		if(article ==null){
			return new Result<String>(BlogEnum.ARERROR,"0");
		}
		article.setDate(new Date());
		int mId = articleDao.modifyArticle(article);
		log.info("mId:"+mId);
		if(mId == 0)
			return new Result<String>(BlogEnum.ARERROR,"0");
		return new Result<String>(BlogEnum.SUCCESS,"1");
	}

	@Override
	public Result<String> addArticle(Article article) {
		// TODO Auto-generated method stub
		
		if(article ==null){
			return new Result<String>(BlogEnum.ARERROR,"0");
		}
		
		article.setGraded(3.0);
		article.setDate(new Date());
		article.setGradedCount(1);
		article.setVisitCount(1);
		log.info("content:"+article);
		
		int aId = articleDao.addArticle(article);
		if(aId == 0)
			return new Result<String>(BlogEnum.ARERROR,"0");
		return new Result<String>(BlogEnum.SUCCESS,"1");
	}	
}
