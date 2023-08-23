package com.application.blogJS.blogReply.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.blogJS.blogReply.dao.BlogReplyDAO;
import com.application.blogJS.blogReply.dto.BlogReplyDTO;

@Service
public class BlogReplyServiceImpl implements BlogReplyService {
	
	@Autowired
	private BlogReplyDAO blogReplyDAO;
	
	
	
	@Override
	public void uploadStudyBlogReply(BlogReplyDTO blogReplyDTO) throws Exception {
		blogReplyDAO.uploadStudyBlogReply(blogReplyDTO);
	

	}



	@Override
	public int getBlogReplyCnt(long blogId) throws Exception {
		return blogReplyDAO.getBlogReplyCnt(blogId);
	}



	@Override
	public List<BlogReplyDTO> getBlogReplyList(long blogId) throws Exception {
		return blogReplyDAO.getBlogReplyList(blogId);
	}

}
