package com.application.blogJS.blog.dao;

import java.util.List;

import com.application.blogJS.blog.dto.BlogDTO;

public interface BlogDAO {
	
	public List<BlogDTO> getBlogStudyList() throws Exception;
	
}
