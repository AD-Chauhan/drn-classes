package com.online.videostreaming.classrooms.onlineclassrooms.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.online.videostreaming.classrooms.onlineclassrooms.drnusers.EndUserDetails;
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
    private ApplicationContext applicationContext;
	@Autowired
	private UserService userService;
	@Autowired
	private LoginPasswordService loginPasswordService;
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage(Model model,@ModelAttribute("loginForm") LoginForm logingForm, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		
		
		
		AuthenticationFailureHandler	loginFailureHandler1=(AuthenticationFailureHandler) applicationContext.getBean("loginFailureHandler1");
		AuthenticationFailureHandler	loginFailureHandler=(AuthenticationFailureHandler) applicationContext.getBean("loginFailureHandler");
		
		System.out.println(loginFailureHandler.hashCode());
		System.out.println(loginFailureHandler1.hashCode());
		
		
		
		
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
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/register-page", method = RequestMethod.GET)
	public String registrationPage(Model model,@ModelAttribute("userRegistrationForm") UsersRegistrationForm studentRegistrationForm, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session = request.getSession(true);
		SecurityContext securityContext = (SecurityContext) session
				.getAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY);
		SecurityContext ctx = SecurityContextHolder.createEmptyContext();
		SecurityContextHolder.setContext(ctx);
		ctx.setAuthentication(securityContext.getAuthentication());

		if (SecurityContextHolder.getContext().getAuthentication() != null
				&& SecurityContextHolder.getContext().getAuthentication().isAuthenticated()
				&& !(SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken)) {
		List<UsersRole> roleList= userService.findAllUserRoles();
		model.addAttribute("roleList", roleList);
		model.addAttribute("batch", Batch.mappings.entrySet()
	            .stream()
	            .sorted((Map.Entry.<Integer, String>comparingByValue().reversed()))
	            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new)));
		}
		return "register-page";

	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/register-page", method = RequestMethod.POST)
	public String registrationPagePost(Model model,@ModelAttribute("userRegistrationForm") UsersRegistrationForm userRegistrationForm, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session = request.getSession(true);
		SecurityContext securityContext = (SecurityContext) session
				.getAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY);
		SecurityContext ctx = SecurityContextHolder.createEmptyContext();
		SecurityContextHolder.setContext(ctx);
		ctx.setAuthentication(securityContext.getAuthentication());

		if (SecurityContextHolder.getContext().getAuthentication() != null
				&& SecurityContextHolder.getContext().getAuthentication().isAuthenticated()
				&& !(SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken)) {
		Optional<UsersEntity> usersEntity=userService.findUserByUserName(userRegistrationForm.getEmail().trim());
		if(usersEntity!=null) {
			
			model.addAttribute(com.online.videostreaming.classrooms.onlineclassrooms.constants.Constants.ERROR_KEY, "You un-successfully not registered user " + userRegistrationForm.getEmail()+ " Because this "
					+ "this email already exist .Please choose another email id"); 
	     	   
		}else {
			EndUserDetails userDetails = (EndUserDetails) securityContext.getAuthentication().getPrincipal();
            if(!StringUtils.isEmpty(userDetails.getMiddleName())) {
            	userRegistrationForm.setCreatedBy(new StringBuilder().append(userDetails.getFirstName()).append(" ").append(userDetails.getMiddleName()).append(" ").append(userDetails.getLastName()).append("(").append(userDetails.getEmail()).append(")").toString().toUpperCase());
            	
            }else {
            	userRegistrationForm.setCreatedBy(new StringBuilder().append(userDetails.getFirstName()).append(" ").append(userDetails.getLastName()).append("(").append(userDetails.getEmail()).append(")").toString().toUpperCase());
            }
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
		}
		return "register-page";

	}
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/edit-users-dashboard", method = RequestMethod.GET)
	public String editRegistrationPage(Model model, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session = request.getSession(true);
		SecurityContext securityContext = (SecurityContext) session
				.getAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY);
		SecurityContext ctx = SecurityContextHolder.createEmptyContext();
		SecurityContextHolder.setContext(ctx);
		ctx.setAuthentication(securityContext.getAuthentication());

		if (SecurityContextHolder.getContext().getAuthentication() != null
				&& SecurityContextHolder.getContext().getAuthentication().isAuthenticated()
				&& !(SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken)) {
		List<UsersRegistrationForm> finalList= userService.findAllUserDetails();
		model.addAttribute("finalList", finalList);
		List<UsersRole> roleList= userService.findAllUserRoles();
		model.addAttribute("roleList", roleList);
		}
		return "edit-users-dashboard";

	}
	
	@RequestMapping(value = "/error", method = RequestMethod.GET)
	public String loginPage(Model model, HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		return "error-page";

	}
	
}
