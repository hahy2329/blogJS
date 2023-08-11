package com.application.blogJS.blog.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.application.blogJS.blog.dto.BlogDTO;
import com.application.blogJS.blog.service.BlogService;

@Controller
@RequestMapping("/blog")
public class BlogController {
	
	private String FILE_REPO_PATH = "C:\\blog_image\\";
	
	
	@Autowired
	private BlogService blogService; 
	
	
	@GetMapping("/blogWrite")
	public ModelAndView blogWrite() throws Exception{
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/blog/blogWriter");
		return mv;
	}
	
	@PostMapping("/blogWrite")
	public ResponseEntity<Object> blogWrite(MultipartHttpServletRequest multipartRequest, HttpServletRequest request) throws Exception{
		
		Iterator<String> fileList = multipartRequest.getFileNames();
		String fileName1="";
		String fileName2="";
		String fileName3="";
		
		while(fileList.hasNext()) {
			
			MultipartFile uploadFile = multipartRequest.getFile(fileList.next());
			if(!uploadFile.getOriginalFilename().isEmpty()) {
				SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");
				for(int i = 1; i<=3; i++) {
					if(i==1) {
						fileName1 = fmt.format(new Date())+"_"+UUID.randomUUID() + "_" + uploadFile.getOriginalFilename();
						uploadFile.transferTo(new File(FILE_REPO_PATH+fileName1));
					}
					if(i==2) {
						fileName2 = fmt.format(new Date())+"_"+UUID.randomUUID() + "_" + uploadFile.getOriginalFilename();
						uploadFile.transferTo(new File(FILE_REPO_PATH+fileName2));
					}
					if(i==3) {
						fileName3 = fmt.format(new Date())+"_"+UUID.randomUUID() + "_" + uploadFile.getOriginalFilename();
						uploadFile.transferTo(new File(FILE_REPO_PATH+fileName3));
						
					}
				}
			}
		}
		
		BlogDTO blogDTO = new BlogDTO();
		blogDTO.setHumanId(multipartRequest.getParameter("humanId"));
		blogDTO.setSubject(multipartRequest.getParameter("subject"));
		blogDTO.setContent(multipartRequest.getParameter("content"));
		blogDTO.setSort(multipartRequest.getParameter("sort"));
		blogDTO.setPicture1(multipartRequest.getParameter(fileName1));
		blogDTO.setPicture2(multipartRequest.getParameter(fileName2));
		blogDTO.setPicture3(multipartRequest.getParameter(fileName3));
		
		blogService.insertBlog(blogDTO);
		
		String message = "<script>";
		message +="alert('정상적으로 등록이 완료되었습니다.');";
		message +="location.href='"+request.getContextPath() +"/';";
		message +="</script>";
		
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		
		return new ResponseEntity<Object>(message, responseHeaders, HttpStatus.OK);
		
	}
	
	@GetMapping("/blogStudy")
	public ModelAndView blogStudy() throws Exception{
		
		ModelAndView mv = new ModelAndView();
		
		List<BlogDTO> blogDTO = blogService.getBlogStudyList();
		mv.addObject("blogDTO", blogDTO);
		mv.setViewName("/blog/blogStudy");
		
		return mv;
		
	}
	
	
	
	
	
}
