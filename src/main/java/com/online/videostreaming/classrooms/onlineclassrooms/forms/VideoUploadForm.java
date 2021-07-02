package com.online.videostreaming.classrooms.onlineclassrooms.forms;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class VideoUploadForm {

	
	private String videoName;
	private String videoTitle;
	
	private Integer courseCategory;
	private String description;
	private String batch;
	private MultipartFile chapterFileName;
	private String thumbnailPath;
	private String thumbnailFileName;
	private String encryptdata;
	private String _csrf;
	
}
