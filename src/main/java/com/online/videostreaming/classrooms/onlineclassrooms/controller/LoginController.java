package com.online.videostreaming.classrooms.onlineclassrooms.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.online.videostreaming.classrooms.onlineclassrooms.drnusers.service.UserService;
import com.online.videostreaming.classrooms.onlineclassrooms.entity.UsersEntity;
import com.online.videostreaming.classrooms.onlineclassrooms.entity.UsersRole;
import com.online.videostreaming.classrooms.onlineclassrooms.enums.Batch;
import com.online.videostreaming.classrooms.onlineclassrooms.enums.CourseCategory;
import com.online.videostreaming.classrooms.onlineclassrooms.forms.LoginForm;
import com.online.videostreaming.classrooms.onlineclassrooms.forms.UsersRegistrationForm;
import com.online.videostreaming.classrooms.onlineclassrooms.serviceImpl.LoginPasswordService;
@Controller
public class LoginController {

	@Autowired
	private UserService userService;
	@Autowired
	private LoginPasswordService loginPasswordService;
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage(Model model,@ModelAttribute("loginForm") LoginForm logingForm, HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		loginPasswordService.refreshKeys();
		loginPasswordService.refreshSecrets();
		
		System.out.println(loginPasswordService.getHS256KeysBytes());
		System.out.println(loginPasswordService.getHS256SecretBytes());
		model.addAttribute("courseCategory", CourseCategory.mappings.entrySet()
	            .stream()
	            .sorted((Map.Entry.<Integer, String>comparingByValue()))
	            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new)));
		model.addAttribute("batch", Batch.mappings.entrySet()
	            .stream()
	            .sorted((Map.Entry.<Integer, String>comparingByValue().reversed()))
	            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new)));

		
		return "login-page";

	}
	
	@RequestMapping(value = "/register-page", method = RequestMethod.GET)
	public String registrationPage(Model model,@ModelAttribute("userRegistrationForm") UsersRegistrationForm studentRegistrationForm, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		List<UsersRole> roleList= userService.findAllUserRoles();
		model.addAttribute("roleList", roleList);
		model.addAttribute("batch", Batch.mappings.entrySet()
	            .stream()
	            .sorted((Map.Entry.<Integer, String>comparingByValue().reversed()))
	            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new)));
		return "register-page";

	}
	
	
	@RequestMapping(value = "/register-page", method = RequestMethod.POST)
	public String registrationPagePost(Model model,@ModelAttribute("userRegistrationForm") UsersRegistrationForm userRegistrationForm, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		Optional<UsersEntity> usersEntity=userService.findUserByUserName(userRegistrationForm.getEmail());
		if(usersEntity.isPresent()) {
			
			model.addAttribute(com.online.videostreaming.classrooms.onlineclassrooms.constants.Constants.ERROR_KEY, "You un-successfully not registered user " + userRegistrationForm.getEmail()+ " Because this "
					+ "this email already exist .Please choose another email id"); 
	     	   
		}else {
			
			int saveCount= userService.uploadUsersInformation(userRegistrationForm);
	        if(saveCount==0) {
	     	   
	     	   model.addAttribute(com.online.videostreaming.classrooms.onlineclassrooms.constants.Constants.SUCCESS_KEY,"You successfully registered user " + userRegistrationForm.getEmail()); 
	        }else if(saveCount==1) {
	     	   
	     	   model.addAttribute(com.online.videostreaming.classrooms.onlineclassrooms.constants.Constants.ERROR_KEY, "You un-successfully not registered user " + userRegistrationForm.getEmail()); 
	     	   
	        }
			
		}
		
		UsersRegistrationForm registrationForm=new UsersRegistrationForm();
		model.addAttribute("userRegistrationForm", registrationForm);
		model.addAttribute("roleList", userService.findAllUserRoles());
		return "register-page";

	}
	
	@RequestMapping(value = "/edit-users-dashboard", method = RequestMethod.GET)
	public String editRegistrationPage(Model model, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		List<UsersRegistrationForm> finalList= userService.findAllUserDetails();
		model.addAttribute("finalList", finalList);
		List<UsersRole> roleList= userService.findAllUserRoles();
		model.addAttribute("roleList", roleList);
		return "edit-users-dashboard";

	}
	
	@RequestMapping(value = "/error", method = RequestMethod.GET)
	public String loginPage(Model model, HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		return "error-page";

	}
	/*
	 * public List<UsersRegistrationForm> getKeyValueMap(List<UsersRegistrationForm>
	 * userEntitylist) throws Exception {
	 * 
	 * List<UsersRegistrationForm> userList =new ArrayList<UsersRegistrationForm>();
	 * Map<Integer,Map<Integer,List<UsersRole>>> sortedMemberMapKeyByName = new
	 * HashMap<Integer, Map<Integer, List<UsersRole>>>(); for(UsersRegistrationForm
	 * objects:userEntitylist){
	 * 
	 * if(objects.getUserId()!=null){
	 * 
	 * if(!sortedMemberMapKeyByName.containsKey(objects.getUserId())){
	 * 
	 * Map<Integer,List<UsersRole>> sortedMemberRoleMap = new HashMap<Integer,
	 * List<UsersRole>>(); for(UsersRegistrationForm innerObj:userEntitylist){
	 * if(innerObj.getUserId()!=null){
	 * if(innerObj.getUserId().equals(objects.getUserId()) ){
	 * 
	 * for(UsersRole userrole:innerObj.getUserRole()) {
	 * 
	 * if(userrole.getRoleId()!=null){
	 * 
	 * 
	 * if(!sortedMemberRoleMap.containsKey(objects.getUserId())){
	 * 
	 * List<UsersRole> finalList=new ArrayList<UsersRole>(); for(UsersRole
	 * userroleIn:innerObj.getUserRole()) {
	 * 
	 * if(userroleIn.getRoleId()!=null){
	 * if(userrole.getRoleId().equals(userroleIn.getRoleId())){
	 * 
	 * 
	 * finalList.add(userrole);
	 * 
	 * 
	 * }
	 * 
	 * 
	 * 
	 * }
	 * 
	 * 
	 * 
	 * }
	 * 
	 * UsersRegistrationForm registeredUsers =new UsersRegistrationForm();
	 * registeredUsers.setFirstName(objects.getFirstName());
	 * registeredUsers.setMiddleName(objects.getMiddleName());
	 * registeredUsers.setLastName(objects.getLastName());
	 * registeredUsers.setEmail(objects.getEmail());
	 * registeredUsers.setBatch(objects.getBatch());
	 * registeredUsers.setFatherName(objects.getFatherName());
	 * registeredUsers.setMotherName(objects.getMotherName());
	 * registeredUsers.setUserRole(finalList);
	 * registeredUsers.setCorrespondanceAddress(objects.getCorrespondanceAddress());
	 * registeredUsers.setPermanentAddress(objects.getPermanentAddress());
	 * registeredUsers.setPhone(objects.getPhone());
	 * registeredUsers.setCreatedOn(objects.getCreatedOn());
	 * registeredUsers.setCreatedBy(objects.getCreatedBy());
	 * registeredUsers.setEnabled(objects.isEnabled());
	 * registeredUsers.setUserId(objects.getUserId());
	 * userList.add(registeredUsers); sortedMemberRoleMap.put(objects.getUserId(),
	 * finalList);
	 * 
	 * 
	 * 
	 * }
	 * 
	 * 
	 * 
	 * }
	 * 
	 * } } }
	 * 
	 * sortedMemberMapKeyByName.put(objects.getUserId(), sortedMemberRoleMap); }
	 * 
	 * 
	 * } }
	 * 
	 * }
	 * 
	 * 
	 * 
	 * return userList; }
	 */
}
