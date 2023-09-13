package com.application.blogJS.career.service;

import org.springframework.stereotype.Service;

import com.application.blogJS.career.dto.CareerDTO;


public interface CareerService {
	
	public void insertCareerData(CareerDTO careerDTO) throws Exception;
}
