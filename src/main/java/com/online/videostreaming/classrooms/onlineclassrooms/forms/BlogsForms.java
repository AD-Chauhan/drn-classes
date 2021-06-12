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
public class BlogsForms {

	
	private String blogName;
	private String blogTitle;
	private String description;
	private String executionTime;
	private MultipartFile chapterFileName;
	
}
