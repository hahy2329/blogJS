package com.application.blogJS.human.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.application.blogJS.human.dto.HumanDTO;

@Repository
public class HumanDAOImpl implements HumanDAO {

	@Autowired
	private SqlSession sqlSession;
	
	
	@Override
	public String checkDuplicatedId(String humanId) throws Exception {
		return sqlSession.selectOne("human.checkOverlappedId", humanId);
	
	}


	@Override
	public String checkDuplicateEmail(String email) throws Exception {
		return sqlSession.selectOne("human.checkOverlappedEmail", email);
	}


	@Override
	public void addHuman(HumanDTO humanDTO) throws Exception {
		sqlSession.insert("human.insertHuman", humanDTO);
		
	}


	@Override
	public String checkEncodePasswd(String humanId) throws Exception {
		return sqlSession.selectOne("human.checkEncodePasswd", humanId);
	}


	@Override
	public HumanDTO loginHuman(HumanDTO humanDTO) throws Exception {
		return sqlSession.selectOne("human.loginHuman", humanDTO);
	}


	@Override
	public HumanDTO getHumanDetail(String humanId) throws Exception {
		return sqlSession.selectOne("human.getHumanDetail", humanId);
	}

	@Override
	public void informationUpdate(HumanDTO humanDTO) throws Exception {
		sqlSession.update("human.informationUpdate", humanDTO);
		
	}

	@Override
	public String getEncodePasswd(String humanId) throws Exception {
		
		return sqlSession.selectOne("human.getEncodePasswd", humanId);
	}


	@Override
	public void changePsswd(HumanDTO humanDTO) throws Exception {
		
		sqlSession.update("human.changePsswd", humanDTO);
		
	}


	@Override
	public void humanDelete(HumanDTO humanDTO) throws Exception {
		sqlSession.delete("human.humanDelete", humanDTO);
		
	}



}
