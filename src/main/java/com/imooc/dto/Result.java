package com.imooc.dto;

import com.imooc.enums.BlogEnum;

/**
 * 返回给前端页面一种标准的格式
 * 
 * @author Administrator
 *
 */
public class Result<T> {

	// 信息的代号
	private int id;

	// 信息的内容
	private String info;

	// 传输的数据
	private T data;

	public Result() {

	}

	public Result(BlogEnum blogEnum) {
		
		this.id = blogEnum.getId();
		this.info = blogEnum.getInfo();
	}

	public Result(BlogEnum blogEnum, T data) {
		
		this.id = blogEnum.getId();
		this.info = blogEnum.getInfo();
		this.data = data;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
