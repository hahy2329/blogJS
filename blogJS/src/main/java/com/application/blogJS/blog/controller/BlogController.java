package com.application.blogJS.blog.controller;

import java.io.File;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
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

import com.application.blogJS.blog.dto.BlogDTO;
import com.application.blogJS.blog.service.BlogService;
import com.application.blogJS.blogReply.dto.BlogReplyDTO;
import com.application.blogJS.blogReply.service.BlogReplyService;
import com.application.blogJS.human.dto.HumanDTO;
import com.application.blogJS.human.service.HumanService;

import net.coobird.thumbnailator.Thumbnails;

@Controller
@RequestMapping("/blog")
public class BlogController {
	
	private String FILE_REPO_PATH = "C:\\blog_image\\";
	
	
	@Autowired
	private BlogService blogService; 
	
	@Autowired
	private BlogReplyService blogReplyService;
	
	@Autowired
	private HumanService humanService;
	
	@GetMapping("/blogWrite")
	public ModelAndView blogWrite() throws Exception{
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/blog/blogWriter");
		return mv;
	}
	
	@PostMapping("/blogWrite")
	public ResponseEntity<Object> blogWrite(MultipartHttpServletRequest multipartRequest, HttpServletRequest request) throws Exception{
		
		BlogDTO blogDTO = new BlogDTO();
	
		Iterator<String> fileList = multipartRequest.getFileNames();
		String fileName="";
		String fileName2="";
		String fileName3="";
		
		
		while(fileList.hasNext()) {
			for(int i =1; i<=3; i++) {
				if(i == 1) {
				MultipartFile uploadFile = multipartRequest.getFile(fileList.next());
					if(!uploadFile.getOriginalFilename().isEmpty()) {
						SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");
						fileName = fmt.format(new Date())+"_"+UUID.randomUUID() + "_" + uploadFile.getOriginalFilename();
						uploadFile.transferTo(new File(FILE_REPO_PATH+fileName));
						blogDTO.setPicture1(fileName);
			
					}
				}
				
				if(i ==2) {
					MultipartFile uploadFile = multipartRequest.getFile(fileList.next());
					if(!uploadFile.getOriginalFilename().isEmpty()) {
						SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");
						fileName2 = fmt.format(new Date())+"_"+UUID.randomUUID() + "_" + uploadFile.getOriginalFilename();
						uploadFile.transferTo(new File(FILE_REPO_PATH+fileName2));
						blogDTO.setPicture2(fileName2);
			
					}
					
				}
				
				if(i==3) {
					MultipartFile uploadFile = multipartRequest.getFile(fileList.next());
					if(!uploadFile.getOriginalFilename().isEmpty()) {
						SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");
						fileName3 = fmt.format(new Date())+"_"+UUID.randomUUID() + "_" + uploadFile.getOriginalFilename();
						uploadFile.transferTo(new File(FILE_REPO_PATH+fileName3));
						blogDTO.setPicture3(fileName3);
			
					}
					
					
				}
			}
		}
		
		blogDTO.setHumanId(multipartRequest.getParameter("humanId"));
		blogDTO.setSubject(multipartRequest.getParameter("subject"));
		blogDTO.setContent(multipartRequest.getParameter("content"));
		blogDTO.setSort(multipartRequest.getParameter("sort"));
		
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
		mv.addObject("blogStudy", blogDTO);
		mv.setViewName("/blog/blogStudy");
		
		return mv;
		
	}
	
	
	@GetMapping("/thumbnails")
	public void thumbnails(@RequestParam("picture1") String picture1, HttpServletResponse response) throws Exception{
		
		OutputStream out = response.getOutputStream();
		
		File image = new File(FILE_REPO_PATH+picture1);
		if(image.exists()) {
			Thumbnails.of(image).forceSize(555, 280).outputFormat("jpg").toOutputStream(out);
		}
		byte[] buffer = new byte[1024 * 8];
		out.write(buffer);
		out.close();
	}
	
	@GetMapping("/blogStudyDetail")
	public ModelAndView blogStudyDetail(@RequestParam("blogId") long blogId, @RequestParam("humanId") String humanId) throws Exception{
		
		ModelAndView mv = new ModelAndView();
		BlogDTO blogDTO = blogService.getBlogStudyDetail(blogId);
		List<BlogReplyDTO> blogReplyList = blogReplyService.getBlogReplyList(blogId);
		int allBlogReplyCnt = blogReplyService.getBlogReplyCnt(blogId);
		HumanDTO humanDTO = humanService.getHumanDetail(humanId);
		mv.addObject("blogDTO", blogDTO);
		mv.addObject("allBlogReplyCnt", allBlogReplyCnt);
		mv.addObject("blogReplyList", blogReplyList);
		mv.addObject("humanDTO", humanDTO);
		mv.setViewName("/blog/blogStudyDetail");
		return mv;
		
	}
	
	@GetMapping("/blogDetailPicture1")
	public void blogDetailPicture1(@RequestParam("picture1") String picture1, HttpServletResponse response) throws Exception{
		
		OutputStream out = response.getOutputStream();
		
		File image=new File(FILE_REPO_PATH+picture1);
		if(image.exists()) {
			Thumbnails.of(image).forceSize(750, 350).outputFormat("jpg").toOutputStream(out);
		}
		byte[] buffer = new byte[1024 * 8];
		out.write(buffer);
		out.close();
	}
	
	@GetMapping("/blogDetailPicture2")
	public void blogDetailPicture2(@RequestParam("picture2") String picture2, HttpServletResponse response) throws Exception{
		
		OutputStream out = response.getOutputStream();
		
		File image = new File(FILE_REPO_PATH+picture2);
		if(image.exists()) {
			Thumbnails.of(image).forceSize(360, 350).outputFormat("jpg").toOutputStream(out);
		}
		
		byte[] buffer = new byte[1024*8];
		out.write(buffer);
		out.close();
	}
	
	@GetMapping("/blogDetailPicture3")
	public void blogDetailPicture3(@RequestParam("picture3") String picture3, HttpServletResponse response) throws Exception{
		
		OutputStream out = response.getOutputStream();
		
		File image = new File(FILE_REPO_PATH+picture3);
		if(image.exists()) {
			Thumbnails.of(image).forceSize(360, 350).outputFormat("jpg").toOutputStream(out);
		}
		
		byte[] buffer = new byte[1024*8];
		out.write(buffer);
		out.close();
		
		
	}
	
	@GetMapping("/blogTodayKeyword")
	public ModelAndView blogTodayKeyword() throws Exception{
		
		ModelAndView mv = new ModelAndView();
		List<BlogDTO> blogList = blogService.getBlogKeywordList();
		mv.addObject("blogKeyword", blogList);
		mv.setViewName("/blog/blogTodayKeyword");
		return mv;
		
	}
	
	@GetMapping("/blogKeywordDetail")
	public ModelAndView blogKeywordDetail(@RequestParam("blogId") long blogId, @RequestParam("humanId") String humanId) throws Exception{
		
		ModelAndView mv = new ModelAndView();
		BlogDTO blogDTO = blogService.getBlogKeywordDetail(blogId);
		List<BlogReplyDTO> blogReplyList = blogReplyService.getBlogReplyList(blogId);
		int allBlogReplyCnt = blogReplyService.getBlogReplyCnt(blogId);
		HumanDTO humanDTO = humanService.getHumanDetail(humanId);
		mv.addObject("blogDTO", blogDTO);
		mv.addObject("allBlogReplyCnt", allBlogReplyCnt);
		mv.addObject("blogReplyList", blogReplyList);
		mv.addObject("humanDTO", humanDTO);
		mv.setViewName("/blog/blogKeywordDetail");
		return mv;
		
		
	}
	
	@GetMapping("/blogDayTime")
	public ModelAndView blogDayTime() throws Exception{
		
		ModelAndView mv = new ModelAndView();
		List<BlogDTO> blogList = blogService.getBlogDayTimeList();
		mv.addObject("blogDayTime", blogList);
		mv.setViewName("/blog/blogDayTime");
		
		return mv;
	}
	
	
	@GetMapping("/blogDayTimeDetail")
	public ModelAndView blogDayTimeDetail(@RequestParam("blogId") long blogId, @RequestParam("humanId") String humanId) throws Exception{
		
		ModelAndView mv = new ModelAndView();
		BlogDTO blogDTO = blogService.getBlogDayTimeDetail(blogId);
		List<BlogReplyDTO> blogReplyList = blogReplyService.getBlogReplyList(blogId);
		int allBlogReplyCnt = blogReplyService.getBlogReplyCnt(blogId);
		HumanDTO humanDTO = humanService.getHumanDetail(humanId);
		mv.addObject("blogDTO", blogDTO);
		mv.addObject("allBlogReplyCnt", allBlogReplyCnt);
		mv.addObject("blogReplyList", blogReplyList);
		mv.addObject("humanDTO", humanDTO);
		mv.setViewName("/blog/blogDayTimeDetail");
		
		return mv;
		
		
	}
	
	@GetMapping("/blogTravel")
	public ModelAndView blogTravel() throws Exception{
		
		ModelAndView mv = new ModelAndView();
		List<BlogDTO> blogList = blogService.getBlogTravelList();
		mv.setViewName("/blog/blogTravel");
		mv.addObject("blogTravel", blogList);
		return mv;
		
	}
	
	@GetMapping("/blogTravelDetail")
	public ModelAndView blogTravelDetail(@RequestParam("blogId") long blogId, @RequestParam("humanId") String humanId) throws Exception{
		
		ModelAndView mv = new ModelAndView();
		BlogDTO blogDTO = blogService.getBlogTravelDetail(blogId);
		List<BlogReplyDTO> blogReplyList =  blogReplyService.getBlogReplyList(blogId);
		int allBlogReplyCnt = blogReplyService.getBlogReplyCnt(blogId);
		HumanDTO humanDTO = humanService.getHumanDetail(humanId);
		mv.addObject("blogDTO", blogDTO);
		mv.addObject("allBlogReplyCnt", allBlogReplyCnt);
		mv.addObject("blogReplyList", blogReplyList);
		mv.addObject("humanDTO", humanDTO);
		
		mv.setViewName("/blog/blogTravelDetail");
		
		return mv;
	}
	
	@GetMapping("/blogKeywordUpdate")
	public ModelAndView blogKeywordDetail(@RequestParam("blogId") long blogId) throws Exception{
		
		ModelAndView mv = new ModelAndView();
		BlogDTO blogDTO = blogService.getBlogKeywordDetail(blogId);
		mv.addObject("blogDTO", blogDTO);
		mv.setViewName("/blog/blogKeywordUpdate");
		
		return mv;
	}
	
	@PostMapping("/blogKeywordUpdate")
	public ResponseEntity<Object> blogKeywordUpdate(@RequestParam("blogId") long blogId ,MultipartHttpServletRequest multipartRequest, HttpServletRequest request) throws Exception{
		
		BlogDTO blogDTO = new BlogDTO();
		
		Iterator<String> fileList = multipartRequest.getFileNames();
		String fileName = "";
		String fileName2 = "";
		String fileName3 = "";
		
		while(fileList.hasNext()) {
			for(int i = 1; i<=3; i++) {
				if(i == 1) {
					MultipartFile uploadFile = multipartRequest.getFile(fileList.next());
					if(!uploadFile.getOriginalFilename().isEmpty()) {
						SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");
						fileName = fmt.format(new Date()) + "_" + UUID.randomUUID() + "_" + uploadFile.getOriginalFilename();
						uploadFile.transferTo(new File(FILE_REPO_PATH+fileName));
						blogDTO.setPicture1(fileName);
					}
				}
				
				if(i == 2) {
					MultipartFile uploadFile = multipartRequest.getFile(fileList.next());
					if(!uploadFile.getOriginalFilename().isEmpty()) {
						SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");
						fileName2 = fmt.format(new Date()) + "_" + UUID.randomUUID() + "_" + uploadFile.getOriginalFilename();
						uploadFile.transferTo(new File(FILE_REPO_PATH + fileName2));
						blogDTO.setPicture2(fileName2);
					}
				}
				
				if(i == 3) {
					MultipartFile uploadFile = multipartRequest.getFile(fileList.next());
					if(!uploadFile.getOriginalFilename().isEmpty()) {
						SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");
						fileName3 = fmt.format(new Date()) + "_" + UUID.randomUUID() + "_" + uploadFile.getOriginalFilename();
						uploadFile.transferTo(new File(FILE_REPO_PATH + fileName3));
						blogDTO.setPicture3(fileName3);
					}
				}
			}
		}
		
		blogDTO.setBlogId(blogId);
		blogDTO.setHumanId(multipartRequest.getParameter("humanId"));
		blogDTO.setSubject(multipartRequest.getParameter("subject"));
		blogDTO.setContent(multipartRequest.getParameter("content"));
		blogDTO.setSort(multipartRequest.getParameter("sort"));
		
		blogService.updateBlog(blogDTO);
		
		String message = "<script>";
		message +="alert('정상적으로 변경이 완료되었습니다.');";
		message +="location.href='" + request.getContextPath() + "/blog/blogKeywordDetail?blogId=" + blogDTO.getBlogId() +"&humanId=" + blogDTO.getHumanId() +"';";
		message +="</script>";
		
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		
		return new ResponseEntity<Object>(message,responseHeaders,HttpStatus.OK);
		
	}
	
	@GetMapping("/blogDayTimeUpdate")
	public ModelAndView blogDayTimeUpdate(@RequestParam("blogId") long blogId) throws Exception{
		
		ModelAndView mv = new ModelAndView();
		BlogDTO blogDTO = blogService.getBlogDayTimeDetail(blogId);
		mv.addObject("blogDTO", blogDTO);
		mv.setViewName("/blog/blogDayTimeUpdate");
		
		return mv;
		
	}
	
	@PostMapping("/blogDayTimeUpdate")
	public ResponseEntity<Object> blogDayTimeUpdate(@RequestParam("blogId") long blogId ,MultipartHttpServletRequest multipartRequest, HttpServletRequest request) throws Exception{
		
		BlogDTO blogDTO = new BlogDTO();
		
		Iterator<String> fileList = multipartRequest.getFileNames();
		String fileName = "";
		String fileName2 = "";
		String fileName3 = "";
		
		while(fileList.hasNext()) {
			for(int i = 1; i<=3; i++) {
				if(i == 1) {
					MultipartFile uploadFile = multipartRequest.getFile(fileList.next());
					if(!uploadFile.getOriginalFilename().isEmpty()) {
						SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");
						fileName = fmt.format(new Date()) + "_" + UUID.randomUUID() + "_" + uploadFile.getOriginalFilename();
						uploadFile.transferTo(new File(FILE_REPO_PATH+fileName));
						blogDTO.setPicture1(fileName);
					}
				}
				
				if(i == 2) {
					MultipartFile uploadFile = multipartRequest.getFile(fileList.next());
					if(!uploadFile.getOriginalFilename().isEmpty()) {
						SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");
						fileName2 = fmt.format(new Date()) + "_" + UUID.randomUUID() + "_" + uploadFile.getOriginalFilename();
						uploadFile.transferTo(new File(FILE_REPO_PATH + fileName2));
						blogDTO.setPicture2(fileName2);
					}
				}
				
				if(i == 3) {
					MultipartFile uploadFile = multipartRequest.getFile(fileList.next());
					if(!uploadFile.getOriginalFilename().isEmpty()) {
						SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");
						fileName3 = fmt.format(new Date()) + "_" + UUID.randomUUID() + "_" + uploadFile.getOriginalFilename();
						uploadFile.transferTo(new File(FILE_REPO_PATH + fileName3));
						blogDTO.setPicture3(fileName3);
					}
				}
			}
		}
		
		blogDTO.setBlogId(blogId);
		blogDTO.setHumanId(multipartRequest.getParameter("humanId"));
		blogDTO.setSubject(multipartRequest.getParameter("subject"));
		blogDTO.setContent(multipartRequest.getParameter("content"));
		blogDTO.setSort(multipartRequest.getParameter("sort"));
		
		blogService.updateBlog(blogDTO);
		
		String message = "<script>";
		message +="alert('정상적으로 변경이 완료되었습니다.');";
		message +="location.href='" + request.getContextPath() + "/blog/blogDayTimeDetail?blogId=" + blogDTO.getBlogId() +"&humanId=" + blogDTO.getHumanId() +"';";
		message +="</script>";
		
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		
		return new ResponseEntity<Object>(message,responseHeaders,HttpStatus.OK);
		
		
	}
	
	@GetMapping("/blogStudyUpdate")
	public ModelAndView blogStudyUpdate(@RequestParam("blogId") long blogId) throws Exception{
		
		ModelAndView mv = new ModelAndView();
		BlogDTO blogDTO = blogService.getBlogStudyDetail(blogId);
		mv.addObject("blogDTO", blogDTO);
		mv.setViewName("/blog/blogStudyUpdate");
		
		return mv;
		
	}
	
	@PostMapping("/blogStudyUpdate")
	public ResponseEntity<Object> blogStudyUpdate(@RequestParam("blogId") long blogId ,MultipartHttpServletRequest multipartRequest, HttpServletRequest request) throws Exception{
		
		BlogDTO blogDTO = new BlogDTO();
		
		Iterator<String> fileList = multipartRequest.getFileNames();
		String fileName = "";
		String fileName2 = "";
		String fileName3 = "";
		
		while(fileList.hasNext()) {
			for(int i = 1; i<=3; i++) {
				if(i == 1) {
					MultipartFile uploadFile = multipartRequest.getFile(fileList.next());
					if(!uploadFile.getOriginalFilename().isEmpty()) {
						SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");
						fileName = fmt.format(new Date()) + "_" + UUID.randomUUID() + "_" + uploadFile.getOriginalFilename();
						uploadFile.transferTo(new File(FILE_REPO_PATH+fileName));
						blogDTO.setPicture1(fileName);
					}
				}
				
				if(i == 2) {
					MultipartFile uploadFile = multipartRequest.getFile(fileList.next());
					if(!uploadFile.getOriginalFilename().isEmpty()) {
						SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");
						fileName2 = fmt.format(new Date()) + "_" + UUID.randomUUID() + "_" + uploadFile.getOriginalFilename();
						uploadFile.transferTo(new File(FILE_REPO_PATH + fileName2));
						blogDTO.setPicture2(fileName2);
					}
				}
				
				if(i == 3) {
					MultipartFile uploadFile = multipartRequest.getFile(fileList.next());
					if(!uploadFile.getOriginalFilename().isEmpty()) {
						SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");
						fileName3 = fmt.format(new Date()) + "_" + UUID.randomUUID() + "_" + uploadFile.getOriginalFilename();
						uploadFile.transferTo(new File(FILE_REPO_PATH + fileName3));
						blogDTO.setPicture3(fileName3);
					}
				}
			}
		}
		
		blogDTO.setBlogId(blogId);
		blogDTO.setHumanId(multipartRequest.getParameter("humanId"));
		blogDTO.setSubject(multipartRequest.getParameter("subject"));
		blogDTO.setContent(multipartRequest.getParameter("content"));
		blogDTO.setSort(multipartRequest.getParameter("sort"));
		
		blogService.updateBlog(blogDTO);
		
		String message = "<script>";
		message +="alert('정상적으로 변경이 완료되었습니다.');";
		message +="location.href='" + request.getContextPath() + "/blog/blogStudyDetail?blogId=" + blogDTO.getBlogId() +"&humanId=" + blogDTO.getHumanId() +"';";
		message +="</script>";
		
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		
		return new ResponseEntity<Object>(message,responseHeaders,HttpStatus.OK);
		
		
	}
	
	@GetMapping("/blogTravelUpdate")
	public ModelAndView blogTravelUpdate(@RequestParam("blogId") long blogId) throws Exception{
		
		ModelAndView mv = new ModelAndView();
		BlogDTO blogDTO = blogService.getBlogStudyDetail(blogId);
		mv.addObject("blogDTO", blogDTO);
		mv.setViewName("/blog/blogTravelUpdate");
		
		return mv;
		
	}
	
	@PostMapping("/blogTravelUpdate")
	public ResponseEntity<Object> blogTravelUpdate(@RequestParam("blogId") long blogId ,MultipartHttpServletRequest multipartRequest, HttpServletRequest request) throws Exception{
		
		BlogDTO blogDTO = new BlogDTO();
		
		Iterator<String> fileList = multipartRequest.getFileNames();
		String fileName = "";
		String fileName2 = "";
		String fileName3 = "";
		
		while(fileList.hasNext()) {
			for(int i = 1; i<=3; i++) {
				if(i == 1) {
					MultipartFile uploadFile = multipartRequest.getFile(fileList.next());
					if(!uploadFile.getOriginalFilename().isEmpty()) {
						SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");
						fileName = fmt.format(new Date()) + "_" + UUID.randomUUID() + "_" + uploadFile.getOriginalFilename();
						uploadFile.transferTo(new File(FILE_REPO_PATH+fileName));
						blogDTO.setPicture1(fileName);
					}
				}
				
				if(i == 2) {
					MultipartFile uploadFile = multipartRequest.getFile(fileList.next());
					if(!uploadFile.getOriginalFilename().isEmpty()) {
						SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");
						fileName2 = fmt.format(new Date()) + "_" + UUID.randomUUID() + "_" + uploadFile.getOriginalFilename();
						uploadFile.transferTo(new File(FILE_REPO_PATH + fileName2));
						blogDTO.setPicture2(fileName2);
					}
				}
				
				if(i == 3) {
					MultipartFile uploadFile = multipartRequest.getFile(fileList.next());
					if(!uploadFile.getOriginalFilename().isEmpty()) {
						SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");
						fileName3 = fmt.format(new Date()) + "_" + UUID.randomUUID() + "_" + uploadFile.getOriginalFilename();
						uploadFile.transferTo(new File(FILE_REPO_PATH + fileName3));
						blogDTO.setPicture3(fileName3);
					}
				}
			}
		}
		
		blogDTO.setBlogId(blogId);
		blogDTO.setHumanId(multipartRequest.getParameter("humanId"));
		blogDTO.setSubject(multipartRequest.getParameter("subject"));
		blogDTO.setContent(multipartRequest.getParameter("content"));
		blogDTO.setSort(multipartRequest.getParameter("sort"));
		
		blogService.updateBlog(blogDTO);
		
		String message = "<script>";
		message +="alert('정상적으로 변경이 완료되었습니다.');";
		message +="location.href='" + request.getContextPath() + "/blog/blogTravelDetail?blogId=" + blogDTO.getBlogId() +"&humanId=" + blogDTO.getHumanId() +"';";
		message +="</script>";
		
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		
		return new ResponseEntity<Object>(message,responseHeaders,HttpStatus.OK);
		
		
	}
	
	@GetMapping("/blogKeywordDelete")
	public ModelAndView blogKeywordDelete(@RequestParam("blogId") long blogId) throws Exception{
		
		ModelAndView mv = new ModelAndView();
		BlogDTO blogDTO = blogService.getBlogStudyDetail(blogId);
		mv.addObject("blogDTO", blogDTO);
		mv.setViewName("/blog/blogKeywordDelete");
		
		return mv;
		
		
	}
	
	@PostMapping("/blogKeywordDelete")
	public ResponseEntity<Object> blogKeywordDelete(BlogDTO blogDTO, HttpServletRequest request) throws Exception{
		
		
		blogService.blogKeywordDelete(blogDTO);
		
		String message = "<script>";
		message +="alert('정상적으로 삭제가 완료되었습니다.');";
		message +="location.href='" + request.getContextPath() + "/';";
		message +="</script>";
		
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		
		return new ResponseEntity<Object>(message,responseHeaders,HttpStatus.OK);
		
		
	}
	
	@GetMapping("/blogDayTimeDelete")
	public ModelAndView blogDayTimeDelete(@RequestParam("blogId") long blogId) throws Exception{
		
		ModelAndView mv = new ModelAndView();
		BlogDTO blogDTO = blogService.getBlogDayTimeDetail(blogId);
		mv.addObject("blogDTO", blogDTO);
		mv.setViewName("/blog/blogDayTimeDelete");
		
		return mv;
		
	}
	
	@PostMapping("/blogDayTimeDelete")
	public ResponseEntity<Object> blogDayTimeDelete(BlogDTO blogDTO, HttpServletRequest request) throws Exception{
		
		blogService.blogDayTimeDelete(blogDTO);
		
		String message = "<script>";
		message +="alert('정상적으로 삭제가 완료되었습니다.');";
		message +="location.href='" + request.getContextPath() +"/';";
		message +="</script>";
		
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		
		return new ResponseEntity<Object>(message, responseHeaders, HttpStatus.OK);
		
	}
	
	@GetMapping("/blogStudyDelete")
	public ModelAndView blogStudyDelete(@RequestParam("blogId") long blogId) throws Exception{
		
		ModelAndView mv = new ModelAndView();
		BlogDTO blogDTO = blogService.getBlogStudyDetail(blogId);
		mv.addObject("blogDTO", blogDTO);
		mv.setViewName("/blog/blogStudyDelete");
		
		return mv;
	}
	
	@PostMapping("/blogStudyDelete")
	public ResponseEntity<Object> blogStudyDelete(BlogDTO blogDTO, HttpServletRequest request) throws Exception{
		
		
		blogService.blogStudyDelete(blogDTO);
		
		String message = "<script>";
		message +="alert('정상적으로 삭제가 완료되었습니다.');";
		message +="location.href='" + request.getContextPath() +"/';";
		message +="</script>";
		
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		
		return new ResponseEntity<Object>(message, responseHeaders, HttpStatus.OK);
	}
	
	@GetMapping("/blogTravelDelete")
	public ModelAndView blogTravelDelete(@RequestParam("blogId") long blogId) throws Exception{
		
		ModelAndView mv = new ModelAndView();
		BlogDTO blogDTO = blogService.getBlogTravelDetail(blogId);
		mv.addObject("blogDTO", blogDTO);
		mv.setViewName("/blog/blogTravelDelete");
		
		return mv;
	}
	
	@PostMapping("/blogTravelDelete")
	public ResponseEntity<Object> blogTravelDelete(BlogDTO blogDTO, HttpServletRequest request) throws Exception{
		
		blogService.blogTravelDelete(blogDTO);
		
		String message = "<script>";
		message +="alert('정상적으로 삭제가 완료되었습니다.');";
		message +="location.href='" + request.getContextPath() +"/';";
		message +="</script>";
		
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		
		return new ResponseEntity<Object>(message, responseHeaders, HttpStatus.OK);
		
	}
	
	
	
}
