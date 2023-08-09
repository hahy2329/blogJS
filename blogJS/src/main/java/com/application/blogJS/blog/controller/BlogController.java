package com.application.blogJS.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.application.blogJS.blog.dto.BlogDTO;
import com.application.blogJS.blog.service.BlogService;

@Controller
@RequestMapping("/blog")
public class BlogController {
	
	@Autowired
	private BlogService blogService; 
	
	
	@GetMapping("/blogStudy")
	public ModelAndView blogStudy() throws Exception{
		
		ModelAndView mv = new ModelAndView();
		
		List<BlogDTO> blogDTO = blogService.getBlogStudyList();
		mv.addObject("blogDTO", blogDTO);
		mv.setViewName("/blog/blogStudy");
		
		return mv;
		
	}
	
	
	
}
