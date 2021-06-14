package com.online.videostreaming.classrooms.onlineclassrooms.drnusers.repository;

import java.util.List;
import java.util.Optional;

import com.online.videostreaming.classrooms.onlineclassrooms.entity.UsersEntity;
import com.online.videostreaming.classrooms.onlineclassrooms.entity.UsersRole;
import com.online.videostreaming.classrooms.onlineclassrooms.forms.UsersRegistrationForm;

public interface UserEntityDao {

	
	public Optional<UsersEntity> findUserByUserName(String username) throws Exception;
    public List<UsersEntity> findAllUsers() throws Exception;
    public void increaseFailedAttempts(UsersEntity user) throws Exception;
    public void resetFailedAttempts(String username) throws Exception;
    public void lock(UsersEntity user) throws Exception;
    public boolean unlockWhenTimeExpired(UsersEntity user) throws Exception;
    public List<UsersRole> findAllUserRoles() throws Exception;
    public int uploadUsersInformation(UsersEntity usersEntity) throws Exception;
    public List<UsersEntity> findAllUserDetails() throws Exception;
    public String deleteOrDeactivateUserById(Integer idToDelete,String action) throws Exception;
    
    
}
	

