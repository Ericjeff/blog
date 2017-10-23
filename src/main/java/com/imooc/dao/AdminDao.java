package com.imooc.dao;

import org.apache.ibatis.annotations.Param;

import com.imooc.entity.Admin;

/**
 *对admin表的操作 
 */
public interface AdminDao {

	/**
	 * 查询admin
	 */
	public String queryByName(@Param("username")String username);
	
	
	
	/**
	 * 修改
	 */
	public int modify(Admin admin);
}
