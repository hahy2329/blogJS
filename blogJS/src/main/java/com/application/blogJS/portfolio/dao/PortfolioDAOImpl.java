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

	@Override
	public List<PortfolioDTO> getAppPortfolioList() throws Exception {
		return sqlSession.selectList("portfolio.getAppPortfolioList");
	}

	@Override
	public PortfolioDTO getPortfolioDetail(long portfolioId) throws Exception {
		return sqlSession.selectOne("portfolio.getPortfolioDetail", portfolioId);
	}
	
	
	
	
}
