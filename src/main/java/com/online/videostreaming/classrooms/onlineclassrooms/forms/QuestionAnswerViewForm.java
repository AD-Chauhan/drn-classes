package com.online.videostreaming.classrooms.onlineclassrooms.forms;

import java.sql.Timestamp;


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
	private Integer answerCreatedByUserId;
	private String answerCreatedByEmail;
	private Timestamp  answerCreatedDate;
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
	public String getCourseCategory() {
		return courseCategory;
	}
	public void setCourseCategory(String courseCategory) {
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
	
	public boolean isAnswerGiven() {
		return answerGiven;
	}
	public void setAnswerGiven(boolean answerGiven) {
		this.answerGiven = answerGiven;
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
