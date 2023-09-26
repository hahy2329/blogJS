package com.application.blogJS.blog.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.application.blogJS.blog.dto.BlogDTO;

@Repository
public class BlogDAOImpl implements BlogDAO {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<BlogDTO> getBlogStudyList() throws Exception {
		return sqlSession.selectList("blog.getBlogStudyList");
	}

	@Override
	public void insertBlog(BlogDTO blogDTO) throws Exception {
		sqlSession.insert("blog.insertBlog", blogDTO);
		
	}

	@Override
	public BlogDTO getBlogStudyDetail(long blogId) throws Exception {
		return sqlSession.selectOne("blog.getBlogStudyDetail", blogId);
	}

	@Override
	public void increaseReadCnt(long blogId) throws Exception {
		sqlSession.update("blog.increaseReadCnt", blogId);
		
	}

	@Override
	public List<BlogDTO> getBlogKeywordList() throws Exception {
		return sqlSession.selectList("blog.getBlogKeywordList");
	}

	@Override
	public BlogDTO getBlogKeywordDetail(long blogId) throws Exception {
		return sqlSession.selectOne("blog.getBlogKeywordDetail", blogId);
	}

	@Override
	public List<BlogDTO> getblogDayTimeList() throws Exception {
		return sqlSession.selectList("blog.getblogDayTimeList");
	}

	@Override
	public BlogDTO getBlogDayTimeDetail(long blogId) throws Exception {
		return sqlSession.selectOne("blog.getBlogDayTimeDetail", blogId);
	}

	@Override
	public List<BlogDTO> getblogTravelList() throws Exception {
		return sqlSession.selectList("blog.getblogTravelList");
	}

	@Override
	public BlogDTO getBlogTravelDetail(long blogId) throws Exception {
		return sqlSession.selectOne("blog.getBlogTravelDetail",blogId);
	}

	@Override
	public void updateKeywordBlog(BlogDTO blogDTO) throws Exception {
		sqlSession.update("blog.updateKeywordBlog", blogDTO);
		
	}
	
	
	
	
	
}
