package com.online.videostreaming.classrooms.onlineclassrooms.controller;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.online.videostreaming.classrooms.onlineclassrooms.entity.BlogUploadEntity;
import com.online.videostreaming.classrooms.onlineclassrooms.entity.VideoUploadEntity;
import com.online.videostreaming.classrooms.onlineclassrooms.forms.BlogsForms;
import com.online.videostreaming.classrooms.onlineclassrooms.serviceImpl.RandomGeneratorImpl;
import com.online.videostreaming.classrooms.onlineclassrooms.services.BlogService;
import com.online.videostreaming.classrooms.onlineclassrooms.services.RandomGenerator;
import com.online.videostreaming.classrooms.onlineclassrooms.utils.VideoImageFrame;
@Controller
public class AdminController {
	private static final int DEFAULT_RANDOM_LENGTH = 10;
	private RandomGenerator randomGenerator;
	@Autowired
    ServletContext context;
	@Autowired
	private BlogService blogService;
	@RequestMapping(value = "/admin-dashboard", method = RequestMethod.GET)
	public String loginPage(Model model, HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		return "admin-dashboard";

	}
	
	
	
	
	@RequestMapping(value = "/upload-blogs", method = RequestMethod.GET)
	public String blogGetPage(@ModelAttribute("blogsForms") BlogsForms blogsForms,Model model, HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		return "upload-blogs";

	}
	
	
	@RequestMapping(value = "/view-blogs", method = RequestMethod.GET)
	public String viewBlogGetPage(Model model, HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		List<BlogUploadEntity> finalList=blogService.getAllUploadedBlogs();
		model.addAttribute("finalList", finalList);
		
		return "view-blogs";

	}
	
	
	@RequestMapping(value = "/upload-blogs", method = RequestMethod.POST)
	public String blogPostPage(@ModelAttribute("blogsForms") BlogsForms blogsForms,Model model, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (blogsForms.getChapterFileName() != null && !blogsForms.getChapterFileName().isEmpty()) {
            String random=null;
			randomGenerator=new RandomGeneratorImpl(DEFAULT_RANDOM_LENGTH);
			random=randomGenerator.generateToken();
			

			StringBuilder dirPath = new StringBuilder().append(File.separator).append("resources").append(File.separator);

			StringBuilder pathtostring = new StringBuilder().append(context.getRealPath(dirPath.toString())).append(File.separator).append("BlogUploads").append(File.separator);
		
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

			StringBuilder blogpathtostring = new StringBuilder().append(idpathtostring.toString()).append("Blogs").append(File.separator);
			Path pathBlog = Paths.get(blogpathtostring.toString());
			if (!Files.exists(pathBlog)) {
				try {
					Files.createDirectories(pathBlog);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			

			 try {
				 
			        BufferedImage inputImage = ImageIO.read(blogsForms.getChapterFileName().getInputStream());
			        BufferedImage outputImage = new BufferedImage(1200,
			                611, inputImage.getType());
			        Graphics2D g2d = outputImage.createGraphics();
			        g2d.drawImage(inputImage, 0, 0, 1200, 611, null);
			        g2d.dispose();
		            ImageIO.write(outputImage, FilenameUtils.getExtension(blogsForms.getChapterFileName().getOriginalFilename()), new File(blogpathtostring.toString() + random+"."+FilenameUtils.getExtension(blogsForms.getChapterFileName().getOriginalFilename())));
		            
		            BufferedImage outputImage800 = new BufferedImage(1200,
			                611, inputImage.getType());
			        Graphics2D g2d800 = outputImage800.createGraphics();
			        g2d800.drawImage(inputImage, 0, 0, 800, 558, null);
			        g2d800.dispose();
		            ImageIO.write(outputImage800, FilenameUtils.getExtension(blogsForms.getChapterFileName().getOriginalFilename()), new File(blogpathtostring.toString() + random+"_800."+FilenameUtils.getExtension(blogsForms.getChapterFileName().getOriginalFilename())));
		            
		            
		            BufferedImage outputImage600 = new BufferedImage(1200,
			                611, inputImage.getType());
			        Graphics2D g2d600 = outputImage600.createGraphics();
			        g2d600.drawImage(inputImage, 0, 0, 600, 878, null);
			        g2d600.dispose();
		            ImageIO.write(outputImage600, FilenameUtils.getExtension(blogsForms.getChapterFileName().getOriginalFilename()), new File(blogpathtostring.toString() + random+"_600."+FilenameUtils.getExtension(blogsForms.getChapterFileName().getOriginalFilename())));
		            
		            //800-558 600-878
		           		
		            BlogUploadEntity blogUploadEntity=new BlogUploadEntity();
		            blogUploadEntity.setBlogName(blogsForms.getBlogName());
		            blogUploadEntity.setBlogTitle(blogsForms.getBlogTitle());
		            blogUploadEntity.setExecutionTime(blogsForms.getExecutionTime());
		            blogUploadEntity.setDescription(blogsForms.getDescription());
		            blogUploadEntity.setOriginalFileName(random+"."+FilenameUtils.getExtension(blogsForms.getChapterFileName().getOriginalFilename()));
		            blogUploadEntity.setOriginalFileName600(random+"_600."+FilenameUtils.getExtension(blogsForms.getChapterFileName().getOriginalFilename()));
		            blogUploadEntity.setOriginalFileName800(random+"_800."+FilenameUtils.getExtension(blogsForms.getChapterFileName().getOriginalFilename()));
		            
		            blogUploadEntity.setOriginalFileExt(FilenameUtils.getExtension(blogsForms.getChapterFileName().getOriginalFilename()));
		            blogUploadEntity.setCreatedDate(Timestamp.valueOf(LocalDateTime.now()));
		            blogUploadEntity.setOriginalPath("/resources/BlogUploads/"+random+"/Blogs/");
		            blogUploadEntity.setCreatedby("ADMIN");
		            blogUploadEntity.setFolderId(random);
		            
		           int saveCount= blogService.uploadBlogFile(blogUploadEntity);
		           
		           
		           if(saveCount==0) {
		        	   
		        	   model.addAttribute(com.online.videostreaming.classrooms.onlineclassrooms.constants.Constants.SUCCESS_KEY,
			                    "You successfully uploaded "+blogsForms.getChapterFileName().getOriginalFilename()); 
		           }else if(saveCount==1) {
		        	   
		        	   model.addAttribute(com.online.videostreaming.classrooms.onlineclassrooms.constants.Constants.ERROR_KEY,
			                    "You un-successfully not uploaded "+ blogsForms.getChapterFileName().getOriginalFilename() ); 
		        	   
		           }
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
			
			
			
			
		}
		return "upload-blogs";

	}
}
