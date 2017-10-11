package com.imooc.service;

import java.util.List;

import com.imooc.dto.Result;
import com.imooc.entity.Article;

public interface ArticleService {
	
	
	/**
	 * 获取默认查询
	 * 
	 */
	public Result<List<Article>> queryDefault(String sortName);
	
	
	
	/**
	 * 通过分类查询文章
	 */
	
	public Result<List<Article>> queryByClassification(String className,String sortName,String nubmer);
	
	
	
	/**
	 * 
	 * 获取详情页
	 */
	public Result<Article> queryByIdArticle(String id);
	
	
	
	/**
	 * 更新评分分数
	 */
	public Result<String> updateGraded(String id,String grade);
}
