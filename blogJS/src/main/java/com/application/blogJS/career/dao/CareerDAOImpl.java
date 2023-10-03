package com.application.blogJS.career.dao;

import java.util.List;

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

	@Override
	public List<CareerDTO> getCareerList() throws Exception {
		return sqlSession.selectList("career.getCareerList");
	}

	@Override
	public CareerDTO getcareerDetail(long careerId) throws Exception {
		return sqlSession.selectOne("career.getcareerDetail", careerId);
	}

	@Override
	public void careerUpdate(CareerDTO careerDTO) throws Exception {
		sqlSession.update("career.careerUpdate", careerDTO);
		
	}

}
