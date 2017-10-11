package com.imooc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.imooc.dto.Result;
import com.imooc.entity.Article;
import com.imooc.service.ArticleService;

@Controller
@RequestMapping
public class ControllerBolg {
	
	@Autowired
	private ArticleService articleServer;
	
	@RequestMapping(value = "/data/index/{name}", 
			method = RequestMethod.GET, 
			produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public Result<List<Article>> queryIndexDefault(@PathVariable String name){
		return articleServer.queryDefault(name);
	}
	
	
	
	@RequestMapping(value = "/data/type/{className}/{sortName}/{number}", 
			method = RequestMethod.GET, 
			produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public Result<List<Article>> getClassification(@PathVariable String className,@PathVariable String sortName,@PathVariable String number){
		return articleServer.queryByClassification(className, sortName, number);
	}
	
	
	@RequestMapping(value = "/data/detail/{id}", 
			method = RequestMethod.GET, 
			produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public Result<Article> getDetail(@PathVariable String id){
		return articleServer.queryByIdArticle(id);
	}
	
	
	@RequestMapping(value = "/data/grade/{id}/{grade}", 
			method = RequestMethod.GET, 
			produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public Result<String> updateGraded(@PathVariable String id,@PathVariable String grade){
		return articleServer.updateGraded(id, grade);
	}
}
