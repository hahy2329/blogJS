package com.application.blogJS.portfolio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.blogJS.portfolio.dao.PortfolioDAO;
import com.application.blogJS.portfolio.dto.PortfolioDTO;

@Service
public class PortfolioServiceImpl implements PortfolioService {
	
	@Autowired
	private PortfolioDAO portfolioDAO;

	@Override
	public void addPortfolio(PortfolioDTO portfolioDTO) throws Exception {
		portfolioDAO.addPortfolio(portfolioDTO);
		
	}

	@Override
	public List<PortfolioDTO> getPortfolioList() throws Exception {
		return portfolioDAO.getPortfolioList();
	}

	@Override
	public List<PortfolioDTO> getWebPortfolioList() throws Exception {
		return portfolioDAO.getWebPortfolioList();
	}

}
