package com.imooc.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.imooc.dto.MultiFileUploadForm;
import com.imooc.dto.Result;
import com.imooc.entity.Admin;
import com.imooc.entity.Article;
import com.imooc.enums.BlogEnum;
import com.imooc.service.AdminService;

@Controller
@RequestMapping("/admin")
public class ControllerAdmin {
	
	@Autowired
	private AdminService adminService;
	
	/**
	 * 登录
	 */
	@RequestMapping(value = "/login",
			method = RequestMethod.POST,
			produces = {"application/json;charset=UTF-8" })
	@ResponseBody
	public Result<String> dologin(@RequestBody Admin admin){
		
		return adminService.dologin(admin);
	}
	
	
	
	/**
	 * 修改admin
	 */
	@RequestMapping(value = "/updating",
			method = RequestMethod.POST,
			produces = {"application/json;charset=UTF-8" })
	@ResponseBody
	public Result<String> modifyAdmin(@RequestBody Admin admin){
		return adminService.modify(admin);
	}
	
	
	
	/**
	 * 删除文章
	 */
	@RequestMapping(value = "/article/deleting/{id}",
			method = RequestMethod.GET,
			produces = {"application/json;charset=UTF-8" })
	@ResponseBody
	public Result<String> deleteArticle(@PathVariable String id){
		
		return adminService.deleteByIdArticle(id);
	}
	
	
	
	/**
	 * 添加文章
	 */
	@RequestMapping(value = "/article/adding",
			method = RequestMethod.POST,
			produces = {"application/json;charset=UTF-8" })
	@ResponseBody
	public Result<String> addArticle(@RequestBody Article article){
		
		return adminService.addArticle(article);
	}
	
	
	
	/**
	 * 更新文章
	 */
	@RequestMapping(value = "/article/updating",
			method = RequestMethod.POST,
			produces = {"application/json;charset=UTF-8" })
	@ResponseBody
	public Result<String> updateArticle(@RequestBody Article article){
		
		return adminService.updateArticle(article);
	}
	
	
	
	/**
	 * 上传文章,将markdown解析成html
	 */
	@RequestMapping(value = "/uploading",
					method = RequestMethod.POST)
	@ResponseBody
	public Result<String> uploadFile(@ModelAttribute("multiFileUploadForm") MultiFileUploadForm multiFileUploadForm){
			//MultipartFile multiUploadFile, HttpServletRequest request) {
		
		return adminService.addParseHtml(multiFileUploadForm);
	}
	
	
	
	/**
	 *上传图片,获取url
	 */
	@RequestMapping(value="/picture",
					method = RequestMethod.POST)
	@ResponseBody
	public Result<String> uploadPicture(MultipartFile picture,HttpServletRequest request){
		
		return adminService.uploadPicture(picture,request);
	}
}
