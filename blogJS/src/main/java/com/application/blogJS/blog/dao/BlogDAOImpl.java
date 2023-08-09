package com.application.blogJS.blog.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.application.blogJS.blog.dto.BlogDTO;

@Repository
public class BlogDAOImpl implements BlogDAO {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<BlogDTO> getBlogStudyList() throws Exception {
		return sqlSession.selectList("blog.getBlogStudyList");
	}
	
	
	
}
