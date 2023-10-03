package com.application.blogJS.career.service;

import java.util.List;

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

	@Override
	public List<CareerDTO> getCareerList() throws Exception {
		return careerDAO.getCareerList();
	}

	@Override
	public CareerDTO getcareerDetail(long careerId) throws Exception {
		return careerDAO.getcareerDetail(careerId);
	}

	@Override
	public void careerUpdate(CareerDTO careerDTO) throws Exception {
		careerDAO.careerUpdate(careerDTO);
		
	}
	
}
