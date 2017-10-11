package com.imooc.exception;

/**
 *这个项目的异常父级类
 */
abstract class BlogException extends RuntimeException{
	
	public BlogException(String message){
		super(message);
	}
	
	public BlogException(String message,Throwable e){
		super(message,e);
	}
}
