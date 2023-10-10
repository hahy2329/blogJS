package com.application.blogJS.blog.dao;

import java.util.List;

import com.application.blogJS.blog.dto.BlogDTO;

public interface BlogDAO {
	
	public List<BlogDTO> getBlogStudyList() throws Exception;
	public void insertBlog(BlogDTO blogDTO) throws Exception;
	public BlogDTO getBlogStudyDetail(long blogId) throws Exception;
	public void increaseReadCnt(long blogId) throws Exception;
	public List<BlogDTO> getBlogKeywordList() throws Exception;
	public BlogDTO getBlogKeywordDetail(long blogId) throws Exception;
	public List<BlogDTO> getBlogDayTimeList() throws Exception;
	public BlogDTO getBlogDayTimeDetail(long blogId) throws Exception;
	public List<BlogDTO> getBlogTravelList() throws Exception;
	public BlogDTO getBlogTravelDetail(long blogId) throws Exception;
	public void updateBlog(BlogDTO blogDTO) throws Exception;
	public void blogKeywordDelete(BlogDTO blogDTO) throws Exception;
	public void blogDayTimeDelete(BlogDTO blogDTO) throws Exception;
	public void blogStudyDelete(BlogDTO blogDTO) throws Exception;
	public void blogTravelDelete(BlogDTO blogDTO) throws Exception;
}
