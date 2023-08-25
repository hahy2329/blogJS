package com.application.blogJS.blogReply.dao;

import java.util.List;

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

	@Override
	public int getBlogReplyCnt(long blogId) throws Exception {
		return sqlSession.selectOne("blogReply.getBlogReplyCnt", blogId);
	}

	@Override
	public List<BlogReplyDTO> getBlogReplyList(long blogId) throws Exception {
		return sqlSession.selectList("blogReply.getBlogReplyList", blogId);
	}

	@Override
	public BlogReplyDTO getBlogReplyDetail(long replyId) throws Exception {
		return sqlSession.selectOne("blogReply.getBlogReplyDetail", replyId);
	}

	@Override
	public void blogReplyUpdate(BlogReplyDTO blogReplyDTO) throws Exception {
		sqlSession.update("blogReply.blogReplyUpdate", blogReplyDTO);
		
	}

	@Override
	public void blogReplyRemove(BlogReplyDTO blogReplyDTO) throws Exception {
		sqlSession.delete("blogReply.blogReplyRemove", blogReplyDTO);
		
	}

}
