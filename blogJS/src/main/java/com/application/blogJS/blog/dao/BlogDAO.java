package com.application.blogJS.blog.dao;

import java.util.List;

import com.application.blogJS.blog.dto.BlogDTO;

public interface BlogDAO {
	
	public List<BlogDTO> getBlogStudyList() throws Exception;
	public void insertBlog(BlogDTO blogDTO) throws Exception;
	public BlogDTO getBlogStudyDetail(long blogId) throws Exception;
	public void increaseReadCnt(long blogId) throws Exception;
	public List<BlogDTO> getBlogKeywordList() throws Exception;
	public BlogDTO getBlogKeywordDetail(long blogId) throws Exception;
}
