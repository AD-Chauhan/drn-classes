package com.online.videostreaming.classrooms.onlineclassrooms.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.online.videostreaming.classrooms.onlineclassrooms.entity.BlogUploadEntity;
import com.online.videostreaming.classrooms.onlineclassrooms.entity.VideoUploadEntity;
import com.online.videostreaming.classrooms.onlineclassrooms.enums.CourseCategory;
import com.online.videostreaming.classrooms.onlineclassrooms.forms.VideoUploadForm;
import com.online.videostreaming.classrooms.onlineclassrooms.services.BlogService;
import com.online.videostreaming.classrooms.onlineclassrooms.services.VideoGalleryService;
@Controller
public class HomeController {

	@Autowired
	private VideoGalleryService videoGalleryService;
	@Autowired
	private BlogService blogService;
	@PreAuthorize ("hasRole('ROLE_USERS')")
	@RequestMapping(value = "/home-page", method = RequestMethod.GET)
	public String servicesMigration(Model model, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session =request.getSession(true);
		SecurityContext securityContext=(SecurityContext)session.getAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY);	
		SecurityContext ctx = SecurityContextHolder.createEmptyContext();
		SecurityContextHolder.setContext(ctx);
		ctx.setAuthentication(securityContext.getAuthentication());
		
		if (SecurityContextHolder.getContext().getAuthentication() != null
				&& SecurityContextHolder.getContext().getAuthentication().isAuthenticated()
				&& !(SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken)) {
		
		List<VideoUploadEntity> finallist=videoGalleryService.getAllUploadedVideos();
		if(finallist!=null && !finallist.isEmpty()) {
			
			Map<String,List<VideoUploadForm>> sortedMemberMapKeyByName=getKeyValueMap(finallist.stream().map(mapper->{
				
				VideoUploadForm videoUploadEntity=new VideoUploadForm();
				videoUploadEntity.setCourseCategory(mapper.getCourseCategory());
				videoUploadEntity.setVideoName(mapper.getVideoName());
				videoUploadEntity.setVideoTitle(mapper.getVideoTitle());
				videoUploadEntity.setThumbnailPath(mapper.getThumbnailPath());
				videoUploadEntity.setThumbnailFileName(mapper.getThumbnailFileName());
				videoUploadEntity.setEncryptdata(mapper.getFolderId());
				return videoUploadEntity;
				
			}).collect(Collectors.toList()));
			model.addAttribute("finalList", sortedMemberMapKeyByName);
			
		}
		List<BlogUploadEntity> finalList=blogService.getAllUploadedBlogsByLimit();
		model.addAttribute("record", finalList);
		}
		return "home-page";

	}
	
	
	
	public Map<String,List<VideoUploadForm>> getKeyValueMap(List<VideoUploadForm> VideoUploadEntitylist)
			throws Exception {
		
		
		Map<String,List<VideoUploadForm>> sortedMemberMapKeyByName = new HashMap<String, List<VideoUploadForm>>();
		for(VideoUploadForm outerObj:VideoUploadEntitylist){
			
			if(outerObj.getCourseCategory()!=null){
			
			if(!sortedMemberMapKeyByName.containsKey(CourseCategory.mappings.get(outerObj.getCourseCategory()))){
				
				List<VideoUploadForm> finalList = new ArrayList<VideoUploadForm>();
							for(VideoUploadForm innerObj:VideoUploadEntitylist){
								if(innerObj.getCourseCategory()!=null){
									if(innerObj.getCourseCategory().equals(outerObj.getCourseCategory()) ){
										finalList.add(innerObj); 
									}	
								}
							}
								sortedMemberMapKeyByName.put(CourseCategory.mappings.get(outerObj.getCourseCategory()), finalList);
					}
			
					
				}
				
				
			}
		
		
		
		return  sortedMemberMapKeyByName;
	}
	
	@PreAuthorize ("hasRole('ROLE_USERS')")
	@RequestMapping(value = "/blog-details", method = RequestMethod.GET)
	public String blogDetails(@ModelAttribute("videoUploadForm") VideoUploadForm videoUploadForm, Model model,
			HttpServletRequest request, HttpServletResponse response, RedirectAttributes re, BindingResult result)
			throws Exception {
		HttpSession session =request.getSession(true);
		SecurityContext securityContext=(SecurityContext)session.getAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY);	
		SecurityContext ctx = SecurityContextHolder.createEmptyContext();
		SecurityContextHolder.setContext(ctx);
		ctx.setAuthentication(securityContext.getAuthentication());
		
		if (SecurityContextHolder.getContext().getAuthentication() != null
				&& SecurityContextHolder.getContext().getAuthentication().isAuthenticated()
				&& !(SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken)) {
		List<BlogUploadEntity> finalList=blogService.getAllUploadedBlogsByLimit();
		model.addAttribute("finalList", finalList);
		}
		return "blog-details";

	}
	@PreAuthorize ("hasRole('ROLE_USERS')")
	@RequestMapping(value = "/contact-details", method = RequestMethod.GET)
	public String contactDetails(@ModelAttribute("videoUploadForm") VideoUploadForm videoUploadForm, Model model,
			HttpServletRequest request, HttpServletResponse response, RedirectAttributes re, BindingResult result)
			throws Exception {

		HttpSession session =request.getSession(true);
		SecurityContext securityContext=(SecurityContext)session.getAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY);	
		SecurityContext ctx = SecurityContextHolder.createEmptyContext();
		SecurityContextHolder.setContext(ctx);
		ctx.setAuthentication(securityContext.getAuthentication());
		
		
		
		return "contact-details";

	}
	@PreAuthorize ("hasRole('ROLE_USERS')")
	@RequestMapping(value = "/course-details", method = RequestMethod.GET)
	public String courseDetails(@ModelAttribute("videoUploadForm") VideoUploadForm videoUploadForm, Model model,
			HttpServletRequest request, HttpServletResponse response, RedirectAttributes re, BindingResult result)
			throws Exception {
		HttpSession session =request.getSession(true);
		SecurityContext securityContext=(SecurityContext)session.getAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY);	
		SecurityContext ctx = SecurityContextHolder.createEmptyContext();
		SecurityContextHolder.setContext(ctx);
		ctx.setAuthentication(securityContext.getAuthentication());
		
		if (SecurityContextHolder.getContext().getAuthentication() != null
				&& SecurityContextHolder.getContext().getAuthentication().isAuthenticated()
				&& !(SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken)) {
		List<VideoUploadEntity> finallist=videoGalleryService.getAllUploadedVideos();
		if(finallist!=null && !finallist.isEmpty()) {
			
			Map<String,List<VideoUploadForm>> sortedMemberMapKeyByName=getKeyValueMap(finallist.stream().map(mapper->{
				
				VideoUploadForm videoUploadEntity=new VideoUploadForm();
				videoUploadEntity.setCourseCategory(mapper.getCourseCategory());
				videoUploadEntity.setVideoName(mapper.getVideoName());
				videoUploadEntity.setVideoTitle(mapper.getVideoTitle());
				videoUploadEntity.setThumbnailPath(mapper.getThumbnailPath());
				videoUploadEntity.setThumbnailFileName(mapper.getThumbnailFileName());
				videoUploadEntity.setEncryptdata(mapper.getFolderId());
				return videoUploadEntity;
				
			}).collect(Collectors.toList()));
			model.addAttribute("finalList", sortedMemberMapKeyByName);
			
		}
		
		}
		return "course-details";

	}
}
