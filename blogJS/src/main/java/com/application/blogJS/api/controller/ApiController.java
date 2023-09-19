package com.application.blogJS.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;

import org.xml.sax.SAXException;




@Controller
@RequestMapping("/api")
public class ApiController {
	
	
	@GetMapping("/apiList")
	public ModelAndView apiList() throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/api/apiList");
		return mv;
		
	}
	
	@GetMapping("/openAPIPharmacyTest01")
	public ModelAndView openAPIPharmacyTest01() throws Exception{
		
		        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/B551182/pharmacyInfoService/getParmacyBasisList"); /*URL*/
		        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=6RRCCWB0tUHXuCvJnGg5rBiMZgqAFUZtkQ9QE0CPn7SckD7nu3A4OIzwEnktBAr9j99adkuMsFoOKAIRxIDMwQ%3D%3D"); /*Service Key*/
		        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지 번호*/
		        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과 수*/
		        urlBuilder.append("&" + URLEncoder.encode("sidoCd","UTF-8") + "=" + URLEncoder.encode("110000", "UTF-8")); /*시도코드*/
		        urlBuilder.append("&" + URLEncoder.encode("sgguCd","UTF-8") + "=" + URLEncoder.encode("110019", "UTF-8")); /*시군구코드*/
		        urlBuilder.append("&" + URLEncoder.encode("emdongNm","UTF-8") + "=" + URLEncoder.encode("신내동", "UTF-8")); /*읍면동명*/
		        urlBuilder.append("&" + URLEncoder.encode("yadmNm","UTF-8") + "=" + URLEncoder.encode("온누리건강", "UTF-8")); /*병원명*/
		        urlBuilder.append("&" + URLEncoder.encode("xPos","UTF-8") + "=" + URLEncoder.encode("127.0965441345503", "UTF-8")); /*x좌표*/
		        urlBuilder.append("&" + URLEncoder.encode("yPos","UTF-8") + "=" + URLEncoder.encode("37.60765568913871", "UTF-8")); /*y좌표*/
		        urlBuilder.append("&" + URLEncoder.encode("radius","UTF-8") + "=" + URLEncoder.encode("3000", "UTF-8")); /*반경*/
		        
		        URL url = new URL(urlBuilder.toString()); //
		        HttpURLConnection conn = (HttpURLConnection) url.openConnection(); //httpurl을 get방식으로 확인하겠다.
		        conn.setRequestMethod("GET");
		        conn.setRequestProperty("Content-type", "application/json");
		        System.out.println("Response code: " + conn.getResponseCode());
		        BufferedReader rd;
		        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
		            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		        } else {
		            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		        }
		        StringBuilder sb = new StringBuilder();
		        String line;
		        while ((line = rd.readLine()) != null) {
		            sb.append(line);
		        }
		        rd.close();
		        conn.disconnect();
		        System.out.println(sb.toString());
		        
		        ModelAndView mv = new ModelAndView();
		        mv.setViewName("/api/openAPIPharmacyTest01");
		        return mv;
		
		}
	
	@GetMapping("/openAPIPharmacyTest02")
	//건강보험심사평가원_약국정보를 파싱하기
	//위에서 URL을 통해서 접속하고 XML정보를 가져온 후 Parser로 원하는 정보를 추출해보자 
	public ModelAndView openAPIPharmacyTest02() throws Exception{
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			
			//파싱할 InputStream생성
			//1. 웹서비스를 제공하는 url에 연결해서 데이터를 가져오기 
			//1) 접속할 URL의 정보를 정의 
			StringBuffer pharm_url = new StringBuffer();
			pharm_url.append("http://apis.data.go.kr/B551182/pharmacyInfoService/getParmacyBasisList");
			pharm_url.append("?ServiceKey=6RRCCWB0tUHXuCvJnGg5rBiMZgqAFUZtkQ9QE0CPn7SckD7nu3A4OIzwEnktBAr9j99adkuMsFoOKAIRxIDMwQ%3D%3D");
			
			//2) 웹서버에 접속하기
			URL url = new URL(pharm_url.toString()); // -> 여기 문장은 사이트 접속하는 구간
			
			//3)접속해서 response되는 데이터를 읽어오기
			//읽어온 데이터를 저장 - BufferedInputStream은 InputStream의 하위
			BufferedInputStream xmlData = new BufferedInputStream(url.openStream());
			System.out.println(url.openStream()); //url의 객체 주소를 반환해줄 것임
			
			Document document = builder.parse(xmlData); //InputStream객체의 형태로 파싱할 정보를 넘겨준다.
			Element root = document.getDocumentElement();
			System.out.println(root.getTagName()); // 위의 url주소를 입력한 후 검색하면 response태그가 나오고 그 아래 header, body부분의 내용들이 나온다.
												   // 현재 출력을 하면 response가 나올거다.
			
			NodeList list = root.getElementsByTagName("item");
			System.out.println(list.getLength());
			for(int i=0; i<list.getLength(); i++) {
				Node node = list.item(i);
				NodeList item_childList = node.getChildNodes();
				for(int j=0; j<item_childList.getLength(); j++) {
					Node item_child = item_childList.item(j);
					System.out.print(item_child.getNodeName()+":" + item_child.getTextContent());	
				}
				System.out.println();
			}
			
		}catch (ParserConfigurationException e) {
			e.printStackTrace();
		}catch (SAXException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/api/openAPIPharmacyTest02");
		return mv;
		
	}
	
	@GetMapping("/openAPIMidFcstTest01")
	public ModelAndView openAPIMidFcstTest01() throws Exception{
		
		StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1360000/MidFcstInfoService/getMidFcst"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=6RRCCWB0tUHXuCvJnGg5rBiMZgqAFUZtkQ9QE0CPn7SckD7nu3A4OIzwEnktBAr9j99adkuMsFoOKAIRxIDMwQ%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과 수*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
        urlBuilder.append("&" + URLEncoder.encode("stnId","UTF-8") + "=" + URLEncoder.encode("108", "UTF-8")); /*108 전국, 109 서울, 인천, 경기도 등 (활용가이드 하단 참고자료 참조)*/
        urlBuilder.append("&" + URLEncoder.encode("tmFc","UTF-8") + "=" + URLEncoder.encode("202309190600", "UTF-8")); /*-일 2회(06:00,18:00)회 생성 되며 발표시각을 입력 YYYYMMDD0600 (1800)-최근 24시간 자료만 제공*/
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        System.out.println(sb.toString());
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/api/openAPIMidFcstTest01");
		return mv;
		
	}
	
	@GetMapping("/openAPIMidFcstTest02")
	//기상청_중기예보 정보를 파싱하기 
	public ModelAndView openAPIMidFcstTest02() throws Exception{
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
		try {
			
			DocumentBuilder builder = factory.newDocumentBuilder();
			
			//파싱할 InputStream 생성 
			//1. 웹서비스를 제공하는 url에 연결해서 데이터를 가져오기.
			//1) 접속할 url의 정보를 정의 
			
			StringBuffer pharm_url = new StringBuffer();
			
			pharm_url.append("http://apis.data.go.kr/1360000/MidFcstInfoService/getMidFcst");
			pharm_url.append("?serviceKey=6RRCCWB0tUHXuCvJnGg5rBiMZgqAFUZtkQ9QE0CPn7SckD7nu3A4OIzwEnktBAr9j99adkuMsFoOKAIRxIDMwQ%3D%3D");
			pharm_url.append("&numOfRows=10&pageNo=1&stnId=133&tmFc=202309190600");
			
			
			//2)웹서버에 접속하기 
			URL url = new URL(pharm_url.toString());
			
			//3)접속해서 response되는 데이터를 읽어오기 
			//읽어온 데이터를 저장  - BufferedInputStream은 InputStream의 하위 
			BufferedInputStream xmlData = new BufferedInputStream(url.openStream());
			System.out.println(url.openStream()); //url의 객체 주소를 반환 
			
			Document document = builder.parse(xmlData); //InputStream객체의 형태로 파싱할 정보를 넘겨준다.
			Element root = document.getDocumentElement();
			System.out.println(root.getTagName());
			//위의 url주소를 입력한 후 검색하면 response태그가 나오고 그 아래 header, body부분의 내용들이 나온다.
			//현재 시점에서 출력하면 response가 나올것이다.
			
			NodeList list = root.getElementsByTagName("item");
			System.out.println(list.getLength());
			for(int i=0; i<list.getLength(); i++) {
				Node node = list.item(i);
				NodeList item_childList = node.getChildNodes();
				for(int j=0; j<item_childList.getLength(); j++) {
					
					Node item_child = item_childList.item(j);
					System.out.println(item_child.getNodeName() + " : " + item_child.getTextContent());
				}
				System.out.println();
			}
			
			
			
			
		}catch(ParserConfigurationException e) {
			e.printStackTrace();
		}catch(SAXException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/api/openAPIMidFcstTest02");
		return mv;
		
		
	}
	
	@GetMapping("/openAPIPrecipitationTest01")
	public ModelAndView openAPIPrecipitationTest01() throws Exception{
		
		StringBuilder urlBuilder = new StringBuilder("https://apis.data.go.kr/1360000/MidFcstInfoService/getMidLandFcst");
		urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") +"=6RRCCWB0tUHXuCvJnGg5rBiMZgqAFUZtkQ9QE0CPn7SckD7nu3A4OIzwEnktBAr9j99adkuMsFoOKAIRxIDMwQ%3D%3D");
		urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "=" + URLEncoder.encode("10", "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("regId", "UTF-8") + "=" + URLEncoder.encode("11B00000","UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("tmFc", "UTF-8") + "=" +URLEncoder.encode("202309190600", "UTF-8"));
		
		URL url = new URL(urlBuilder.toString());
		HttpURLConnection conn = (HttpURLConnection)url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/json");
		System.out.println("Response code : " + conn.getResponseCode());
		BufferedReader rd; 
		
		if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
			
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		}
		else {
			rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		}
		
		StringBuilder sb = new StringBuilder();
		String line;
		while((line= rd.readLine()) != null) {
			sb.append(line);
		}
		
		rd.close();
		conn.disconnect();
		System.out.println(sb.toString());
		
		
		
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/api/openAPIPrecipitationTest01");
		return mv;
		
	}
	
	@GetMapping("/openAPIPrecipitationTest02")
	public ModelAndView openAPIPrecipitationTest02() throws Exception{
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
		try {
			
			DocumentBuilder builder = factory.newDocumentBuilder();
			
			//파싱할 InputStream 생성 
			//1. 웹서비스를 제공하는 url에 연결해서 데이터를 가져오기.
			//1) 접속할 url의 정보를 정의 
			
			StringBuffer pharm_url = new StringBuffer();
			
			pharm_url.append("https://apis.data.go.kr/1360000/MidFcstInfoService/getMidLandFcst");
			pharm_url.append("?serviceKey=6RRCCWB0tUHXuCvJnGg5rBiMZgqAFUZtkQ9QE0CPn7SckD7nu3A4OIzwEnktBAr9j99adkuMsFoOKAIRxIDMwQ%3D%3D");
		}
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/api/openAPIPrecipitationTest02");
		return mv;
		
	}
		
	
	
}


