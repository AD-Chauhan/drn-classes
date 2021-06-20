package com.online.videostreaming.classrooms.onlineclassrooms.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
@Entity
@Table(name="question_answer_entity")
public class QuestionAnswerEntity implements Serializable {

	

	private static final long serialVersionUID = 1L;
	@GenericGenerator(name = "sequence", strategy = "sequence", parameters = {
			@Parameter(name = "sequence", value = "question_answer_entity_seq") })
	@Id
	@GeneratedValue(generator = "sequence")
	@Column(name = "questionAnswer_id")
	private Integer questionAnswerId;
	
	@Column(name="meterial_name")
	private String meterialName;
	
	@Column(name="meterial_title")
	private String meterialTitle;
	
	@Column(name="course_category")
	private Integer courseCategory;
	
	@Column(name="description")
	private String description;
	
	@Column(name="batch")
	private String batch;
	
	
	@Column(name="question_folder_path")
	private String questionFolderPath;
	

	@Column(name="question_file_name")
	private String questionFileName;
	
	@Column(name="question_file_ext")
	private String questionFileExt;
	
	@Column(name="question_created_by")
	private String questionCreatedby;
	
	@Column(name="question_created_date")
	private Timestamp  questionCreatedDate;
	
	@Column(name="question_folder_id")
	private String questionFolderId;
	
	
	
	@Column(name="answer_folder_path")
	private String answerFolderPath;
	

	@Column(name="answer_file_name")
	private String answerFileName;
	
	@Column(name="answer_file_ext")
	private String answerFileExt;
	
	@Column(name="is_answered")
	private boolean isAnswered;
	
	
	@Column(name="answer_folder_id")
	private String answerFolderId;
	
	@Column(name = "answer_created_by_user_id")
	private Integer answerCreatedByUserId;
	
	@Column(name="answer_created_by_email")
	private String answerCreatedByEmail;
	
	@Column(name="answer_created_date")
	private Timestamp  answerCreatedDate;

	public QuestionAnswerEntity() {
		super();
	}

	public QuestionAnswerEntity(Integer questionAnswerId, String meterialName, String meterialTitle,
			Integer courseCategory, String description, String batch, String questionFolderPath,
			String questionFileName, String questionFileExt, String questionCreatedby, Timestamp questionCreatedDate,
			String questionFolderId, String answerFolderPath, String answerFileName, String answerFileExt,
			boolean isAnswered, String answerFolderId, Integer answerCreatedByUserId, String answerCreatedByEmail,
			Timestamp answerCreatedDate) {
		super();
		this.questionAnswerId = questionAnswerId;
		this.meterialName = meterialName;
		this.meterialTitle = meterialTitle;
		this.courseCategory = courseCategory;
		this.description = description;
		this.batch = batch;
		this.questionFolderPath = questionFolderPath;
		this.questionFileName = questionFileName;
		this.questionFileExt = questionFileExt;
		this.questionCreatedby = questionCreatedby;
		this.questionCreatedDate = questionCreatedDate;
		this.questionFolderId = questionFolderId;
		this.answerFolderPath = answerFolderPath;
		this.answerFileName = answerFileName;
		this.answerFileExt = answerFileExt;
		this.isAnswered = isAnswered;
		this.answerFolderId = answerFolderId;
		this.answerCreatedByUserId = answerCreatedByUserId;
		this.answerCreatedByEmail = answerCreatedByEmail;
		this.answerCreatedDate = answerCreatedDate;
	}

	public Integer getQuestionAnswerId() {
		return questionAnswerId;
	}

	public void setQuestionAnswerId(Integer questionAnswerId) {
		this.questionAnswerId = questionAnswerId;
	}

	public String getMeterialName() {
		return meterialName;
	}

	public void setMeterialName(String meterialName) {
		this.meterialName = meterialName;
	}

	public String getMeterialTitle() {
		return meterialTitle;
	}

	public void setMeterialTitle(String meterialTitle) {
		this.meterialTitle = meterialTitle;
	}

	public Integer getCourseCategory() {
		return courseCategory;
	}

	public void setCourseCategory(Integer courseCategory) {
		this.courseCategory = courseCategory;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getBatch() {
		return batch;
	}

	public void setBatch(String batch) {
		this.batch = batch;
	}

	public String getQuestionFolderPath() {
		return questionFolderPath;
	}

	public void setQuestionFolderPath(String questionFolderPath) {
		this.questionFolderPath = questionFolderPath;
	}

	public String getQuestionFileName() {
		return questionFileName;
	}

	public void setQuestionFileName(String questionFileName) {
		this.questionFileName = questionFileName;
	}

	public String getQuestionFileExt() {
		return questionFileExt;
	}

	public void setQuestionFileExt(String questionFileExt) {
		this.questionFileExt = questionFileExt;
	}

	public String getQuestionCreatedby() {
		return questionCreatedby;
	}

	public void setQuestionCreatedby(String questionCreatedby) {
		this.questionCreatedby = questionCreatedby;
	}

	public Timestamp getQuestionCreatedDate() {
		return questionCreatedDate;
	}

	public void setQuestionCreatedDate(Timestamp questionCreatedDate) {
		this.questionCreatedDate = questionCreatedDate;
	}

	public String getQuestionFolderId() {
		return questionFolderId;
	}

	public void setQuestionFolderId(String questionFolderId) {
		this.questionFolderId = questionFolderId;
	}

	public String getAnswerFolderPath() {
		return answerFolderPath;
	}

	public void setAnswerFolderPath(String answerFolderPath) {
		this.answerFolderPath = answerFolderPath;
	}

	public String getAnswerFileName() {
		return answerFileName;
	}

	public void setAnswerFileName(String answerFileName) {
		this.answerFileName = answerFileName;
	}

	public String getAnswerFileExt() {
		return answerFileExt;
	}

	public void setAnswerFileExt(String answerFileExt) {
		this.answerFileExt = answerFileExt;
	}

	public boolean isAnswered() {
		return isAnswered;
	}

	public void setAnswered(boolean isAnswered) {
		this.isAnswered = isAnswered;
	}

	public String getAnswerFolderId() {
		return answerFolderId;
	}

	public void setAnswerFolderId(String answerFolderId) {
		this.answerFolderId = answerFolderId;
	}

	public Integer getAnswerCreatedByUserId() {
		return answerCreatedByUserId;
	}

	public void setAnswerCreatedByUserId(Integer answerCreatedByUserId) {
		this.answerCreatedByUserId = answerCreatedByUserId;
	}

	public String getAnswerCreatedByEmail() {
		return answerCreatedByEmail;
	}

	public void setAnswerCreatedByEmail(String answerCreatedByEmail) {
		this.answerCreatedByEmail = answerCreatedByEmail;
	}

	public Timestamp getAnswerCreatedDate() {
		return answerCreatedDate;
	}

	public void setAnswerCreatedDate(Timestamp answerCreatedDate) {
		this.answerCreatedDate = answerCreatedDate;
	}
	
	
	
	
	
	
}
