package com.application.blogJS.portfolio.service;

import java.util.List;

import com.application.blogJS.portfolio.dto.PortfolioDTO;

public interface PortfolioService {
	
	public void addPortfolio(PortfolioDTO portfolioDTO) throws Exception;
	public List<PortfolioDTO> getPortfolioList() throws Exception;
	public List<PortfolioDTO> getWebPortfolioList() throws Exception;
	public List<PortfolioDTO> getAppPortfolioList() throws Exception;
	public PortfolioDTO getPortfolioDetail(long portfolioId) throws Exception;
	public void portfolioUpdate(PortfolioDTO portfolioDTO) throws Exception;
	public void portfolioDelete(PortfolioDTO portfolioDTO) throws Exception;
}
