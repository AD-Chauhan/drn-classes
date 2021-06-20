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
public class MetrialsQuestionForm {

	
	private String metrialTitle;
	private String metrialName;
	private Integer courseCategory;
	private String description;
	private Integer batch;
	private MultipartFile metrialFileName;
	private String _csrf;
	
}
