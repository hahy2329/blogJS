package com.application.blogJS.human.dao;

import com.application.blogJS.human.dto.HumanDTO;

public interface HumanDAO {
	
	public String checkDuplicatedId(String humanId) throws Exception;
	public String checkDuplicateEmail(String email) throws Exception;
	public void addHuman(HumanDTO humanDTO) throws Exception;
	public String checkEncodePasswd(String humanId) throws Exception;
	public HumanDTO loginHuman(HumanDTO humanDTO) throws Exception;
	public HumanDTO getHumanDetail(String humanId) throws Exception;
	public String getEncodePasswd(String humanId) throws Exception;
	public void informationUpdate(HumanDTO humanDTO) throws Exception;
	public void changePsswd(HumanDTO humanDTO) throws Exception;
	public void humanDelete(HumanDTO humanDTO) throws Exception;
}
