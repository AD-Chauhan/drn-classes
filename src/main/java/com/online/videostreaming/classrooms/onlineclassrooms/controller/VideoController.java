package com.online.videostreaming.classrooms.onlineclassrooms.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.online.videostreaming.classrooms.onlineclassrooms.drnusers.EndUserDetails;
import com.online.videostreaming.classrooms.onlineclassrooms.entity.VideoUploadEntity;
import com.online.videostreaming.classrooms.onlineclassrooms.enums.Batch;
import com.online.videostreaming.classrooms.onlineclassrooms.enums.CourseCategory;
import com.online.videostreaming.classrooms.onlineclassrooms.forms.PreviewComment;
import com.online.videostreaming.classrooms.onlineclassrooms.forms.ReplyOutputForm;
import com.online.videostreaming.classrooms.onlineclassrooms.forms.VideoUploadEntityForm;
import com.online.videostreaming.classrooms.onlineclassrooms.forms.VideoUploadForm;
import com.online.videostreaming.classrooms.onlineclassrooms.serviceImpl.RandomGeneratorImpl;
import com.online.videostreaming.classrooms.onlineclassrooms.services.RandomGenerator;
import com.online.videostreaming.classrooms.onlineclassrooms.services.VideoGalleryService;
import com.online.videostreaming.classrooms.onlineclassrooms.utils.VideoImageFrame;

@Controller
public class VideoController {
	@Value("#{servletContext.contextPath}")
	private String servletContextPath;
	@Autowired
	private VideoGalleryService videoGalleryService;
	
	private static final int DEFAULT_RANDOM_LENGTH = 10;
	private RandomGenerator randomGenerator;
	@Autowired
    ServletContext context;
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/upload-video", method = RequestMethod.GET)
	public String uploadVideo(@ModelAttribute("videoUploadForm") VideoUploadForm videoUploadForm, Model model,
			HttpServletRequest request, HttpServletResponse response, RedirectAttributes re, BindingResult result)
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
		model.addAttribute("courseCategory", CourseCategory.mappings.entrySet()
	            .stream()
	            .sorted((Map.Entry.<Integer, String>comparingByValue()))
	            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new)));
		model.addAttribute("batch", Batch.mappings.entrySet()
	            .stream()
	            .sorted((Map.Entry.<Integer, String>comparingByValue().reversed()))
	            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new)));
		}
		return "upload-video";

	}
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/upload-video", method = RequestMethod.POST)
	public String uploadVideoPost(@ModelAttribute("videoUploadForm") VideoUploadForm videoUploadForm, Model model,
			HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes, BindingResult result)
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
		
		if (videoUploadForm.getChapterFileName() != null && !videoUploadForm.getChapterFileName().isEmpty()) {
            String random=null;
			randomGenerator=new RandomGeneratorImpl(DEFAULT_RANDOM_LENGTH);
			random=randomGenerator.generateToken();
			

			StringBuilder dirPath = new StringBuilder().append(File.separator).append("resources").append(File.separator);

			StringBuilder pathtostring = new StringBuilder().append(context.getRealPath(dirPath.toString())).append(File.separator).append("VideosUploads").append(File.separator);
		
			Path pathupload = Paths.get(pathtostring.toString());
			if (!Files.exists(pathupload)) {
				try {
					Files.createDirectories(pathupload);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			StringBuilder idpathtostring = new StringBuilder().append(pathtostring).append(random)
					.append(File.separator);
			Path pathId = Paths.get(idpathtostring.toString());
			if (!Files.exists(pathId)) {
				try {
					Files.createDirectories(pathId);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			StringBuilder videopathtostring = new StringBuilder().append(idpathtostring.toString()).append("Videos").append(File.separator);
			Path pathVideo = Paths.get(videopathtostring.toString());
			if (!Files.exists(pathVideo)) {
				try {
					Files.createDirectories(pathVideo);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			StringBuilder thumbpathtostring = new StringBuilder().append(idpathtostring.toString()).append("Thumbnail").append(File.separator);
			Path pathThumb = Paths.get(thumbpathtostring.toString());
			if (!Files.exists(pathThumb)) {
				try {
					Files.createDirectories(pathThumb);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			 try {

		            byte[] bytes = videoUploadForm.getChapterFileName().getBytes();
		            Path path = Paths.get(videopathtostring.toString() + random+"."+FilenameUtils.getExtension(videoUploadForm.getChapterFileName().getOriginalFilename()));
		            Files.write(path, bytes);
		            String  filename=VideoImageFrame.randomGrabberFFmpegImage(videopathtostring.toString() + random+"."+FilenameUtils.getExtension(videoUploadForm.getChapterFileName().getOriginalFilename()), thumbpathtostring.toString(), "screenshot", 1,random);
		            
		           		
		    		VideoUploadEntity videoUploadEntity=new VideoUploadEntity();
		    		videoUploadEntity.setVideoName(videoUploadForm.getVideoName());
		    		videoUploadEntity.setVideoTitle(videoUploadForm.getVideoTitle());
		    		videoUploadEntity.setBatch(videoUploadForm.getBatch());
		    		videoUploadEntity.setCourseCategory(videoUploadForm.getCourseCategory());
		    		videoUploadEntity.setDescription(videoUploadForm.getDescription());
		    		videoUploadEntity.setOriginalFileName(random+"."+FilenameUtils.getExtension(videoUploadForm.getChapterFileName().getOriginalFilename()));
		    		videoUploadEntity.setOriginalFileExt(FilenameUtils.getExtension(videoUploadForm.getChapterFileName().getOriginalFilename()));
		    		videoUploadEntity.setCreatedDate(Timestamp.valueOf(LocalDateTime.now()));
		    		videoUploadEntity.setWrite(false);
		    		videoUploadEntity.setCompressed(false);
		    		videoUploadEntity.setOriginalPath("/resources/VideosUploads/"+random+"/Videos/");
		    		videoUploadEntity.setThumbnail(true);
		    		videoUploadEntity.setThumbnailPath("/resources/VideosUploads/"+random+"/Thumbnail/");
		    		
		    		EndUserDetails userDetails = (EndUserDetails) securityContext.getAuthentication().getPrincipal();
		            if(!StringUtils.isEmpty(userDetails.getMiddleName())) {
		            	videoUploadEntity.setCreatedby(new StringBuilder().append(userDetails.getFirstName()).append(" ").append(userDetails.getMiddleName()).append(" ").append(userDetails.getLastName()).append("(").append(userDetails.getEmail()).append(")").toString().toUpperCase());
		            	
		            }else {
		            	videoUploadEntity.setCreatedby(new StringBuilder().append(userDetails.getFirstName()).append(" ").append(userDetails.getLastName()).append("(").append(userDetails.getEmail()).append(")").toString().toUpperCase());
		            }
		    		
		    		videoUploadEntity.setCompressedPath(null);
		            videoUploadEntity.setThumbnailFileName(filename);
		            videoUploadEntity.setFolderId(random);
		            
		           int saveCount= videoGalleryService.uploadFile(videoUploadEntity);
		           
		           
		           if(saveCount==0) {
		        	   
		        	   model.addAttribute(com.online.videostreaming.classrooms.onlineclassrooms.constants.Constants.SUCCESS_KEY,
			                    "You successfully uploaded "+videoUploadForm.getChapterFileName().getOriginalFilename()); 
		           }else if(saveCount==1) {
		        	   
		        	   model.addAttribute(com.online.videostreaming.classrooms.onlineclassrooms.constants.Constants.ERROR_KEY,
			                    "You un-successfully not uploaded "+ videoUploadForm.getChapterFileName().getOriginalFilename() ); 
		        	   
		           }
		        } catch (IOException e) {
		            e.printStackTrace();
		        }catch(org.apache.tomcat.util.http.fileupload.impl.SizeLimitExceededException e1) {
		        	
		        	  model.addAttribute(com.online.videostreaming.classrooms.onlineclassrooms.constants.Constants.ERROR_KEY,
			                    "You un-successfully not uploaded "+ e1.getMessage() ); 
		        }
			
			 model.addAttribute("courseCategory", CourseCategory.mappings.entrySet()
			            .stream()
			            .sorted((Map.Entry.<Integer, String>comparingByValue()))
			            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new)));
				model.addAttribute("batch", Batch.mappings.entrySet()
			            .stream()
			            .sorted((Map.Entry.<Integer, String>comparingByValue().reversed()))
			            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new)));
			
			
		}
		}
		return "upload-video";

	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/video-details", method = RequestMethod.GET)
	public String videoDetails(@ModelAttribute("videoUploadForm") VideoUploadForm videoUploadForm, Model model,
			HttpServletRequest request, HttpServletResponse response, RedirectAttributes re, BindingResult result)
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
		List<VideoUploadEntityForm> finalList=videoGalleryService.getAllUploadedVideosForView();
		model.addAttribute("finalList", finalList);
		}
		return "video-details";

	}
	
	@PreAuthorize("hasRole('ROLE_USERS')")
	@RequestMapping(value = "/play-video", method = RequestMethod.GET)
	public String playVideo(@RequestParam(value = "v", required = true ) String folderId, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession(true);
		SecurityContext securityContext = (SecurityContext) session
				.getAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY);
		SecurityContext ctx = SecurityContextHolder.createEmptyContext();
		SecurityContextHolder.setContext(ctx);
		ctx.setAuthentication(securityContext.getAuthentication());

		if (SecurityContextHolder.getContext().getAuthentication() != null
				&& SecurityContextHolder.getContext().getAuthentication().isAuthenticated()
				&& !(SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken)) {
		
		
		
		if(folderId!=null) {
			SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy hh:mm:ss");
			VideoUploadEntity finalList=videoGalleryService.getVideoDetailsByFolderId(folderId);
			if(finalList!=null) {
				 List<Object[]> obList=videoGalleryService.findVideoCommentReply(folderId);
				
if(obList!=null) {
	 Map<PreviewComment,List<ReplyOutputForm>> map=new LinkedHashMap<PreviewComment,List<ReplyOutputForm>>();
	 Map<Integer,List<ReplyOutputForm>> mapInner=new LinkedHashMap<Integer,List<ReplyOutputForm>>();
	for (Object[] ob : obList) {
		 PreviewComment pc=new PreviewComment();
		 pc.setcId((Integer)ob[1]);
		 pc.setCommnent((String)ob[2]);
		 pc.setCreatedby((String)ob[4]);
		 pc.setCreatedDate(sdf.format((Timestamp)ob[5]));
		 
		 if(!mapInner.containsKey((Integer)ob[1])){
			 List<ReplyOutputForm>  innerlist=new ArrayList<ReplyOutputForm>();
			 for (Object[] obinner : obList) {
				 if(ob[1]!=null && ob[3]!=null) {
					 if(ob[1].toString().equals(obinner[1].toString())) {
						 ReplyOutputForm replyOutputForm=new ReplyOutputForm();
						 replyOutputForm.setCommnent((String)obinner[3]);
						 replyOutputForm.setCreatedby((String)obinner[6]);
						 replyOutputForm.setCreatedDate(obinner[7]==null?null:sdf.format((Timestamp)obinner[5]));
						 innerlist.add(replyOutputForm);
					 }
					 
				 }
			 }
			 mapInner.put((Integer)ob[1], innerlist); 
			 map.put(pc, innerlist); 
		 }
	}
	
	model.addAttribute("commentMap", map);
}
				 
				 
				model.addAttribute("finalList", videoGalleryService.getVideoDetailsByFolderId(folderId));
				
			}else {
				
				return "404-page";
			}
			
			
		}
		}
		return "play-video";

	}

	@RequestMapping(value = "/video-reply", method = RequestMethod.POST)
	public String videoReplyPost(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String reply=request.getParameter("reply");
		String folderId=request.getParameter("folderId");
		String commentId=request.getParameter("commentId");
		
		HttpSession session = request.getSession(true);
		SecurityContext securityContext = (SecurityContext) session
				.getAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY);
		SecurityContext ctx = SecurityContextHolder.createEmptyContext();
		SecurityContextHolder.setContext(ctx);
		ctx.setAuthentication(securityContext.getAuthentication());

		if (SecurityContextHolder.getContext().getAuthentication() != null
				&& SecurityContextHolder.getContext().getAuthentication().isAuthenticated()
				&& !(SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken)) {
		
		if(commentId!=null && !commentId.equals(""))
		{
			EndUserDetails userDetails = (EndUserDetails) securityContext.getAuthentication().getPrincipal();
            if(!StringUtils.isEmpty(userDetails.getMiddleName())) {
            	
            	videoGalleryService.saveReply(Integer.valueOf(commentId), reply,new StringBuilder().append(userDetails.getFirstName()).append(" ").append(userDetails.getMiddleName()).append(" ").append(userDetails.getLastName()).append("(").append(userDetails.getEmail()).append(")").toString().toUpperCase());
            	
            }else {
            	
            	videoGalleryService.saveReply(Integer.valueOf(commentId), reply,new StringBuilder().append(userDetails.getFirstName()).append(" ").append(userDetails.getLastName()).append("(").append(userDetails.getEmail()).append(")").toString().toUpperCase());
            }
			
			
			
		}
		
		}
		return "redirect:/play-video?v="+folderId;
		
		

	}
	@RequestMapping(value = "/video-comment", method = RequestMethod.POST)
	public String videoCommentPost(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {

		String comment=request.getParameter("comment");
		String folderId=request.getParameter("folderId");
		
		HttpSession session = request.getSession(true);
		SecurityContext securityContext = (SecurityContext) session
				.getAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY);
		SecurityContext ctx = SecurityContextHolder.createEmptyContext();
		SecurityContextHolder.setContext(ctx);
		ctx.setAuthentication(securityContext.getAuthentication());

		if (SecurityContextHolder.getContext().getAuthentication() != null
				&& SecurityContextHolder.getContext().getAuthentication().isAuthenticated()
				&& !(SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken)) {
		if(folderId!=null && !folderId.equals("")) {

			EndUserDetails userDetails = (EndUserDetails) securityContext.getAuthentication().getPrincipal();
            if(!StringUtils.isEmpty(userDetails.getMiddleName())) {
            	
            	videoGalleryService.saveComment(folderId, comment,new StringBuilder().append(userDetails.getFirstName()).append(" ").append(userDetails.getMiddleName()).append(" ").append(userDetails.getLastName()).append("(").append(userDetails.getEmail()).append(")").toString().toUpperCase());
            	
            }else {
            	
            	videoGalleryService.saveComment(folderId, comment,new StringBuilder().append(userDetails.getFirstName()).append(" ").append(userDetails.getLastName()).append("(").append(userDetails.getEmail()).append(")").toString().toUpperCase());
            }
		}
		
		
		}
		return "redirect:/play-video?v="+folderId;

	}
	
	
}
