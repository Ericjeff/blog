package com.imooc.enums;

public enum BlogEnum {
	
	FAIL(0,"失败"),
	SUCCESS(1,"成功"),
	NoData(2,"你还没有写过一篇博客哦或者你查询的文章不存在");
	
	//代号
	private int id;
	
	//具体的含义
	private String info;

	BlogEnum(int id, String info) {
		this.id = id;
		this.info = info;
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
}
