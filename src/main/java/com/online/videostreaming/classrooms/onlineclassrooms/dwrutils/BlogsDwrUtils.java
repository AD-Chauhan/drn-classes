package com.online.videostreaming.classrooms.onlineclassrooms.dwrutils;

import org.springframework.beans.factory.annotation.Autowired;

import com.online.videostreaming.classrooms.onlineclassrooms.services.BlogService;

public class BlogsDwrUtils {

	@Autowired
	private BlogService blogService;
	
	 public String deleteFolderAndBlogsById(Integer idToDelete) throws Exception {
			
		 
			return  blogService.deleteFolderAndBlogsById(idToDelete);
		}
}
