package com.application.blogJS.human.controller;

import java.io.File;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

import com.application.blogJS.human.dto.HumanDTO;
import com.application.blogJS.human.service.HumanService;


import net.coobird.thumbnailator.Thumbnails;

@Controller
@RequestMapping("/human")
public class HumanController {
	
	
	private String FILE_REPO_PATH = "C:\\spring_file_repo_path\\";
	
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
		
		return new ResponseEntity<String>(humanService.checkDuplicatedId(humanId), HttpStatus.OK);
	}
	
	@GetMapping("/overlappedEmail")
	public ResponseEntity<String> overlappedEmail(@RequestParam("email") String email) throws Exception{
		
		return new ResponseEntity<String>(humanService.checkDuplicatedEmail(email), HttpStatus.OK);
		
	}
	
	
	@PostMapping("/register")
	public ResponseEntity<Object> register(MultipartHttpServletRequest multipartRequest , HttpServletRequest request) throws Exception{
		
		Iterator<String> fileList = multipartRequest.getFileNames();
		String fileName="";
		if(fileList.hasNext()) {
			
			MultipartFile uploadFile = multipartRequest.getFile(fileList.next());
			if(!uploadFile.getOriginalFilename().isEmpty()) {
				SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");
				fileName = fmt.format(new Date())+"_" + UUID.randomUUID() + "_" + uploadFile.getOriginalFilename();
				uploadFile.transferTo(new File(FILE_REPO_PATH+fileName));
						
				
			}
			
		}
		
		HumanDTO humanDTO = new HumanDTO();
		humanDTO.setHumanId(multipartRequest.getParameter("humanId"));
		humanDTO.setPasswd(multipartRequest.getParameter("passwd"));
		humanDTO.setHumanNm(multipartRequest.getParameter("humanNm"));
		humanDTO.setEmail(multipartRequest.getParameter("email"));
		humanDTO.setProfile(fileName);
		humanDTO.setContent(multipartRequest.getParameter("content"));
		humanDTO.setBirthDt(multipartRequest.getParameter("birthDt"));
		
		
		
		
		humanService.addHuman(humanDTO);
		
		String message = "<script>";
		message +="alert('가입이 완료되었습니다.');";
		message +="location.href='"+request.getContextPath()+"/';";
		message +="</script>";
		
		HttpHeaders responseheaders = new HttpHeaders();
		responseheaders.add("Content-Type", "text/html; charset=utf-8");
		
		return new ResponseEntity<Object>(message, responseheaders, HttpStatus.OK);
		
	}
	
	@GetMapping("/login")
	public ModelAndView login() throws Exception{
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/human/login");
		return mv;
		
	}
	
	@PostMapping("/login")
	public ResponseEntity<Object> login(HumanDTO humanDTO, HttpServletRequest request) throws Exception{
		
		if(humanService.loginCheck(humanDTO)) {
			
			HttpSession session = request.getSession();
			session.setAttribute("humanId", humanDTO.getHumanId());
			session.setMaxInactiveInterval(3600);
			
			String message = "<script>";
			message+= "alert('로그인 되었습니다.');";
			message+="location.href='" + request.getContextPath() +"/';";
			message +="</script>";
			
			HttpHeaders responseheaders = new HttpHeaders();
			responseheaders.add("Content-Type", "text/html; charset=utf-8");
			
			return new ResponseEntity<Object>(message, responseheaders, HttpStatus.OK);
			
		}
		
		else {
			
			String message = "<script>";
			message+= "alert('아이디 및 비밀번호를 다시 확인해주세요.');";
			message+="history.go(-1)";
			message +="</script>";
			
			HttpHeaders responseheaders = new HttpHeaders();
			responseheaders.add("Content-Type", "text/html; charset=utf-8");
			
			return new ResponseEntity<Object>(message, responseheaders, HttpStatus.OK);
			
		}
		
		
		
	}
	
	@GetMapping("/logout")
	public ResponseEntity<Object> logout(HttpServletRequest request)throws Exception{
		
		HttpSession session = request.getSession();
		session.invalidate();
		
		
		String message = "<script>";
		message +="alert('로그아웃 되었습니다.');";
		message +="location.href='"+request.getContextPath() + "/';";
		message +="</script>";
		
		HttpHeaders responseheaders = new HttpHeaders();
		responseheaders.add("Content-Type", "text/html; charset=utf-8");
		
		return new ResponseEntity<Object>(message, responseheaders, HttpStatus.OK);
		
		
		
	}
	
	@GetMapping("/checkDuplicatedPasswd")
	public ResponseEntity<String> checkDuplicatedPasswd(@RequestParam("passwd") String passwd, @RequestParam("humanId") String humanId) throws Exception{
		
		return new ResponseEntity<String>(humanService.checkDuplicatedPasswd(passwd, humanId), HttpStatus.OK);
		
		
	}
	
	
	@GetMapping("/thumbnails")
	public void thumbnails(@RequestParam("profile") String profile, HttpServletResponse response) throws Exception{
		
		OutputStream out = response.getOutputStream();
		
		File image = new File(FILE_REPO_PATH+profile);
		if(image.exists()) {
			Thumbnails.of(image).forceSize(120, 120).outputFormat("jpg").toOutputStream(out);
		}
		byte[] buffer = new byte[1024*8];
		out.write(buffer);
		out.close();
	}
	
	@GetMapping("/thumbnails2")
	public void thumbnails2(@RequestParam("profile2") String profile2, HttpServletResponse response) throws Exception{
		
		OutputStream out = response.getOutputStream();
		
		File image = new File(FILE_REPO_PATH+profile2);
		if(image.exists()) {
			Thumbnails.of(image).forceSize(60, 60).outputFormat("jpg").toOutputStream(out);
		}
		byte[] buffer = new byte[1024*8];
		out.write(buffer);
		out.close();
	}
	
	@GetMapping("/informationUpdate")
	public ModelAndView informationUpdate(@RequestParam("humanId") String humanId) throws Exception{
		
		ModelAndView mv = new ModelAndView();
		HumanDTO humanDTO = humanService.getHumanDetail(humanId);
		mv.addObject("humanDTO", humanDTO);
		mv.setViewName("/human/informationUpdate");
		
		return mv;
	}
	
	@PostMapping("/informationUpdate")
	public ResponseEntity<Object> informationUpdate(MultipartHttpServletRequest multipartRequest, HttpServletRequest request) throws Exception{
		
		Iterator<String> fileList = multipartRequest.getFileNames();
		String fileName="";
		if(fileList.hasNext()) {
			
			MultipartFile uploadFile = multipartRequest.getFile(fileList.next());
			if(!uploadFile.getOriginalFilename().isEmpty()) {
				SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");
				fileName = fmt.format(new Date())+"_" + UUID.randomUUID() + "_" + uploadFile.getOriginalFilename();
				uploadFile.transferTo(new File(FILE_REPO_PATH+fileName));
						
				
			}
			
		}
		
		
		HumanDTO humanDTO = new HumanDTO();
		
		humanDTO.setHumanId(multipartRequest.getParameter("humanId"));
		humanDTO.setPasswd(multipartRequest.getParameter("passwd"));
		humanDTO.setHumanNm(multipartRequest.getParameter("humanNm"));
		humanDTO.setEmail(multipartRequest.getParameter("email"));
		humanDTO.setProfile(fileName);
		humanDTO.setContent(multipartRequest.getParameter("content"));
		humanDTO.setBirthDt(multipartRequest.getParameter("birthDt"));
		
		humanService.informationUpdate(humanDTO);
		
		String message = "<script>";
		message +="alert('정상적으로 수정 되었습니다.');";
		message +="location.href='" + request.getContextPath() +"/';";
		message +="</script>";
		
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		
		return new ResponseEntity<Object>(message, responseHeaders, HttpStatus.OK);
		
	}
	
	@GetMapping("/passwordChange")
	public ModelAndView passwordChange(@RequestParam("humanId") String humanId) throws Exception{
		
		ModelAndView mv = new ModelAndView();
		HumanDTO humanDTO = humanService.getHumanDetail(humanId);
		mv.addObject("humanDTO", humanDTO);
		mv.setViewName("/human/passwordChange");
		
		return mv;
		
	}
	
	@PostMapping("/passwordChange")
	public ResponseEntity<Object> passwordChange(HumanDTO humanDTO, @RequestParam("changePasswd") String changePasswd, HttpServletRequest request) throws Exception{
		
		String message="";
		
		if(humanService.passwordChange(humanDTO, changePasswd)) {
			
			HttpSession session = request.getSession();
			session.invalidate();
			
			message = "<script>";
			message +="alert('정상적으로 변경 되었습니다.');";
			message +="location.href='" + request.getContextPath() +"/';";
			message +="</script>";
			
				
		}
		else {
			
			message ="<script>";
			message +="alert('비밀번호를 다시 확인해주세요.');";
			message +="history.go(-1)";
			message +="</script>";
			
		}
		
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		
		return new ResponseEntity<Object>(message, responseHeaders, HttpStatus.OK);
		
		
	}
	
	@GetMapping("/humanDelete")
	public ModelAndView humanDelete(@RequestParam("humanId") String humanId) throws Exception{
		
		ModelAndView mv = new ModelAndView();
		HumanDTO humanDTO = humanService.getHumanDetail(humanId);
		mv.addObject("humanDTO", humanDTO);
		mv.setViewName("/human/humanDelete");
		
		return mv;
		
		
	}
	
	@PostMapping("/humanDelete")
	public ResponseEntity<Object> humanDelete(HumanDTO humanDTO, HttpServletRequest request) throws Exception{
		
		humanService.humanDelete(humanDTO);
		
		HttpSession session = request.getSession();
		session.invalidate();
		
		String message = "<script>";
		message +="alert('정상적으로 탈퇴가 되었습니다.');";
		message +="location.href='" + request.getContextPath() + "/';";
		message +="</script>";
		
		
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		
		return new ResponseEntity<Object>(message, responseHeaders, HttpStatus.OK);
	}
	
	
	
}
