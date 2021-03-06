package com.online.videostreaming.classrooms.onlineclassrooms.dao;

import java.util.List;
import java.util.Optional;

import com.online.videostreaming.classrooms.onlineclassrooms.entity.QuestionAnswerEntity;
import com.online.videostreaming.classrooms.onlineclassrooms.entity.QuestionMasterEntity;
import com.online.videostreaming.classrooms.onlineclassrooms.forms.SearchForm;

public interface QuestionAnswerDao {

	
	 public int uploadQuestionFile(QuestionMasterEntity questionAnswerEntity) throws Exception;
	 public int uploadAnswerFile(QuestionAnswerEntity questionAnswerEntity) throws Exception;
	 public List<QuestionAnswerEntity> getAllUploadedQuestionAnswers() throws Exception;
	 public boolean deleteFolderAndMeterialsById(Integer idToDelete) throws Exception;
	 public QuestionAnswerEntity getMetrialsDetailsById(Integer Id) throws Exception;
	 public Optional<QuestionAnswerEntity> getUploadedQuestionAnswersById(Integer id) throws Exception;
	 public Optional<QuestionAnswerEntity> getQuestionAnswerDetailsByFolderId(String folderId, String action) throws Exception ;
	 public String reSubmitAnswerSheet(String answerFolderId) throws Exception;
	 public List<QuestionMasterEntity> getAllUploadedQuestions() throws Exception;
	 public Optional<QuestionMasterEntity> downloadQuestionSheets(String folderId,String action) throws Exception;
	 public Optional<QuestionMasterEntity> getQuestionDetailsByFolderId(String folderId, String action) throws Exception ;
	 public QuestionMasterEntity getAllUploadedQuestionsById(Integer questionId) throws Exception;
	 public QuestionAnswerEntity getAllUploadedQuestionAnswersById(Integer id,String email,String rollno) throws Exception;
	 public boolean deleteFolderAndQuestionById(Integer idToDelete) throws Exception;
	 public List<QuestionAnswerEntity> getAllUploadedQuestionAnswersByKeyword(SearchForm searchForm)throws Exception;
}
