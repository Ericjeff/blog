package com.imooc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.imooc.dto.Result;
import com.imooc.entity.Admin;
import com.imooc.entity.Article;
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
}
