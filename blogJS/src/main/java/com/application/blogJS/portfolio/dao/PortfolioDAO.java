package com.application.blogJS.portfolio.dao;

import java.util.List;

import com.application.blogJS.portfolio.dto.PortfolioDTO;

public interface PortfolioDAO {
	
	public void addPortfolio(PortfolioDTO portfolioDTO) throws Exception;
	public List<PortfolioDTO> getPortfolioList() throws Exception;
	public List<PortfolioDTO> getWebPortfolioList() throws Exception;
}
