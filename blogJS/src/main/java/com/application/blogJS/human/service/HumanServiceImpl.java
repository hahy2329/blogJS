package com.application.blogJS.human.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.blogJS.human.dao.HumanDAO;

@Service
public class HumanServiceImpl implements HumanService {

	
	@Autowired
	private HumanDAO humanDAO;
	
	@Override
	public String checkDuplicatedId(String humanId) throws Exception {
		
		
		if(humanDAO.checkDuplicatedId(humanId)==null) {
			
			return "NO";
			
		}
		else {
			
			return "YES";
		}
	}

}
