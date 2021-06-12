package com.online.videostreaming.classrooms.onlineclassrooms.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.online.videostreaming.classrooms.onlineclassrooms.entity.VideoUploadEntity;
import com.online.videostreaming.classrooms.onlineclassrooms.enums.Batch;
import com.online.videostreaming.classrooms.onlineclassrooms.enums.CourseCategory;
import com.online.videostreaming.classrooms.onlineclassrooms.forms.FileNode;
import com.online.videostreaming.classrooms.onlineclassrooms.forms.VideoUploadForm;
import com.online.videostreaming.classrooms.onlineclassrooms.serviceImpl.RandomGeneratorImpl;
import com.online.videostreaming.classrooms.onlineclassrooms.services.RandomGenerator;
import com.online.videostreaming.classrooms.onlineclassrooms.services.VideoGalleryService;
import com.online.videostreaming.classrooms.onlineclassrooms.utils.AESEncryptDecrypt;
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
	@RequestMapping(value = "/upload-video", method = RequestMethod.GET)
	public String uploadVideo(@ModelAttribute("videoUploadForm") VideoUploadForm videoUploadForm, Model model,
			HttpServletRequest request, HttpServletResponse response, RedirectAttributes re, BindingResult result)
			throws Exception {
		
		model.addAttribute("courseCategory", CourseCategory.mappings.entrySet()
	            .stream()
	            .sorted((Map.Entry.<Integer, String>comparingByValue()))
	            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new)));
		model.addAttribute("batch", Batch.mappings.entrySet()
	            .stream()
	            .sorted((Map.Entry.<Integer, String>comparingByValue().reversed()))
	            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new)));

		return "upload-video";

	}

	@RequestMapping(value = "/upload-video", method = RequestMethod.POST)
	public String uploadVideoPost(@ModelAttribute("videoUploadForm") VideoUploadForm videoUploadForm, Model model,
			HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes, BindingResult result)
			throws Exception {
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
		    		videoUploadEntity.setCreatedby("ADMIN");
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
		        }
			
			
			
			
		}
		return "upload-video";

	}
	
	private String decodePath(HttpServletRequest request, String prefix) throws UnsupportedEncodingException {
        return URLDecoder.decode(request.getRequestURI().replaceAll("[/]+", "/").substring(prefix.length()), "UTF-8");
    }

	@RequestMapping("list/**")
    @ResponseBody
    public List<FileNode> list(HttpServletRequest request) throws UnsupportedEncodingException {
        final List<FileNode> list = new ArrayList<>();
        final String filePath = request.getContextPath() + decodePath(request, "/list/");
        try {
            final File directory = new File(filePath);
            final File[] files = directory.listFiles();
            for (File file : files) {
                String fileName = file.getName();
                if (file.isDirectory())
                    list.add(new FileNode(fileName, false));
                else if (fileName.toLowerCase().matches("^.*\\.mp4$"))
                    list.add(new FileNode(fileName, true));
            }
        } catch (Exception e) {
            
        }
        return list;
    }
	@RequestMapping(value = "/video-details", method = RequestMethod.GET)
	public String videoDetails(@ModelAttribute("videoUploadForm") VideoUploadForm videoUploadForm, Model model,
			HttpServletRequest request, HttpServletResponse response, RedirectAttributes re, BindingResult result)
			throws Exception {

		List<VideoUploadEntity> finalList=videoGalleryService.getAllUploadedVideos();
		model.addAttribute("finalList", finalList);
		
		return "video-details";

	}
	
	
	@RequestMapping(value = "/play-video", method = RequestMethod.GET)
	public String playVideo(@RequestParam(value = "v", required = true ) String folderId, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {

		
		
		if(folderId!=null) {
			VideoUploadEntity finalList=videoGalleryService.getVideoDetailsByFolderId(folderId);
			if(finalList!=null) {
				
				model.addAttribute("finalList", videoGalleryService.getVideoDetailsByFolderId(folderId));
			}else {
				
				return "404-page";
			}
			
			
		}
		
		return "play-video";

	}

	
	
	
}
