package com.application.blogJS.human.dto;

import org.springframework.stereotype.Component;

@Component
public class HumanDTO {

	private String humanId;
	private String passwd;
	private String humanNm;
	private String birthDt;
	private String profile;
	private String email;
	private String content;
	private String joinDt;
	
	public String getHumanId() {
		return humanId;
	}
	public void setHumanId(String humanId) {
		this.humanId = humanId;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getHumanNm() {
		return humanNm;
	}
	public void setHumanNm(String humanNm) {
		this.humanNm = humanNm;
	}
	public String getBirthDt() {
		return birthDt;
	}
	public void setBirthDt(String birthDt) {
		this.birthDt = birthDt;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getJoinDt() {
		return joinDt;
	}
	public void setJoinDt(String joinDt) {
		this.joinDt = joinDt;
	}
	@Override
	public String toString() {
		return "HumanDTO [humanId=" + humanId + ", passwd=" + passwd + ", humanNm=" + humanNm + ", birthDt=" + birthDt
				+ ", profile=" + profile + ", email=" + email + ", content=" + content + ", joinDt=" + joinDt
				+ ", toString()=" + super.toString() + "]";
	}
	
	
	
	
	
	
}
