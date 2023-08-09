package com.application.blogJS.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.blogJS.blog.dao.BlogDAO;
import com.application.blogJS.blog.dto.BlogDTO;

@Service
public class BlogServiceImpl implements BlogService {
	
	@Autowired
	private BlogDAO blogDAO;
	
	
	
	@Override
	public List<BlogDTO> getBlogStudyList() throws Exception {
		
		return blogDAO.getBlogStudyList();
		
		
	}

}
