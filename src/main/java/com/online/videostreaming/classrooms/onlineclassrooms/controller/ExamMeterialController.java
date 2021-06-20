package com.online.videostreaming.classrooms.onlineclassrooms.controller;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.online.videostreaming.classrooms.onlineclassrooms.entity.QuestionAnswerEntity;
import com.online.videostreaming.classrooms.onlineclassrooms.enums.Batch;
import com.online.videostreaming.classrooms.onlineclassrooms.enums.CourseCategory;
import com.online.videostreaming.classrooms.onlineclassrooms.enums.CourseCategory2;
import com.online.videostreaming.classrooms.onlineclassrooms.forms.MetrialsAnswerForm;
import com.online.videostreaming.classrooms.onlineclassrooms.forms.MetrialsQuestionForm;
import com.online.videostreaming.classrooms.onlineclassrooms.forms.QuestionAnswerViewForm;
import com.online.videostreaming.classrooms.onlineclassrooms.serviceImpl.RandomGeneratorImpl;
import com.online.videostreaming.classrooms.onlineclassrooms.services.QuestionAnswerService;
import com.online.videostreaming.classrooms.onlineclassrooms.services.RandomGenerator;
@Controller
public class ExamMeterialController {
	private static final int DEFAULT_RANDOM_LENGTH = 10;
	private RandomGenerator randomGenerator;
	@Autowired
    ServletContext context;
	@Autowired
	private QuestionAnswerService questionAnswerService;
	@RequestMapping(value = "/upload-exam-meterials", method = RequestMethod.GET)
	public String meterialGetPage(@ModelAttribute("metrialsQuestionForm") MetrialsQuestionForm metrialsQuestionForm,Model model, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		model.addAttribute("batch", Batch.mappings.entrySet()
	            .stream()
	            .sorted((Map.Entry.<Integer, String>comparingByValue().reversed()))
	            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new)));

		return "upload-exam-question-meterials";

	}
	
	@RequestMapping(value = "/upload-exam-meterials", method = RequestMethod.POST)
	public String meterialPostPage(@ModelAttribute("metrialsQuestionForm") MetrialsQuestionForm metrialsQuestionForm,Model model, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
if(metrialsQuestionForm.getMetrialFileName().getContentType().toLowerCase().equals("application/pdf")) {
	
	if (metrialsQuestionForm.getMetrialFileName() != null && !metrialsQuestionForm.getMetrialFileName().isEmpty()) {
        String random=null;
		randomGenerator=new RandomGeneratorImpl(DEFAULT_RANDOM_LENGTH);
		random=randomGenerator.generateToken();
		

		StringBuilder dirPath = new StringBuilder().append(File.separator).append("resources").append(File.separator);

		StringBuilder pathtostring = new StringBuilder().append(context.getRealPath(dirPath.toString())).append(File.separator).append("MetrialsUploads").append(File.separator);
	
		Path pathupload = Paths.get(pathtostring.toString());
		if (!Files.exists(pathupload)) {
			try {
				Files.createDirectories(pathupload);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		StringBuilder idpathtostring = new StringBuilder().append(pathtostring).append("QuestionSheets")
				.append(File.separator);
		Path pathId = Paths.get(idpathtostring.toString());
		if (!Files.exists(pathId)) {
			try {
				Files.createDirectories(pathId);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		StringBuilder questionpathtostring = new StringBuilder().append(idpathtostring.toString()).append(random).append(File.separator);
		Path pathQuestion = Paths.get(questionpathtostring.toString());
		if (!Files.exists(pathQuestion)) {
			try {
				Files.createDirectories(pathQuestion);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		

		

		 try {
			 
		        Files.write(Paths.get(questionpathtostring.toString() + random+"."+FilenameUtils.getExtension(metrialsQuestionForm.getMetrialFileName().getOriginalFilename())),metrialsQuestionForm.getMetrialFileName().getBytes());
	            	
	            QuestionAnswerEntity questionAnswerEntity=new QuestionAnswerEntity();
	            questionAnswerEntity.setMeterialTitle(metrialsQuestionForm.getMetrialTitle());
	            questionAnswerEntity.setMeterialName(metrialsQuestionForm.getMetrialName());
	            questionAnswerEntity.setCourseCategory(metrialsQuestionForm.getCourseCategory());
	            questionAnswerEntity.setBatch(metrialsQuestionForm.getBatch().toString());
	            questionAnswerEntity.setDescription(metrialsQuestionForm.getDescription());
	            questionAnswerEntity.setQuestionFileName(metrialsQuestionForm.getMetrialFileName().getOriginalFilename());
	            questionAnswerEntity.setQuestionFolderPath("/resources/MetrialsUploads/QuestionSheets/"+random+"/");
	            questionAnswerEntity.setQuestionFileExt(FilenameUtils.getExtension(metrialsQuestionForm.getMetrialFileName().getOriginalFilename()));
	            questionAnswerEntity.setQuestionFolderId(random);
	            questionAnswerEntity.setQuestionCreatedby("ADMIN");
	            questionAnswerEntity.setQuestionCreatedDate(Timestamp.valueOf(LocalDateTime.now()));
	            questionAnswerEntity.setAnswered(false);
	           int saveCount= questionAnswerService.uploadQuestionFile(questionAnswerEntity);
		       
	           
	           if(saveCount==0) {
	        	   
	        	   model.addAttribute(com.online.videostreaming.classrooms.onlineclassrooms.constants.Constants.SUCCESS_KEY,
		                    "You successfully uploaded "+metrialsQuestionForm.getMetrialFileName().getOriginalFilename()); 
	           }else if(saveCount==1) {
	        	   
	        	   model.addAttribute(com.online.videostreaming.classrooms.onlineclassrooms.constants.Constants.ERROR_KEY,
		                    "You un-successfully not uploaded "+ metrialsQuestionForm.getMetrialFileName().getOriginalFilename() ); 
	        	   
	           }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		
		
		
		
	
	
	
}
	
}else {
	MetrialsQuestionForm metrialsQuestionForm2=new MetrialsQuestionForm();
	model.addAttribute("metrialsQuestionForm",metrialsQuestionForm2);
	model.addAttribute(com.online.videostreaming.classrooms.onlineclassrooms.constants.Constants.ERROR_KEY,
             "You can upload only PDF file. Please choose PDF file for Upload" );
	
}
		
		
model.addAttribute("batch", Batch.mappings.entrySet()
        .stream()
        .sorted((Map.Entry.<Integer, String>comparingByValue().reversed()))
        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new)));
		
		return "upload-exam-question-meterials";

	}
	@RequestMapping(value = "/exam-answer-metrials", method = RequestMethod.GET)
	public String meterialAnsGetPage(@ModelAttribute("metrialsAnswerForm") MetrialsAnswerForm metrialsAnswerForm,Model model, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		 List<QuestionAnswerEntity> questionlist =questionAnswerService.getAllUploadedQuestionAnswers();
		 if(questionlist!=null && questionlist.size()!=0) {
			 List<QuestionAnswerViewForm> questionAnswerViewFormList=new ArrayList<QuestionAnswerViewForm>();
			 questionAnswerViewFormList= questionlist.stream().map(obj->{
				 QuestionAnswerViewForm questionAnswerViewForm = new QuestionAnswerViewForm();
				 questionAnswerViewForm.setQuestionAnswerId(obj.getQuestionAnswerId());
				 questionAnswerViewForm.setMeterialName(obj.getMeterialName());
				 questionAnswerViewForm.setMeterialTitle(obj.getMeterialTitle());
				 
				 if(Integer.parseInt(obj.getBatch())==1 || Integer.parseInt(obj.getBatch()) ==2 ) {
						
					 questionAnswerViewForm.setCourseCategory(CourseCategory.mappings.get(obj.getCourseCategory()));
						
						
					}else if(Integer.parseInt(obj.getBatch())==3 || Integer.parseInt(obj.getBatch()) ==4 ) {
						
						
						questionAnswerViewForm.setCourseCategory(CourseCategory2.mappings.get(obj.getCourseCategory()));
						
					}
				 
				 questionAnswerViewForm.setBatch(Batch.mappings.get(Integer.parseInt(obj.getBatch())));
				 questionAnswerViewForm.setDescription(obj.getDescription().length()>400?obj.getDescription().substring(0, 400)+"....":obj.getDescription() );
				 questionAnswerViewForm.setQuestionFileName(obj.getQuestionFileName());
				 questionAnswerViewForm.setQuestionFolderId(obj.getQuestionFolderId());
				 questionAnswerViewForm.setQuestionFileExt(obj.getQuestionFileExt());
				 questionAnswerViewForm.setQuestionCreatedDate(obj.getQuestionCreatedDate());
				 questionAnswerViewForm.setQuestionCreatedby(obj.getQuestionCreatedby());
				 questionAnswerViewForm.setQuestionFolderPath(obj.getQuestionFolderPath());
				 questionAnswerViewForm.setAnswerCreatedByEmail(obj.getAnswerCreatedByEmail());
				 questionAnswerViewForm.setAnswerCreatedByUserId(obj.getAnswerCreatedByUserId());
				 questionAnswerViewForm.setAnswerCreatedDate(obj.getAnswerCreatedDate());
				 questionAnswerViewForm.setAnswerGiven(obj.isAnswered());
				 questionAnswerViewForm.setAnswerFileExt(obj.getAnswerFileExt());
				 questionAnswerViewForm.setAnswerFileName(obj.getAnswerFileName());
				 questionAnswerViewForm.setAnswerFolderId(obj.getAnswerFolderId());
				 questionAnswerViewForm.setAnswerFolderPath(obj.getAnswerFolderPath());
				 
				 return questionAnswerViewForm;
				 
			 }).collect(Collectors.toList()); 
			 model.addAttribute("questionlist",questionAnswerViewFormList);
		 }
		 
		
		
		return "upload-exam-answer-meterials";

	}
	
	@RequestMapping(value = "/exam-answer-metrials", method = RequestMethod.POST)
	public String meterialAnsPostPage(@ModelAttribute("metrialsAnswerForm") MetrialsAnswerForm metrialsAnswerForm,Model model, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		

		
if(metrialsAnswerForm.getAnswerFileName().getContentType().toLowerCase().equals("application/pdf")) {
		
	if(metrialsAnswerForm.getQuestionAnswerId()!=null) {
		 Optional<QuestionAnswerEntity> questionAnswerEntity=Optional.ofNullable(new QuestionAnswerEntity());
		 questionAnswerEntity= questionAnswerService.getUploadedQuestionAnswersById(metrialsAnswerForm.getQuestionAnswerId());
		 
		if(questionAnswerEntity.isPresent()) {
			
			
			if (metrialsAnswerForm.getAnswerFileName() != null && !metrialsAnswerForm.getAnswerFileName().isEmpty()) {
		        String random=null;
				randomGenerator=new RandomGeneratorImpl(DEFAULT_RANDOM_LENGTH);
				random=randomGenerator.generateToken();
				

				StringBuilder dirPath = new StringBuilder().append(File.separator).append("resources").append(File.separator);

				StringBuilder pathtostring = new StringBuilder().append(context.getRealPath(dirPath.toString())).append(File.separator).append("MetrialsUploads").append(File.separator);
			
				Path pathupload = Paths.get(pathtostring.toString());
				if (!Files.exists(pathupload)) {
					try {
						Files.createDirectories(pathupload);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}

				StringBuilder idpathtostring = new StringBuilder().append(pathtostring).append("AnswersSheets")
						.append(File.separator);
				Path pathId = Paths.get(idpathtostring.toString());
				if (!Files.exists(pathId)) {
					try {
						Files.createDirectories(pathId);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}

				StringBuilder questionpathtostring = new StringBuilder().append(idpathtostring.toString()).append(random).append(File.separator);
				Path pathQuestion = Paths.get(questionpathtostring.toString());
				if (!Files.exists(pathQuestion)) {
					try {
						Files.createDirectories(pathQuestion);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				

				

				 try {
					 
				        Files.write(Paths.get(questionpathtostring.toString() + random+"."+FilenameUtils.getExtension(metrialsAnswerForm.getAnswerFileName().getOriginalFilename())),metrialsAnswerForm.getAnswerFileName().getBytes());
			            
			            
			            questionAnswerEntity.get().setAnswered(true);
			            questionAnswerEntity.get().setAnswerCreatedByEmail(metrialsAnswerForm.getEmailId());
			            questionAnswerEntity.get().setAnswerCreatedByUserId(metrialsAnswerForm.getUserId());
			            questionAnswerEntity.get().setAnswerCreatedDate(Timestamp.valueOf(LocalDateTime.now()));
			            questionAnswerEntity.get().setAnswerFileExt(FilenameUtils.getExtension(metrialsAnswerForm.getAnswerFileName().getOriginalFilename()));
			            questionAnswerEntity.get().setAnswerFileName(metrialsAnswerForm.getAnswerFileName().getOriginalFilename());
			            questionAnswerEntity.get().setAnswerFolderId(random);
			            questionAnswerEntity.get().setAnswerFolderPath("/resources/MetrialsUploads/AnswersSheets/"+random+"/");
			            
			           int saveCount= questionAnswerService.uploadAnswerFile(questionAnswerEntity.get());
				       
			           
			           if(saveCount==0) {
			        	   
			        	   model.addAttribute(com.online.videostreaming.classrooms.onlineclassrooms.constants.Constants.SUCCESS_KEY,
				                    "You successfully uploaded "+metrialsAnswerForm.getAnswerFileName().getOriginalFilename()); 
			           }else if(saveCount==1) {
			        	   
			        	   model.addAttribute(com.online.videostreaming.classrooms.onlineclassrooms.constants.Constants.ERROR_KEY,
				                    "You un-successfully not uploaded "+ metrialsAnswerForm.getAnswerFileName().getOriginalFilename() ); 
			        	   
			           }
			        } catch (IOException e) {
			            e.printStackTrace();
			        }
				
				
				
				
			
			
			
		}
			
		}
		
		
	}
	
	
	
	
	
}else {
	MetrialsQuestionForm metrialsQuestionForm2=new MetrialsQuestionForm();
	model.addAttribute("metrialsQuestionForm",metrialsQuestionForm2);
	model.addAttribute(com.online.videostreaming.classrooms.onlineclassrooms.constants.Constants.ERROR_KEY,
             "You can upload only PDF file. Please choose PDF file for Upload" );
	
}
		
List<QuestionAnswerEntity> questionlist =questionAnswerService.getAllUploadedQuestionAnswers();
if(questionlist!=null && questionlist.size()!=0) {
	 List<QuestionAnswerViewForm> questionAnswerViewFormList=new ArrayList<QuestionAnswerViewForm>();
	 questionAnswerViewFormList= questionlist.stream().map(obj->{
		 QuestionAnswerViewForm questionAnswerViewForm = new QuestionAnswerViewForm();
		 questionAnswerViewForm.setQuestionAnswerId(obj.getQuestionAnswerId());
		 questionAnswerViewForm.setMeterialName(obj.getMeterialName());
		 questionAnswerViewForm.setMeterialTitle(obj.getMeterialTitle());
		 
		 if(Integer.parseInt(obj.getBatch())==1 || Integer.parseInt(obj.getBatch()) ==2 ) {
				
			 questionAnswerViewForm.setCourseCategory(CourseCategory.mappings.get(obj.getCourseCategory()));
				
				
			}else if(Integer.parseInt(obj.getBatch())==3 || Integer.parseInt(obj.getBatch()) ==4 ) {
				
				
				questionAnswerViewForm.setCourseCategory(CourseCategory2.mappings.get(obj.getCourseCategory()));
				
			}
		 
		 questionAnswerViewForm.setBatch(Batch.mappings.get(Integer.parseInt(obj.getBatch())));
		 questionAnswerViewForm.setDescription(obj.getDescription().length()>400?obj.getDescription().substring(0, 400)+"....":obj.getDescription() );
		 questionAnswerViewForm.setQuestionFileName(obj.getQuestionFileName());
		 questionAnswerViewForm.setQuestionFolderId(obj.getQuestionFolderId());
		 questionAnswerViewForm.setQuestionFileExt(obj.getQuestionFileExt());
		 questionAnswerViewForm.setQuestionCreatedDate(obj.getQuestionCreatedDate());
		 questionAnswerViewForm.setQuestionCreatedby(obj.getQuestionCreatedby());
		 questionAnswerViewForm.setQuestionFolderPath(obj.getQuestionFolderPath());
		 questionAnswerViewForm.setAnswerCreatedByEmail(obj.getAnswerCreatedByEmail());
		 questionAnswerViewForm.setAnswerCreatedByUserId(obj.getAnswerCreatedByUserId());
		 questionAnswerViewForm.setAnswerCreatedDate(obj.getAnswerCreatedDate());
		 questionAnswerViewForm.setAnswerGiven(obj.isAnswered());
		 questionAnswerViewForm.setAnswerFileExt(obj.getAnswerFileExt());
		 questionAnswerViewForm.setAnswerFileName(obj.getAnswerFileName());
		 questionAnswerViewForm.setAnswerFolderId(obj.getAnswerFolderId());
		 questionAnswerViewForm.setAnswerFolderPath(obj.getAnswerFolderPath());
		 
		 return questionAnswerViewForm;
		 
	 }).collect(Collectors.toList()); 
	 model.addAttribute("questionlist",questionAnswerViewFormList);
}

		
		return "upload-exam-answer-meterials";

	

	}
	
	@RequestMapping(value = "/view-exam-question-answer-metrials", method = RequestMethod.GET)
	public String meterialQestAnsGetPage(Model model, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		 List<QuestionAnswerEntity> questionlist =questionAnswerService.getAllUploadedQuestionAnswers();
		 if(questionlist!=null && questionlist.size()!=0) {
			 List<QuestionAnswerViewForm> questionAnswerViewFormList=new ArrayList<QuestionAnswerViewForm>();
			 questionAnswerViewFormList= questionlist.stream().map(obj->{
				 QuestionAnswerViewForm questionAnswerViewForm = new QuestionAnswerViewForm();
				 questionAnswerViewForm.setQuestionAnswerId(obj.getQuestionAnswerId());
				 questionAnswerViewForm.setMeterialName(obj.getMeterialName());
				 questionAnswerViewForm.setMeterialTitle(obj.getMeterialTitle());
				 
				 if(Integer.parseInt(obj.getBatch())==1 || Integer.parseInt(obj.getBatch()) ==2 ) {
						
					 questionAnswerViewForm.setCourseCategory(CourseCategory.mappings.get(obj.getCourseCategory()));
						
						
					}else if(Integer.parseInt(obj.getBatch())==3 || Integer.parseInt(obj.getBatch()) ==4 ) {
						
						
						questionAnswerViewForm.setCourseCategory(CourseCategory2.mappings.get(obj.getCourseCategory()));
						
					}
				 
				 questionAnswerViewForm.setBatch(Batch.mappings.get(Integer.parseInt(obj.getBatch())));
				 questionAnswerViewForm.setDescription(obj.getDescription().length()>400?obj.getDescription().substring(0, 400)+"....":obj.getDescription() );
				 questionAnswerViewForm.setQuestionFileName(obj.getQuestionFileName());
				 questionAnswerViewForm.setQuestionFolderId(obj.getQuestionFolderId());
				 questionAnswerViewForm.setQuestionFileExt(obj.getQuestionFileExt());
				 questionAnswerViewForm.setQuestionCreatedDate(obj.getQuestionCreatedDate());
				 questionAnswerViewForm.setQuestionCreatedby(obj.getQuestionCreatedby());
				 questionAnswerViewForm.setQuestionFolderPath(obj.getQuestionFolderPath());
				 questionAnswerViewForm.setAnswerCreatedByEmail(obj.getAnswerCreatedByEmail());
				 questionAnswerViewForm.setAnswerCreatedByUserId(obj.getAnswerCreatedByUserId());
				 questionAnswerViewForm.setAnswerCreatedDate(obj.getAnswerCreatedDate());
				 questionAnswerViewForm.setAnswerGiven(obj.isAnswered());
				 questionAnswerViewForm.setAnswerFileExt(obj.getAnswerFileExt());
				 questionAnswerViewForm.setAnswerFileName(obj.getAnswerFileName());
				 questionAnswerViewForm.setAnswerFolderId(obj.getAnswerFolderId());
				 questionAnswerViewForm.setAnswerFolderPath(obj.getAnswerFolderPath());
				 
				 return questionAnswerViewForm;
				 
			 }).collect(Collectors.toList()); 
			 model.addAttribute("finalList",questionAnswerViewFormList);
		 }
		
		return "view-edit-question-answer-page";

	}
	@RequestMapping(value = "/downloadSheets", method = RequestMethod.GET)
	public ResponseEntity downloadSheets(@RequestParam(value = "folderId",required = true)String folderId,
			@RequestParam(value = "action",required = true)String action,Model model, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
				
		
		Optional<QuestionAnswerEntity> questionAnswerEntity=questionAnswerService.downloadSheets(folderId, action);
		if(questionAnswerEntity.isPresent()) {
			
			
			if(action.trim().equals("QUESTION")) {
				
				Path path = Paths.get(context.getRealPath(questionAnswerEntity.get().getQuestionFolderPath() + questionAnswerEntity.get().getQuestionFolderId()+"."+questionAnswerEntity.get().getQuestionFileExt()));
				Resource resource = null;
				try {
					resource = new UrlResource(path.toUri());
				} catch (MalformedURLException e) {
					e.printStackTrace();
				}
				return ResponseEntity.ok()
						.contentType(MediaType.parseMediaType("application/pdf"))
						.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
						.body(resource);
				
			}else if(action.trim().equals("ANSWER")) {
				
				Path path = Paths.get(context.getRealPath(questionAnswerEntity.get().getAnswerFolderPath() + questionAnswerEntity.get().getAnswerFolderId()+"."+questionAnswerEntity.get().getAnswerFileExt()));
				
				Resource resource = null;
				try {
					resource = new UrlResource(path.toUri());
				} catch (MalformedURLException e) {
					e.printStackTrace();
				}
				return ResponseEntity.ok()
						.contentType(MediaType.parseMediaType("application/pdf"))
						.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
						.body(resource);
				
			}
			
		}
		
		
		
		return ResponseEntity.ok()
				.contentType(MediaType.parseMediaType("application/pdf"))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=File-Not-Exist")
				.body("File Not Exist...Please contact to administrator");
		
		
		
		
	}
	
}
