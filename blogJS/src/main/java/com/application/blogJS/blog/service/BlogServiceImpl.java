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



	@Override
	public BlogDTO getBlogDayTimeDetail(long blogId) throws Exception {
		return blogDAO.getBlogDayTimeDetail(blogId);
	}



	@Override
	public List<BlogDTO> getblogTravelList() throws Exception {
		return blogDAO.getblogTravelList();
	}



	@Override
	public BlogDTO getBlogTravelDetail(long blogId) throws Exception {
		return blogDAO.getBlogTravelDetail(blogId);
	}



	@Override
	public void updateKeywordBlog(BlogDTO blogDTO) throws Exception {
		blogDAO.updateKeywordBlog(blogDTO);
		
	}



	@Override
	public void blogKeywordDelete(BlogDTO blogDTO) throws Exception {
		blogDAO.blogKeywordDelete(blogDTO);
		
	}



	@Override
	public void blogDayTimeDelete(BlogDTO blogDTO) throws Exception {
		blogDAO.blogDayTimeDelete(blogDTO);
		
	}



	@Override
	public void blogStudyDelete(BlogDTO blogDTO) throws Exception {
		blogDAO.blogStudyDelete(blogDTO);
		
	}



	@Override
	public void blogTravelDelete(BlogDTO blogDTO) throws Exception {
		blogDAO.blogTravelDelete(blogDTO);

	}



	

}
