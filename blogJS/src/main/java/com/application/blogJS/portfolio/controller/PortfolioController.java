package com.application.blogJS.portfolio.controller;

import java.io.File;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

import net.coobird.thumbnailator.Thumbnails;



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
	public ResponseEntity<Object> portfolioWrite(@RequestParam("makeDt")String makeDt ,@RequestParam("complete") String complete, @RequestParam("numberPeople") String numberPeople , MultipartHttpServletRequest multipartRequest, HttpServletRequest request) throws Exception{
		
		
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
		
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		Date date = fmt.parse(makeDt);
		
		
		
		
		portfolioDTO.setHumanId(multipartRequest.getParameter("humanId"));
		portfolioDTO.setSubject(multipartRequest.getParameter("subject"));
		portfolioDTO.setContent(multipartRequest.getParameter("content"));
		portfolioDTO.setMakeDt(date);
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
	
	
	
	@GetMapping("/portfolioTopic")
	public ModelAndView topic() throws Exception{
		
		ModelAndView mv = new ModelAndView();
		List<PortfolioDTO> portfolioList = portfolioService.getPortfolioList();
		mv.addObject("portfolioList", portfolioList);
		mv.setViewName("/portfolio/portfolioTopic");
		return mv;
	
	}
	
	@GetMapping("/portfolioImage")
	public void portfolioImage(@RequestParam("image") String image, HttpServletResponse response) throws Exception{
		
		OutputStream out = response.getOutputStream();
		
		File picture = new File(FILE_REPO_PATH+image);
		if(picture.exists()) {
			Thumbnails.of(picture).forceSize(375, 325).outputFormat("jpg").toOutputStream(out);
		}
		byte[] buffer = new byte[1024*8];
		out.write(buffer);
		out.close();
	}
	
	@GetMapping("/webPortfolio")
	public ModelAndView webPortfolio() throws Exception{
		
		ModelAndView mv = new ModelAndView();
		List<PortfolioDTO> portfolioList = portfolioService.getWebPortfolioList();
		mv.addObject("portfolioList", portfolioList);
		mv.setViewName("/portfolio/webPortfolio");
		
		return mv;
		
	}
	
	@GetMapping("/appPortfolio")
	public ModelAndView appPortfolio() throws Exception{
		
		ModelAndView mv = new ModelAndView();
		List<PortfolioDTO> portfolioList = portfolioService.getAppPortfolioList();
		mv.addObject("portfolioList", portfolioList);
		mv.setViewName("/portfolio/appPortfolio");
		
		return mv; 
		
	}
	
	@GetMapping("/portfolioDetail")
	public ModelAndView portfolioDetail(@RequestParam("portfolioId") long portfolioId) throws Exception{
		
		ModelAndView mv = new ModelAndView();
		PortfolioDTO portfolioDTO = portfolioService.getPortfolioDetail(portfolioId);
		mv.addObject("portfolioDTO", portfolioDTO);
		mv.setViewName("/portfolio/portfolioDetail");
		
		return mv;
		
	}
	
	@GetMapping("/portfolioDetailImg")
	public void portfolioDetailImg(@RequestParam("image") String image, HttpServletResponse response) throws Exception{
		
		OutputStream out = response.getOutputStream();
		
		File picture = new File(FILE_REPO_PATH+image);
		if(picture.exists()) {
			Thumbnails.of(picture).forceSize(570, 520).outputFormat("jpg").toOutputStream(out);
		}
		byte[] buffer = new byte[1024*8];
		out.write(buffer);
		out.close();
		
	}

	
}
