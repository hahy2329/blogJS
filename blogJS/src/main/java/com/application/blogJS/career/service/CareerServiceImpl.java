package com.application.blogJS.career.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.blogJS.career.dao.CareerDAO;
import com.application.blogJS.career.dto.CareerDTO;

@Service
public class CareerServiceImpl implements CareerService {

	@Autowired
	private CareerDAO careerDAO;
	
	@Override
	public void insertCareerData(CareerDTO careerDTO) throws Exception {
		careerDAO.insertCareerData(careerDTO);
		
	}
	
}
