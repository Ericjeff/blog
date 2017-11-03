package com.imooc.dto;

import org.springframework.web.multipart.MultipartFile;

/**
 *处理文章上传，Markdown解析为html
 */
public class MultiFileUploadForm {
	
	private String title;
	
	private String tag;
	
	private String summary;
	
	private String classification;
	
	private MultipartFile multiUploadFile;

	
	public MultiFileUploadForm(){
		
	}
	
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getClassification() {
		return classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}

	public MultipartFile getMultiUploadFile() {
		return multiUploadFile;
	}

	public void setMultiUploadFile(MultipartFile multiUploadFile) {
		this.multiUploadFile = multiUploadFile;
	}
	
	
}
