package com.application.blogJS.human.service;

import com.application.blogJS.human.dto.HumanDTO;

public interface HumanService {

	public String checkDuplicatedId(String humanId) throws Exception;
	public String checkDuplicatedEmail(String email) throws Exception;
	public void addHuman(HumanDTO humanDTO) throws Exception;
	public boolean loginCheck(HumanDTO humanDTO) throws Exception;
	public String checkDuplicatedPasswd(String passwd, String humanId) throws Exception;
	public HumanDTO getHumanDetail(String humanId) throws Exception;
	public void informationUpdate(HumanDTO humanDTO) throws Exception;
	public boolean passwordChange(HumanDTO humanDTO, String changePasswd) throws Exception;
	public void humanDelete(HumanDTO humanDTO) throws Exception; 
	
	
}
