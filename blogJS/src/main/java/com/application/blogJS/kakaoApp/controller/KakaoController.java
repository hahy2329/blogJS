package com.application.blogJS.kakaoApp.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class KakaoController {
	
	KakaoAPI kakaoAPI = new KakaoAPI();
	
	@RequestMapping(value="/login")
	public ModelAndView login(@RequestParam("code") String code, HttpServletRequest request) throws Exception{
		
		ModelAndView mv = new ModelAndView();
		//1번. 인증코드 요청 전달
		// code : 인증코드
		String accessToken = kakaoAPI.getAccessToken(code);
		
		//2번 인증코드로 토큰 전달
		HashMap<String, Object> userInfo = kakaoAPI.getUserInfo(accessToken);
		System.out.println("login info :" + userInfo.toString());
		System.out.println("nickname : " + userInfo.get("nickname"));
		
		
		HttpSession session =  request.getSession();
		
		if(userInfo.get("nickname") != null) {
			session.setAttribute("userId", userInfo.get("nickname"));
			session.setAttribute("accessToken", accessToken);
		}
		
		mv.addObject("userId", userInfo.get("nickname"));
		mv.setViewName("/main");
		
		return mv;
	}
	
	@RequestMapping("/logout")
	public ModelAndView logout(HttpServletRequest request) throws Exception{
		
		HttpSession session = request.getSession();
		ModelAndView mv = new ModelAndView();
		
		kakaoAPI.kakaoLogout((String)session.getAttribute("access_token"));
		session.removeAttribute("accessToken");
		session.removeAttribute("userId");
		
		mv.setViewName("/main");
		return mv;
		
		
	}
	
	
	
}
