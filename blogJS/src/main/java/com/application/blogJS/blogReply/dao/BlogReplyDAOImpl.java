package com.application.blogJS.blogReply.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.application.blogJS.blogReply.dto.BlogReplyDTO;

@Repository
public class BlogReplyDAOImpl implements BlogReplyDAO {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void uploadStudyBlogReply(BlogReplyDTO blogReplyDTO) throws Exception {
		sqlSession.insert("blogReply.uploadStudyReply", blogReplyDTO);

	}

}
