package com.application.blogJS.career.service;


import java.util.List;

import com.application.blogJS.career.dto.CareerDTO;


public interface CareerService {
	
	public void insertCareerData(CareerDTO careerDTO) throws Exception;
	public List<CareerDTO> getCareerList() throws Exception;
}
