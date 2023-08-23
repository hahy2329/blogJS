package com.application.blogJS.blogReply.service;

import java.util.List;

import com.application.blogJS.blogReply.dto.BlogReplyDTO;

public interface BlogReplyService {
	
	public void uploadStudyBlogReply(BlogReplyDTO blogReplyDTO) throws Exception;
	public int getBlogReplyCnt(long blogId) throws Exception;
	public List<BlogReplyDTO> getBlogReplyList(long blogId) throws Exception;
}
