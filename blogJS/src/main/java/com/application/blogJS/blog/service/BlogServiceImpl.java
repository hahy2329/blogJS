package com.application.blogJS.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.blogJS.blog.dao.BlogDAO;
import com.application.blogJS.blog.dto.BlogDTO;
import com.application.blogJS.blogReply.dto.BlogReplyDTO;

@Service
public class BlogServiceImpl implements BlogService {
	
	@Autowired
	private BlogDAO blogDAO;
	
	
	
	@Override
	public List<BlogDTO> getBlogStudyList() throws Exception {
		
		return blogDAO.getBlogStudyList();
		
		
	}



	@Override
	public void insertBlog(BlogDTO blogDTO) throws Exception {
		blogDAO.insertBlog(blogDTO);
		
	}



	@Override
	public BlogDTO getBlogStudyDetail(long blogId) throws Exception {
		blogDAO.increaseReadCnt(blogId);
		
		return blogDAO.getBlogStudyDetail(blogId);
	}



	@Override
	public List<BlogDTO> getBlogKeywordList() throws Exception {
		return blogDAO.getBlogKeywordList();
	}



	@Override
	public BlogDTO getBlogKeywordDetail(long blogId) throws Exception {
		return blogDAO.getBlogKeywordDetail(blogId);
	}



	@Override
	public List<BlogDTO> getblogDayTimeList() throws Exception {
		return blogDAO.getblogDayTimeList();
	}



	

}
