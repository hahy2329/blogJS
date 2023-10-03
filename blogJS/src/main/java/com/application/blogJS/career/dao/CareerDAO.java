package com.application.blogJS.career.dao;

import java.util.List;

import com.application.blogJS.career.dto.CareerDTO;

public interface CareerDAO {

	public void insertCareerData(CareerDTO careerDTO) throws Exception;
	public List<CareerDTO> getCareerList() throws Exception;
	public CareerDTO getcareerDetail(long careerId) throws Exception;
	public void careerUpdate(CareerDTO careerDTO) throws Exception;
	
}
