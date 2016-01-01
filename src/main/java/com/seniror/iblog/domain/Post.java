package com.seniror.iblog.domain;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Post implements java.lang.Comparable<Post>{

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
	
	private String permLink;
	
	public Post() {
		this.createdTime = new Date();
		this.createdYear = calCreatedYear();
		this.updatedTime = new Date();
	}
	
	// Builder Constructor
	public Post markdownSource(String markdownSource) {
		this.markdownSource = markdownSource;
		return this;
	}
	
	public Post title(String title) {
		this.title = title;
		return this;
	}
	
	public Post htmlContent(String htmlContent) {
		this.parsedHtmlContent = htmlContent;
		return this;
	}
	
	public Post creator(User creator) {
		this.creator = creator;
		return this;
	}	
	
	public Post permLink(String permLink) {
		this.permLink = permLink;
		return this;
	}		
	
	// this builder method should only be used for local test
	public Post createdTime(Date createdTime) {
		this.createdTime = createdTime;
		this.createdYear = calCreatedYear();
		return this;
	}
	// Builder Constructor end
	
	private Integer calCreatedYear() {
		Calendar now = Calendar.getInstance();
		now.setTime(this.createdTime);
		return now.get(Calendar.YEAR);
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
	public String getPermLink() {
		return permLink;
	}
	public void setPermLink(String permLink) {
		this.permLink = permLink;
	}
	@Override
	public String toString() {
		return "Post [title=" + title + "]";
	}

	@Override
	public int compareTo(Post other) {
		// desc
		return other.createdTime.compareTo(this.createdTime);
	}
}
