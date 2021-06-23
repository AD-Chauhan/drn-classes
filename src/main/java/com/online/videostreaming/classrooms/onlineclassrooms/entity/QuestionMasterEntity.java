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
@Table(name="question_master_entity")
public class QuestionMasterEntity implements Serializable {

	

	private static final long serialVersionUID = 1L;
	@GenericGenerator(name = "sequence", strategy = "sequence", parameters = {
			@Parameter(name = "sequence", value = "question_master_entity_seq") })
	@Id
	@GeneratedValue(generator = "sequence")
	@Column(name = "question_id")
	private Integer questionId;
	
	@Column(name="question_name")
	private String questionName;
	
	@Column(name="question_title")
	private String questionTitle;
	
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

	public QuestionMasterEntity() {
		super();
	}

	
	
	
	public QuestionMasterEntity(Integer questionId, String questionName, String questionTitle, Integer courseCategory,
			String description, String batch, String questionFolderPath, String questionFileName,
			String questionFileExt, String questionCreatedby, Timestamp questionCreatedDate, String questionFolderId) {
		super();
		this.questionId = questionId;
		this.questionName = questionName;
		this.questionTitle = questionTitle;
		this.courseCategory = courseCategory;
		this.description = description;
		this.batch = batch;
		this.questionFolderPath = questionFolderPath;
		this.questionFileName = questionFileName;
		this.questionFileExt = questionFileExt;
		this.questionCreatedby = questionCreatedby;
		this.questionCreatedDate = questionCreatedDate;
		this.questionFolderId = questionFolderId;
	}




	public Integer getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}

	public String getQuestionName() {
		return questionName;
	}

	public void setQuestionName(String questionName) {
		this.questionName = questionName;
	}

	public String getQuestionTitle() {
		return questionTitle;
	}

	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
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
	
	
	

}
