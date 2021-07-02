package com.online.videostreaming.classrooms.onlineclassrooms.services;

import java.util.List;
import java.util.Optional;

import com.online.videostreaming.classrooms.onlineclassrooms.entity.QuestionAnswerEntity;
import com.online.videostreaming.classrooms.onlineclassrooms.entity.QuestionMasterEntity;
import com.online.videostreaming.classrooms.onlineclassrooms.forms.SearchForm;

public interface QuestionAnswerService {

	
	 public int uploadQuestionFile(QuestionMasterEntity questionAnswerEntity) throws Exception;
	 public int uploadAnswerFile(QuestionAnswerEntity questionAnswerEntity) throws Exception;
	 public List<QuestionAnswerEntity> getAllUploadedQuestionAnswers() throws Exception;
	 public String deleteFolderAndMeterialsById(Integer idToDelete) throws Exception;
	 public Optional<QuestionAnswerEntity> getUploadedQuestionAnswersById(Integer id) throws Exception;
	 public Optional<QuestionAnswerEntity> downloadSheets(String folderId,String action) throws Exception;
	 public String reSubmitAnswerSheet(String answerFolderId) throws Exception; 
	 public List<QuestionMasterEntity> getAllUploadedQuestions() throws Exception;
	 public Optional<QuestionMasterEntity> downloadQuestionSheets(String folderId,String action) throws Exception;
	 public QuestionMasterEntity getAllUploadedQuestionsById(Integer questionId) throws Exception;
	 public QuestionAnswerEntity getAllUploadedQuestionAnswersById(Integer id,String email,String rollno) throws Exception;
	 public String deleteQuestionById(Integer idToDelete) throws Exception;
	 public List<QuestionAnswerEntity> getAllUploadedQuestionAnswersByKeyword(SearchForm searchForm)throws Exception;
	 
}
