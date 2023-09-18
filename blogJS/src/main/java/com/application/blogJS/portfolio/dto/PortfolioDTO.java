package com.application.blogJS.portfolio.dto;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class PortfolioDTO {

	
	private long portfolioId;
	private String image;
	private String subject;
	private String content;
	private Date makeDt;
	private String sort;
	private int numberPeople;
	private String madePeople;
	private int complete;
	private String humanId;
	
	public long getPortfolioId() {
		return portfolioId;
	}
	public void setPortfolioId(long portfolioId) {
		this.portfolioId = portfolioId;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
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
	public Date getMakeDt() {
		return makeDt;
	}
	public void setMakeDt(Date makeDt) {
		this.makeDt = makeDt;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public int getNumberPeople() {
		return numberPeople;
	}
	public void setNumberPeople(int numberPeople) {
		this.numberPeople = numberPeople;
	}
	public String getMadePeople() {
		return madePeople;
	}
	public void setMadePeople(String madePeople) {
		this.madePeople = madePeople;
	}
	public int getComplete() {
		return complete;
	}
	public void setComplete(int complete) {
		this.complete = complete;
	}
	public String getHumanId() {
		return humanId;
	}
	public void setHumanId(String humanId) {
		this.humanId = humanId;
	}
	@Override
	public String toString() {
		return "PortfolioDTO [portfolioId=" + portfolioId + ", image=" + image + ", subject=" + subject + ", content="
				+ content + ", makeDt=" + makeDt + ", sort=" + sort + ", numberPeople=" + numberPeople + ", madePeople="
				+ madePeople + ", complete=" + complete + ", humanId=" + humanId + ", toString()=" + super.toString()
				+ "]";
	}
	
	
	
	
	
	
	
	
	
	
	
}
