package com.application.blogJS.portfolio.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.application.blogJS.portfolio.dto.PortfolioDTO;

@Repository
public class PortfolioDAOImpl implements PortfolioDAO {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void addPortfolio(PortfolioDTO portfolioDTO) throws Exception {
		
		sqlSession.insert("portfolio.addPortfolio", portfolioDTO);
		
	}

	@Override
	public List<PortfolioDTO> getPortfolioList() throws Exception {
		return sqlSession.selectList("portfolio.getPortfolioList");
	}

	@Override
	public List<PortfolioDTO> getWebPortfolioList() throws Exception {
		return sqlSession.selectList("portfolio.getWebPortfolioList");
	}
	
	
}
