package com.application.blogJS.portfolio.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.UUID;

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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.application.blogJS.portfolio.dto.PortfolioDTO;
import com.application.blogJS.portfolio.service.PortfolioService;

@Controller
@RequestMapping("/portfolio")
public class PortfolioController {
	
	private String FILE_REPO_PATH = "C:\\portfolio_file_repo_path\\";
	
	@Autowired
	private PortfolioService portfolioService;
	
	
	@GetMapping("/portfolioWrite")
	public ModelAndView category() throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/portfolio/portfolioWrite");
		return mv;
		
		
	}
	
	@PostMapping("/portfolioWrite")
	public ResponseEntity<Object> portfolioWrite(@RequestParam("complete") String complete, @RequestParam("numberPeople") String numberPeople , MultipartHttpServletRequest multipartRequest, HttpServletRequest request) throws Exception{
		
		
		PortfolioDTO portfolioDTO = new PortfolioDTO();
		
		Iterator<String> fileList = multipartRequest.getFileNames();
		String fileName="";
		
		if(fileList.hasNext()) {
			MultipartFile uploadFile = multipartRequest.getFile(fileList.next());
			if(!uploadFile.getOriginalFilename().isEmpty()) {
				SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");
				fileName = fmt.format(new Date()) + "_" + UUID.randomUUID()+"_"+uploadFile.getOriginalFilename();
				uploadFile.transferTo(new File(FILE_REPO_PATH+fileName));
				portfolioDTO.setImage(fileName);
			}
		}
		
		int number = Integer.parseInt(numberPeople);
		int rating = Integer.parseInt(complete);
		
		
		portfolioDTO.setHumanId(multipartRequest.getParameter("humanId"));
		portfolioDTO.setSubject(multipartRequest.getParameter("subject"));
		portfolioDTO.setContent(multipartRequest.getParameter("content"));
		portfolioDTO.setMakeDt(multipartRequest.getParameter("makeDt"));
		portfolioDTO.setSort(multipartRequest.getParameter("sort"));
		portfolioDTO.setNumberPeople(number);
		portfolioDTO.setMadePeople(multipartRequest.getParameter("madePeople"));
		portfolioDTO.setComplete(rating);
		
		portfolioService.addPortfolio(portfolioDTO);
		
		String message = "<script>";
		message +="alert('정상적으로 등록이 완료되었습니다.');";
		message +="location.href='"+request.getContextPath() +"/';";
		message +="</script>";
		
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		
		return new ResponseEntity<Object>(message,responseHeaders,HttpStatus.OK);
		
		
		
		
		
		
	
		
		
	}
}
