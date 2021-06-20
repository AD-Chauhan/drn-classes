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
public class MetrialsAnswerForm {

	private Integer questionAnswerId;
	private Integer userId;
	private String emailId;
	private MultipartFile answerFileName;
	private String _csrf;
	
}
