package com.application.blogJS.career.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.application.blogJS.career.dto.CareerDTO;
import com.application.blogJS.career.service.CareerService;

@Controller
@RequestMapping("/career")
public class CareerController {
	
	@Autowired
	private CareerService careerService;
	
	@GetMapping("/careerWrite")
	public ModelAndView careerWrite() throws Exception{
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/career/careerWrite");
		return mv;
		
	}
	
	@PostMapping("/careerWrite")
	public ResponseEntity<Object> careerWrite(@RequestParam("joinDate") Date joinDate,CareerDTO careerDTO, HttpServletRequest request) throws Exception{
		
		
		careerService.insertCareerData(careerDTO);
		
		String message = "<script>";
		message +="alert('정상적으로 등록이 완료되었습니다.');";
		message +="location.href='"+request.getContextPath()+"/';";
		message +="</script>";
		
		HttpHeaders responseheaders = new HttpHeaders();
		responseheaders.add("Content-Type", "text/html; charset=utf-8");
		
		return new ResponseEntity<Object>(message, responseheaders, HttpStatus.OK);
		
	}
	
}
