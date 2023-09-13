package com.application.blogJS.career.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/career")
public class CareerController {
	
	@GetMapping("/careerWrite")
	public ModelAndView careerWrite() throws Exception{
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/career/careerWrite");
		return mv;
		
	}
	
}
