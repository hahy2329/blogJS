package com.application.blogJS.human.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class HumanDAOImpl implements HumanDAO {

	@Autowired
	private SqlSession sqlSession;
	
	
	@Override
	public String checkDuplicatedId(String humanId) throws Exception {
		return sqlSession.selectOne("human.checkOverlappedId", humanId);
	
	}

}
