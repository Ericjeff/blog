package com.imooc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.imooc.entity.Article;

public interface ArticleDao{
	
	/**
	 * 默认查询
	 * 
	 */
	public List<Article> queryDefaultByDate();
	
	public List<Article> queryDefaultByGraded();
	
	/**
	 * 
	 * 分类查询
	 * 
	 */
	public List<Article> queryClassificationByDate(@Param("value")String value,@Param("number")int number);
	public List<Article> queryClassificationByGraded(@Param("value")String value,@Param("number")int number);
	
	
	
	/**
	 * 通过id查询一篇文章
	 * 
	 */
	public Article queryByArticle(@Param("id")int id);
	
	
	
	/**
	 * 更新评分
	 */
	
	public int  updateByIdGraded(@Param("id")int id,@Param("grade")double grade);
	
	
	
	/**
	 * 更新访问人数
	 */
	public int updateByIdVisit(@Param("id")int id);
	
	
	
	/**
	 * 获取某个分类的文章总数
	 */
	public int getCount(@Param("value")String value);
	
	
	
	/**
	 * 插入
	 * 
	 */
	public int addArticle(Article article);
	
	
	
	/**
	 * 删除
	 */
	public int deleteById(@Param("id")int id);
	
	
	
	/**
	 * 修改
	 */
	public int modifyArticle(Article article);
}