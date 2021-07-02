package com.online.videostreaming.classrooms.onlineclassrooms.forms;

import java.sql.Timestamp;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class QuestionAnswerViewForm {

    private Integer questionAnswerId;
	private String meterialName;
	private String meterialTitle;
	private String courseCategory;
	private String description;
	private String batch;
	private String questionFolderPath;
	private String questionFileName;
	private String questionFileExt;
	private String questionCreatedby;
	private Timestamp  questionCreatedDate;
	private String questionFolderId;
	private String answerFolderPath;
	private String answerFileName;
	private String answerFileExt;
	private boolean answerGiven;
	private String answerFolderId;
	private String answerCreatedByName;
	private String answerCreatedByRollNo;
	private String answerCreatedByEmail;
	private Timestamp  answerCreatedDate;
	private String _csrf;
	
	
}
