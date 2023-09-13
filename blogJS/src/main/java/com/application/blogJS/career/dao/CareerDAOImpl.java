package com.application.blogJS.career.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.application.blogJS.career.dto.CareerDTO;

@Repository
public class CareerDAOImpl implements CareerDAO {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void insertCareerData(CareerDTO careerDTO) throws Exception {
		sqlSession.insert("career.insertCareerData", careerDTO);
		
	}

}
