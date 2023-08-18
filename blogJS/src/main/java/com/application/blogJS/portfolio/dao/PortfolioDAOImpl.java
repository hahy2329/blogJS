package com.application.blogJS.portfolio.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.application.blogJS.portfolio.dto.PortfolioDTO;

@Repository
public class PortfolioDAOImpl implements PortfolioDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void insertUploadPortfolio(PortfolioDTO portfolioDTO) throws Exception {
		sqlSession.insert("portfolio.insertUploadPortfolio");
		
	}

}
