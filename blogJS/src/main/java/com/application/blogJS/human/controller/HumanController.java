package com.application.blogJS.human.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.application.blogJS.human.service.HumanService;

@Controller
@RequestMapping("/human")
public class HumanController {
	
	@Autowired
	private HumanService humanService;
	
	@GetMapping("/register")
	public ModelAndView register() throws Exception{
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/human/register");
		return mv;
		
		
	}
	
	@GetMapping("/overlappedId")
	public ResponseEntity<String> overlappedId(@RequestParam("humanId") String humanId) throws Exception{
		System.out.println("요청성공!!!!");
		return new ResponseEntity<String>(humanService.checkDuplicatedId(humanId), HttpStatus.OK);
	}
	
	
}
