package com.application.blogJS.blog.service;

import java.util.List;

import com.application.blogJS.blog.dto.BlogDTO;


public interface BlogService {
	
	public List<BlogDTO> getBlogStudyList() throws Exception;
	public void insertBlog(BlogDTO blogDTO) throws Exception;
	public BlogDTO getBlogStudyDetail(long blogId) throws Exception;
	public List<BlogDTO> getBlogKeywordList() throws Exception;
	public BlogDTO getBlogKeywordDetail(long blogId) throws Exception;
	public List<BlogDTO> getblogDayTimeList() throws Exception;
	public BlogDTO getBlogDayTimeDetail(long blogId) throws Exception;
	public List<BlogDTO> getblogTravelList() throws Exception;
	public BlogDTO getBlogTravelDetail(long blogId) throws Exception;
	public void updateKeywordBlog(BlogDTO blogDTO) throws Exception;
	public void blogKeywordDelete(BlogDTO blogDTO) throws Exception;
	
}
