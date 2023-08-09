package com.application.blogJS.blog.dto;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class BlogDTO {
	
	private long blogId;
	private String humanId;
	private String subject;
	private String content;
	private int readCnt;
	private Date enrollDt;
	private String sort;
	private String picture1;
	private String picture2;
	private String picture3;
	
	public long getBlogId() {
		return blogId;
	}
	public void setBlogId(long blogId) {
		this.blogId = blogId;
	}
	public String getHumanId() {
		return humanId;
	}
	public void setHumanId(String humanId) {
		this.humanId = humanId;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getReadCnt() {
		return readCnt;
	}
	public void setReadCnt(int readCnt) {
		this.readCnt = readCnt;
	}
	public Date getEnrollDt() {
		return enrollDt;
	}
	public void setEnrollDt(Date enrollDt) {
		this.enrollDt = enrollDt;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public String getPicture1() {
		return picture1;
	}
	public void setPicture1(String picture1) {
		this.picture1 = picture1;
	}
	public String getPicture2() {
		return picture2;
	}
	public void setPicture2(String picture2) {
		this.picture2 = picture2;
	}
	public String getPicture3() {
		return picture3;
	}
	public void setPicture3(String picture3) {
		this.picture3 = picture3;
	}
	@Override
	public String toString() {
		return "BlogDTO [blogId=" + blogId + ", humanId=" + humanId + ", subject=" + subject + ", content=" + content
				+ ", readCnt=" + readCnt + ", enrollDt=" + enrollDt + ", sort=" + sort + ", picture1=" + picture1
				+ ", picture2=" + picture2 + ", picture3=" + picture3 + ", toString()=" + super.toString() + "]";
	}
	
	
	
	
	
}
