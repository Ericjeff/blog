package com.imooc.service;

import com.imooc.dto.Result;
import com.imooc.entity.Admin;
import com.imooc.entity.Article;

public interface AdminService {
	
	
	/**
	 * 处理登录
	 */
	public Result<String> dologin(Admin admin);
	
	/**
	 * 修改admin信息
	 */
	
	public Result<String> modify(Admin admin);
	
	/**
	 * 删除文章
	 */
	public Result<String> deleteByIdArticle(String id);
	
	
	/**
	 * 修改文章
	 */
	public Result<String> updateArticle(Article article);
	
	
	
	/**
	 * 增加文章
	 */
	
	public Result<String> addArticle(Article article);
}
