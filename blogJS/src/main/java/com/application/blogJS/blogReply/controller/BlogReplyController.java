package com.application.blogJS.blogReply.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.application.blogJS.blogReply.dto.BlogReplyDTO;
import com.application.blogJS.blogReply.service.BlogReplyService;

@Controller
@RequestMapping("/blogReply")
public class BlogReplyController {
	
	private String FILE_REPO_PATH = "C:\\blogReply_image\\";

	@Autowired
	private BlogReplyService blogReplyService;
	
	
	@GetMapping("/blogReplyWrite")
	public ModelAndView blogWriteReply(@RequestParam("blogId") long blogId) throws Exception{
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("blogId", blogId);
		mv.setViewName("/blogReply/blogWriteReply");
		
		return mv;
		
		
	}
	
	@PostMapping("/blogReplyWrite")
	public ResponseEntity<Object> blogWriteReply(@RequestParam("blogId") long blogId,MultipartHttpServletRequest multipartRequest, HttpServletRequest request) throws Exception{
		
		Iterator<String> fileList = multipartRequest.getFileNames();
		String fileName = "";
		
		if(fileList.hasNext()) {
			MultipartFile uploadFile = multipartRequest.getFile(fileList.next());
			if(!uploadFile.getOriginalFilename().isEmpty()) {
				SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");
				fileName = fmt.format(new Date())+"_"+UUID.randomUUID()+"_"+uploadFile.getOriginalFilename();
				uploadFile.transferTo(new File(FILE_REPO_PATH+fileName));
			}
		}
		
		long id = blogId;
		
		BlogReplyDTO blogReplyDTO = new BlogReplyDTO();
		blogReplyDTO.setBlogId(id);
		blogReplyDTO.setContent(multipartRequest.getParameter("content"));
		blogReplyDTO.setHumanId(multipartRequest.getParameter("humanId"));
		blogReplyDTO.setImage(fileName);
		
		blogReplyService.uploadStudyBlogReply(blogReplyDTO);
		
		String message = "<script>";
		message +="alert('정상적으로 완료되었습니다.');";
		message +="location.href='"+request.getContextPath()+"/';";
		message +="</script>";
		
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		
		return new ResponseEntity<Object>(message, responseHeaders, HttpStatus.OK);
		
		
	}
	
	
	
	
	
}
