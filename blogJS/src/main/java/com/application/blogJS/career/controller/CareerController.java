package com.application.blogJS.career.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
	public ResponseEntity<Object> careerWrite(HttpServletRequest request) throws Exception{
		
		
		CareerDTO careerDTO = new CareerDTO();
		careerDTO.setCompanyName(request.getParameter("companyName"));
		careerDTO.setDepartment(request.getParameter("department"));
		careerDTO.setHumanId(request.getParameter("humanId"));
		careerDTO.setPeriod(request.getParameter("period"));
		careerDTO.setSkill(request.getParameter("skill"));
		
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		Date joinDt = fmt.parse(request.getParameter("joinDate"));
		Date resignationDt = fmt.parse(request.getParameter("resignationDate"));
		
		careerDTO.setJoinDate(joinDt);
		careerDTO.setResignationDate(resignationDt);
			
		
		careerService.insertCareerData(careerDTO);
		
		
		String message = "<script>";
		message +="alert('정상적으로 등록이 완료되었습니다.');";
		message +="location.href='"+request.getContextPath()+"/';";
		message +="</script>";
		
		HttpHeaders responseheaders = new HttpHeaders();
		responseheaders.add("Content-Type", "text/html; charset=utf-8");
		
		return new ResponseEntity<Object>(message, responseheaders, HttpStatus.OK);
		
	}
	
	@GetMapping("/careerManagement")
	public ModelAndView careerManagement() throws Exception{
		
		ModelAndView mv = new ModelAndView();
		List<CareerDTO> careerList = careerService.getCareerList();
		mv.setViewName("/career/careerManagement");
		mv.addObject("careerList", careerList);
		
		return mv;
	}
	
	@GetMapping("/careerUpdate")
	public ModelAndView careerUpdate(@RequestParam("careerId") long careerId) throws Exception{
		
		ModelAndView mv = new ModelAndView();
		
		CareerDTO careerDTO = careerService.getcareerDetail(careerId);
		mv.addObject("careerDTO", careerDTO);
		mv.setViewName("/career/careerUpdate");
		
		return mv;
		
		
		
		
	}
	
	@PostMapping("/careerUpdate")
	public ResponseEntity<Object> careerUpdate(@RequestParam("careerId") long careerId ,HttpServletRequest request) throws Exception{
		
		CareerDTO careerDTO = new CareerDTO();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Date joinDt = sdf.parse(request.getParameter("joinDate"));
		Date resignationDt = sdf.parse(request.getParameter("resignationDate"));
		
		careerDTO.setCareerId(careerId);
		careerDTO.setCompanyName(request.getParameter("companyName"));
		careerDTO.setDepartment(request.getParameter("department"));
		careerDTO.setHumanId(request.getParameter("humanId"));
		careerDTO.setPeriod(request.getParameter("period"));
		careerDTO.setSkill(request.getParameter("skill"));
		
		careerDTO.setJoinDate(joinDt);
		careerDTO.setResignationDate(resignationDt);
		
		careerService.careerUpdate(careerDTO);
		
		
		String message = "<script>";
		message +="alert('정상적으로 수정이 완료되었습니다.');";
		message +="location.href='" + request.getContextPath() + "/';";
		message +="</script>";
		
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		
		return new ResponseEntity<Object>(message, responseHeaders, HttpStatus.OK);
		
	}
	
	@GetMapping("/careerDelete")
	public ModelAndView careerDelete(@RequestParam("careerId") long careerId) throws Exception{
		
		ModelAndView mv = new ModelAndView();
		
		CareerDTO careerDTO = careerService.getcareerDetail(careerId);
		mv.addObject("careerDTO", careerDTO);
		mv.setViewName("/career/careerDelete");
		
		return mv;
		
	}
	
	@PostMapping("/careerDelete")
	public ResponseEntity<Object> careerDelete(CareerDTO careerDTO, HttpServletRequest request) throws Exception{
		
		
		careerService.careerDelete(careerDTO);
		
		String message = "<script>";
		message +="alert('정상적으로 삭제가 완료되었습니다.');";
		message +="location.href='" + request.getContextPath() +"/';";
		message +="</script>";
		
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		
		return new ResponseEntity<Object>(message, responseHeaders, HttpStatus.OK);
	}
	
	
	
	
}
