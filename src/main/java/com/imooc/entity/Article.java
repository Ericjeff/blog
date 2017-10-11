package com.imooc.entity;

import java.util.Date;

/**
 *
 * 对应数据库中的article表
 *
 */
public class Article {

	private int id;

	private String title;

	private Date date;

	private int visitCount;

	private String summary;

	private String content;

	private String tag;

	private double graded;

	private int gradedCount;

	private String classification;

	public Article() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getVisitCount() {
		return visitCount;
	}

	public void setVisitCount(int visitCount) {
		this.visitCount = visitCount;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public double getGraded() {
		return graded;
	}

	public void setGraded(double graded) {
		this.graded = graded;
	}

	public int getGradedCount() {
		return gradedCount;
	}

	public void setGradedCount(int gradedCount) {
		this.gradedCount = gradedCount;
	}

	public String getClassification() {
		return classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}

}
