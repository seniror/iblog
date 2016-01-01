package com.seniror.iblog.domain;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Post {

	@Id
	@GeneratedValue
	private Integer id;
	private String title;
	private String markdownSource;
	private String parsedHtmlContent;
	@ManyToOne
	private User creator;
	private Integer createdYear;
	private Date createdTime;
	private Date updatedTime;
	
	public Post() {
	}
	
	public Post(String title, String markdownSource, String htmlContent, User creator) {
		this.title = title;
		this.markdownSource = markdownSource;
		this.parsedHtmlContent = htmlContent;
		this.creator = creator;
		this.createdTime = new Date();
		this.createdYear = calCreatedYear();
		this.updatedTime = new Date();
	}
	
	private Integer calCreatedYear() {
		Calendar now = Calendar.getInstance();
		now.setTime(this.createdTime);
		return now.get(Calendar.YEAR);
	}
	
	/*
	 * For Test only
	 */
	public Post(String title, String content, User user, Date createdTime) {
		this.title = title;
		this.markdownSource = content;
		this.creator = user;
		this.createdTime = createdTime;
		this.createdYear = calCreatedYear();
		this.updatedTime = new Date();
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMarkdownSource() {
		return markdownSource;
	}
	public void setMarkdownSource(String markdownSource) {
		this.markdownSource = markdownSource;
	}
	public User getCreator() {
		return creator;
	}
	public void setCreator(User creator) {
		this.creator = creator;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	public Date getUpdatedTime() {
		return updatedTime;
	}
	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}
	public Integer getCreatedYear() {
		return createdYear;
	}
	public void setCreatedYear(Integer createYear) {
		this.createdYear = createYear;
	}
	public String getParsedHtmlContent() {
		return parsedHtmlContent;
	}
	public void setParsedHtmlContent(String parsedHtmlContent) {
		this.parsedHtmlContent = parsedHtmlContent;
	}
	@Override
	public String toString() {
		return "Post [title=" + title + "]";
	}
}
