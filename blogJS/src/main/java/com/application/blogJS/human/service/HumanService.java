package com.application.blogJS.human.service;

import com.application.blogJS.human.dto.HumanDTO;

public interface HumanService {

	public String checkDuplicatedId(String humanId) throws Exception;
	public String checkDuplicatedEmail(String email) throws Exception;
	public void addHuman(HumanDTO humanDTO) throws Exception;
	public boolean loginCheck(HumanDTO humanDTO) throws Exception;
	
}
