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
	public void uploadBlogReply(BlogReplyDTO blogReplyDTO) throws Exception {
		blogReplyDAO.uploadBlogReply(blogReplyDTO);
	

	}



	@Override
	public int getBlogReplyCnt(long blogId) throws Exception {
		return blogReplyDAO.getBlogReplyCnt(blogId);
	}



	@Override
	public List<BlogReplyDTO> getBlogReplyList(long blogId) throws Exception {
		return blogReplyDAO.getBlogReplyList(blogId);
	}



	@Override
	public BlogReplyDTO getBlogReplyDetail(long replyId) throws Exception {
		return blogReplyDAO.getBlogReplyDetail(replyId);
	}



	@Override
	public void blogReplyUpdate(BlogReplyDTO blogReplyDTO) throws Exception {
		 blogReplyDAO.blogReplyUpdate(blogReplyDTO);
		
	}



	@Override
	public void blogReplyRemove(BlogReplyDTO blogReplyDTO) throws Exception {
		blogReplyDAO.blogReplyRemove(blogReplyDTO);
		
	}

}
