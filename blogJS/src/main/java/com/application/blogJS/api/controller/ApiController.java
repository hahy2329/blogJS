package com.application.blogJS.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.io.BufferedReader;
import java.io.IOException;

@Controller
@RequestMapping("/api")
public class ApiController {
	
	@GetMapping("/fineDust")
	public ModelAndView fineDust() throws Exception{
		
		StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/6410000/GOA/GOA001"); //URL
		urlBuilder.append("?"+URLEncoder.encode("serviceKey","UTF-8")+"=6RRCCWB0tUHXuCvJnGg5rBiMZgqAFUZtkQ9QE0CPn7SckD7nu3A4OIzwEnktBAr9j99adkuMsFoOKAIRxIDMwQ%3D%3D");//서비스 키
		urlBuilder.append("&"+URLEncoder.encode("type","UTF-8")+"="+URLEncoder.encode("json","UTF-8")); // 응답결과json
		urlBuilder.append("&"+URLEncoder.encode("numOfRows","UTF-8")+"=" + URLEncoder.encode("10","UTF-8")); // 한 페이지 결과 수 
		urlBuilder.append("&"+URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1","UTF-8")); // 페이지 번호
		
		URL url = new URL(urlBuilder.toString());
		HttpURLConnection conn = (HttpURLConnection)url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/json");
		System.out.println("Response Code: " + conn.getResponseCode());
		BufferedReader rd;
		if(conn.getResponseCode() >=200 && conn.getResponseCode() <= 300) {
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		}
		else {
			rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		}
		
		StringBuilder sb = new StringBuilder();
		String line;
		while((line = rd.readLine())!=null) {
			sb.append(line);
		}
		
		rd.close();
		conn.disconnect();
		System.out.println(sb.toString());
		
		
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/api/fineDust");
		return mv;
	}

}
