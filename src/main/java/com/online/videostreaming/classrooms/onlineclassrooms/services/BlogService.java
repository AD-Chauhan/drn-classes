package com.online.videostreaming.classrooms.onlineclassrooms.services;

import java.util.List;

import com.online.videostreaming.classrooms.onlineclassrooms.entity.BlogUploadEntity;

public interface BlogService {

	
	 public int uploadBlogFile(BlogUploadEntity blogUploadEntity) throws Exception;
	 
	 public List<BlogUploadEntity> getAllUploadedBlogs() throws Exception;
	 
	 public List<BlogUploadEntity> getAllUploadedBlogsByLimit() throws Exception;
	 
	 public String deleteFolderAndBlogsById(Integer idToDelete) throws Exception;
}
