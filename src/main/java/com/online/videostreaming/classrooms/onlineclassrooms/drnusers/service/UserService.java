package com.online.videostreaming.classrooms.onlineclassrooms.drnusers.service;



import java.util.List;
import java.util.Optional;

import com.online.videostreaming.classrooms.onlineclassrooms.entity.UsersEntity;
import com.online.videostreaming.classrooms.onlineclassrooms.entity.UsersRole;
import com.online.videostreaming.classrooms.onlineclassrooms.forms.UsersRegistrationForm;


public interface UserService {
	
    public Optional<UsersEntity> findUserByUserName(String username) throws Exception;
    public List<UsersEntity> findAllUsers() throws Exception;
    public void increaseFailedAttempts(UsersEntity user) throws Exception;
    public void resetFailedAttempts(String username) throws Exception;
    public void lock(UsersEntity user) throws Exception;
    public boolean unlockWhenTimeExpired(UsersEntity user) throws Exception;
    public List<UsersRole> findAllUserRoles() throws Exception;
    public int uploadUsersInformation(UsersRegistrationForm utudentRegistrationForm) throws Exception;
    public List<UsersRegistrationForm> findAllUserDetails() throws Exception;
    
    
    
}
