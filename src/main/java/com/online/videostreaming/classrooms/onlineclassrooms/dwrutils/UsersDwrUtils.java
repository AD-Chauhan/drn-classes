package com.online.videostreaming.classrooms.onlineclassrooms.dwrutils;

import org.springframework.beans.factory.annotation.Autowired;

import com.online.videostreaming.classrooms.onlineclassrooms.drnusers.service.UserService;

public class UsersDwrUtils {

	
	@Autowired
	private UserService userService;
	
	 public String deleteOrDeactivateUserById(Integer idToDelete,String action) throws Exception {
			
		 
			return  userService.deleteOrDeactivateUserById(idToDelete,action);
		}
	
}
