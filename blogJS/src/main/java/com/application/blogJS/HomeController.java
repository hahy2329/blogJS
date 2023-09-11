package com.application.blogJS;



import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.application.blogJS.portfolio.dto.PortfolioDTO;
import com.application.blogJS.portfolio.service.PortfolioService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	private PortfolioService portfolioService;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(Locale locale, Model model)throws Exception {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		ModelAndView mv = new ModelAndView();
		List<PortfolioDTO> portfolioList = portfolioService.getPortfolioList();
		mv.addObject("portfolioList", portfolioList);
		mv.setViewName("/main");
		return mv;
		
	}
	
}
