package com.application.blogJS.portfolio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.blogJS.portfolio.dao.PortfolioDAO;
import com.application.blogJS.portfolio.dto.PortfolioDTO;

@Service
public class PortfolioServiceImpl implements PortfolioService {

	@Autowired
	private PortfolioDAO portfolioDAO;
	
	@Override
	public void insertUploadPortfolio(PortfolioDTO portfolioDTO) throws Exception {
		portfolioDAO.insertUploadPortfolio(portfolioDTO);
		
	}

}
