package com.imooc.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.imooc.dto.MultiFileUploadForm;
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
	
	
	/**
	 * 添加文章，将markdown解析成html
	 */
	public Result<String> addParseHtml(MultiFileUploadForm multiFileUploadForm);
	
	
	/**
	 * 上传图片,返回url
	 */
	public Result<String> uploadPicture(MultipartFile picture,HttpServletRequest request);
}
