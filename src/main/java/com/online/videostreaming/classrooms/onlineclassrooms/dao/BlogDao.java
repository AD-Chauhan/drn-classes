package com.online.videostreaming.classrooms.onlineclassrooms.dao;

import java.util.List;

import com.online.videostreaming.classrooms.onlineclassrooms.entity.BlogUploadEntity;

public interface BlogDao {

	
	 public int uploadBlogFile(BlogUploadEntity blogUploadEntity) throws Exception;
	
	 public List<BlogUploadEntity> getAllUploadedBlogs() throws Exception;
	 
	 public List<BlogUploadEntity> getAllUploadedBlogsByLimit() throws Exception;
	 
	 public BlogUploadEntity getBlogDetailsById(Integer Id) throws Exception;
	 
	 public boolean deleteBlogById(Integer idToDelete) throws Exception;
	
	 
}
