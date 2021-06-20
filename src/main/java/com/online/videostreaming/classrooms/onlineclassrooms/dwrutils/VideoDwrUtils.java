package com.online.videostreaming.classrooms.onlineclassrooms.dwrutils;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.online.videostreaming.classrooms.onlineclassrooms.enums.Batch;
import com.online.videostreaming.classrooms.onlineclassrooms.enums.CourseCategory;
import com.online.videostreaming.classrooms.onlineclassrooms.enums.CourseCategory2;
import com.online.videostreaming.classrooms.onlineclassrooms.services.QuestionAnswerService;
import com.online.videostreaming.classrooms.onlineclassrooms.services.VideoGalleryService;

public class VideoDwrUtils {

	@Autowired
	private VideoGalleryService videoGalleryService;
	@Autowired
	private QuestionAnswerService questionAnswerService;
	 public String deleteFolderAndVideoById(Integer idToDelete) throws Exception {
		
		 
		return  videoGalleryService.deleteFolderAndVideoById(idToDelete);
	}
	 
	 
	 public Map<Integer, String> getCourseCategory(Integer value) throws Exception {
			
		 
			if(value==1 || value ==2 ) {
				
				return CourseCategory.mappings.entrySet()
			    .stream()
			    .sorted((Map.Entry.<Integer, String>comparingByValue()))
			    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
				
				
				
			}else if(value==3 || value ==4 ) {
				
				return CourseCategory2.mappings.entrySet()
			    .stream()
			    .sorted((Map.Entry.<Integer, String>comparingByValue()))
			    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
				
				
				
			}
			return null;
		 
      }
	 
	 public Map<Integer, String> getAllBatchOrClasses() throws Exception {
			return Batch.mappings.entrySet()
		            .stream()
		            .sorted((Map.Entry.<Integer, String>comparingByValue().reversed()))
		            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
		 
   }
	
	 public String deleteFolderAndSheetsById(Integer idToDelete) throws Exception {
			
		 
			return  questionAnswerService.deleteFolderAndMeterialsById(idToDelete);
		}
	 
	 public String reSubmitAnswerSheet(String answerFolderId) throws Exception {
			
		 
			return  questionAnswerService.reSubmitAnswerSheet(answerFolderId);
		}
	  
	
}
