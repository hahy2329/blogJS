package com.application.blogJS.human.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.application.blogJS.human.dao.HumanDAO;
import com.application.blogJS.human.dto.HumanDTO;

@Service
public class HumanServiceImpl implements HumanService {

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	
	@Autowired
	private HumanDAO humanDAO;
	
	@Override
	public String checkDuplicatedId(String humanId) throws Exception {
		
		
		if(humanDAO.checkDuplicatedId(humanId)==null) return "NO";
			
		
		else 			return "YES";
		
	}

	@Override
	public String checkDuplicatedEmail(String email) throws Exception {
		if(humanDAO.checkDuplicateEmail(email)==null) return "true";
		else		return "false";
	}

	@Override
	public void addHuman(HumanDTO humanDTO) throws Exception {
		
		humanDTO.setPasswd(bCryptPasswordEncoder.encode(humanDTO.getPasswd()));
		humanDAO.addHuman(humanDTO);
		
	}

	@Override
	public boolean loginCheck(HumanDTO humanDTO) throws Exception {
		
		boolean isCheckId = false;
		
		if(bCryptPasswordEncoder.matches(humanDTO.getPasswd(), humanDAO.checkEncodePasswd(humanDTO.getHumanId()))) {
			
			humanDAO.loginHuman(humanDTO);
			isCheckId = true;
		}
		else {
			isCheckId = false;
		}
		
		return isCheckId;
	}

	@Override
	public String checkDuplicatedPasswd(String passwd, String humanId) throws Exception {
		if(bCryptPasswordEncoder.matches(passwd, humanDAO.checkEncodePasswd(humanId))) {
			return "duplicate";
		}
		else {
			return "isNotDuplicate";
		}
	}

	@Override
	public HumanDTO getHumanDetail(String humanId) throws Exception {
		return humanDAO.getHumanDetail(humanId);
	}

}
