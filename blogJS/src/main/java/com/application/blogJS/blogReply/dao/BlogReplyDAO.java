package com.application.blogJS.blogReply.dao;

import java.util.List;

import com.application.blogJS.blogReply.dto.BlogReplyDTO;

public interface BlogReplyDAO {
	
	public void uploadStudyBlogReply(BlogReplyDTO blogReplyDTO) throws Exception;
	public int getBlogReplyCnt(long blogId) throws Exception;
	public List<BlogReplyDTO> getBlogReplyList(long blogId) throws Exception;
	public BlogReplyDTO getBlogReplyDetail(long replyId) throws Exception;
	public void blogReplyUpdate(BlogReplyDTO blogReplyDTO) throws Exception;
}
