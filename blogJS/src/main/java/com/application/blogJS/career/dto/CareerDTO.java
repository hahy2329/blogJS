package com.application.blogJS.career.dto;





import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class CareerDTO {
	
	private long careerId;
	private String companyName;
	private String department;
	private String period;
	private String skill;
	private Date joinDate;
	private Date resignationDate;
	private String humanId;
	
	public long getCareerId() {
		return careerId;
	}
	public void setCareerId(long careerId) {
		this.careerId = careerId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	public String getSkill() {
		return skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
	}
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	public Date getResignationDate() {
		return resignationDate;
	}
	public void setResignationDate(Date resignationDate) {
		this.resignationDate = resignationDate;
	}
	public String getHumanId() {
		return humanId;
	}
	public void setHumanId(String humanId) {
		this.humanId = humanId;
	}
	
	@Override
	public String toString() {
		return "CareerDTO [careerId=" + careerId + ", companyName=" + companyName + ", department=" + department
				+ ", period=" + period + ", skill=" + skill + ", joinDate=" + joinDate + ", resignationDate="
				+ resignationDate + ", humanId=" + humanId + ", toString()=" + super.toString() + "]";
	}
	
	
	
}
