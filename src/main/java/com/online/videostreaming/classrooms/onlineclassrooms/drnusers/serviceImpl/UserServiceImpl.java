package com.online.videostreaming.classrooms.onlineclassrooms.drnusers.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.stereotype.Service;

import com.online.videostreaming.classrooms.onlineclassrooms.drnusers.repository.UserEntityDao;
import com.online.videostreaming.classrooms.onlineclassrooms.drnusers.service.UserService;
import com.online.videostreaming.classrooms.onlineclassrooms.entity.UsersEntity;
import com.online.videostreaming.classrooms.onlineclassrooms.entity.UsersRole;
import com.online.videostreaming.classrooms.onlineclassrooms.forms.UsersRegistrationForm;
@Service
public class UserServiceImpl implements UserService {

   @Autowired
   private UserEntityDao userEntityDao;
	
	/*
	 * @Autowired private PasswordEncoder passwordEncoder;
	 */
	@Override
	public Optional<UsersEntity> findUserByUserName(String username) throws Exception {
		return userEntityDao.findUserByUserName(username);
	}

	@Override
	public List<UsersEntity> findAllUsers() throws Exception {
		return userEntityDao.findAllUsers();
	}

	@Override
	public void increaseFailedAttempts(UsersEntity user) throws Exception {
		userEntityDao.increaseFailedAttempts(user);
	}

	@Override
	public void resetFailedAttempts(String username) throws Exception {
		userEntityDao.resetFailedAttempts(username);
	}

	@Override
	public void lock(UsersEntity user) throws Exception {
		userEntityDao.lock(user);
	}

	@Override
	public boolean unlockWhenTimeExpired(UsersEntity user) throws Exception {
		return userEntityDao.unlockWhenTimeExpired(user);
	}

	@Override
	public List<UsersRole> findAllUserRoles() throws Exception {
		// TODO Auto-generated method stub
		return userEntityDao.findAllUserRoles();
	}

	@Override
	public int uploadUsersInformation(UsersRegistrationForm usersRegistrationForm) throws Exception {
		
        List<UsersRole> roles = new ArrayList<>();
		if(usersRegistrationForm.getUserRole()!=null ) {
			
			
			
				
				UsersRole usersRole = new UsersRole();
				usersRole.setRoleId(usersRegistrationForm.getUserRole());
				usersRole.setCreatedOn(new Date());
				usersRole.setCreatedBy("ADMIN");
				usersRole.setUpdatedOn(new Date());
				usersRole.setUpdatedBy("ADMIN");
				usersRole.setUpdatedIp("127.0.0.0");
				usersRole.setEnabled(true);
				roles.add(usersRole);
				
			
			
			
		}
		
		
		
		
		UsersEntity usersEntity =new UsersEntity();
		usersEntity.setFirstName(usersRegistrationForm.getFirstName());
		usersEntity.setMiddleName(usersRegistrationForm.getMiddleName());
		usersEntity.setLastName(usersRegistrationForm.getLastName());
		usersEntity.setEmail(usersRegistrationForm.getEmail());
		usersEntity.setUserPassword(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode(usersRegistrationForm.getUserPassword()));
		usersEntity.setPhone(usersRegistrationForm.getPhone());
		usersEntity.setDeactivatedReason(null);
		usersEntity.setBatch(usersRegistrationForm.getBatch());
		usersEntity.setCorrespondanceAddress(usersRegistrationForm.getCorrespondanceAddress());
		usersEntity.setPermanentAddress(usersRegistrationForm.getPermanentAddress());
		usersEntity.setFatherName(usersRegistrationForm.getFatherName());
		usersEntity.setMotherName(usersRegistrationForm.getMotherName());
		usersEntity.setFailedAttempt(0);
		usersEntity.setIsAccountNonLocked(false);
		usersEntity.setLockTime(new Date());
		usersEntity.setRoles(roles);
		usersEntity.setCreatedOn(new Date());
		usersEntity.setCreatedBy("ADMIN");
		usersEntity.setUpdatedOn(new Date());
		usersEntity.setUpdatedBy("ADMIN");
		usersEntity.setUpdatedIp("127.0.0.0");
		return userEntityDao.uploadUsersInformation(usersEntity);
	}

	@Override
	public List<UsersRegistrationForm> findAllUserDetails() throws Exception {

		List<UsersRegistrationForm> registeredUsersList=new ArrayList<UsersRegistrationForm>();
		
		List<UsersEntity> usersentityList=userEntityDao.findAllUserDetails();
		if(usersentityList!=null && !usersentityList.isEmpty()) {
			
			
			registeredUsersList=usersentityList.stream().map(objects->{
				
				UsersRegistrationForm registeredUsers =new UsersRegistrationForm();
				registeredUsers.setFirstName(objects.getFirstName());
				registeredUsers.setMiddleName(objects.getMiddleName());
				registeredUsers.setLastName(objects.getLastName());
				registeredUsers.setEmail(objects.getEmail());
				registeredUsers.setBatch(objects.getBatch());
				registeredUsers.setFatherName(objects.getFatherName());
				registeredUsers.setMotherName(objects.getMotherName());
				registeredUsers.setUserRole(objects.getRoles().get(0).getRoleId());
				registeredUsers.setCorrespondanceAddress(objects.getCorrespondanceAddress());
				registeredUsers.setPermanentAddress(objects.getPermanentAddress());
				registeredUsers.setPhone(objects.getPhone());
				registeredUsers.setCreatedOn(objects.getCreatedOn());
				registeredUsers.setCreatedBy(objects.getCreatedBy());
				registeredUsers.setEnabled(objects.isEnabled());
				registeredUsers.setUserId(objects.getUserId());
				return registeredUsers;
			}).collect(Collectors.toList());
			
			
			return registeredUsersList;
		}
		
		
		return null;
	}

	@Override
	public String deleteOrDeactivateUserById(Integer idToDelete, String action) throws Exception {
		// TODO Auto-generated method stub
		return userEntityDao.deleteOrDeactivateUserById(idToDelete, action);
	}

}
