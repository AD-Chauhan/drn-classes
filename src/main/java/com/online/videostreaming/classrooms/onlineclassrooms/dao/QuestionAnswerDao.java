package com.online.videostreaming.classrooms.onlineclassrooms.dao;

import java.util.List;
import java.util.Optional;

import com.online.videostreaming.classrooms.onlineclassrooms.entity.QuestionAnswerEntity;

public interface QuestionAnswerDao {

	
	 public int uploadQuestionFile(QuestionAnswerEntity questionAnswerEntity) throws Exception;
	 public int uploadAnswerFile(QuestionAnswerEntity questionAnswerEntity) throws Exception;
	 public List<QuestionAnswerEntity> getAllUploadedQuestionAnswers() throws Exception;
	 public boolean deleteFolderAndMeterialsById(Integer idToDelete) throws Exception;
	 public QuestionAnswerEntity getMetrialsDetailsById(Integer Id) throws Exception;
	 public Optional<QuestionAnswerEntity> getUploadedQuestionAnswersById(Integer id) throws Exception;
	 public Optional<QuestionAnswerEntity> getQuestionAnswerDetailsByFolderId(String folderId, String action) throws Exception ;
	 public String reSubmitAnswerSheet(String answerFolderId) throws Exception;
}
