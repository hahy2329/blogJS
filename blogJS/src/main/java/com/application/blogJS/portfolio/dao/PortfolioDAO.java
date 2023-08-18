package com.application.blogJS.portfolio.dao;

import com.application.blogJS.portfolio.dto.PortfolioDTO;

public interface PortfolioDAO {
	
	public void insertUploadPortfolio(PortfolioDTO portfolioDTO) throws Exception;
}
