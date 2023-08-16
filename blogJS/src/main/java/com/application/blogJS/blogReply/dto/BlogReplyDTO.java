package com.application.blogJS.blogReply.dto;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class BlogReplyDTO {
	
	private long replyId;
	private String content;
	private Date enrollDt;
	private String image;
	private String humanId;
	private long blogId;
	
	public long getReplyId() {
		return replyId;
	}
	public void setReplyId(long replyId) {
		this.replyId = replyId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getEnrollDt() {
		return enrollDt;
	}
	public void setEnrollDt(Date enrollDt) {
		this.enrollDt = enrollDt;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getHumanId() {
		return humanId;
	}
	public void setHumanId(String humanId) {
		this.humanId = humanId;
	}
	public long getBlogId() {
		return blogId;
	}
	public void setBlogId(long blogId) {
		this.blogId = blogId;
	}
	@Override
	public String toString() {
		return "BlogReplyDTO [replyId=" + replyId + ", content=" + content + ", enrollDt=" + enrollDt + ", image="
				+ image + ", humanId=" + humanId + ", blogId=" + blogId + ", toString()=" + super.toString() + "]";
	}
	
	
	
	
}
