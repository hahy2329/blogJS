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

	@Override
	public List<PortfolioDTO> getAppPortfolioList() throws Exception {
		return portfolioDAO.getAppPortfolioList();
	}

	@Override
	public PortfolioDTO getPortfolioDetail(long portfolioId) throws Exception {
		return portfolioDAO.getPortfolioDetail(portfolioId);
	}

	@Override
	public void portfolioUpdate(PortfolioDTO portfolioDTO) throws Exception {
		portfolioDAO.portfolioUpdate(portfolioDTO);
		
	}

	@Override
	public void portfolioDelete(PortfolioDTO portfolioDTO) throws Exception {
		portfolioDAO.portfolioDelete(portfolioDTO);
		
	}

}
