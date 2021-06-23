package com.online.videostreaming.classrooms.onlineclassrooms.serviceImpl;

import java.io.File;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.videostreaming.classrooms.onlineclassrooms.dao.QuestionAnswerDao;
import com.online.videostreaming.classrooms.onlineclassrooms.entity.QuestionAnswerEntity;
import com.online.videostreaming.classrooms.onlineclassrooms.entity.QuestionMasterEntity;
@Service
public  class QuestionAnswerServiceImpl
		implements com.online.videostreaming.classrooms.onlineclassrooms.services.QuestionAnswerService {
	   @Autowired
		private QuestionAnswerDao questionAnswerDao;
	   @Autowired
	    ServletContext context;
	@Override
	public int uploadQuestionFile(QuestionMasterEntity questionAnswerEntity) throws Exception {
		return questionAnswerDao.uploadQuestionFile(questionAnswerEntity);
	}

	@Override
	public int uploadAnswerFile(QuestionAnswerEntity questionAnswerEntity) throws Exception {
		return questionAnswerDao.uploadAnswerFile(questionAnswerEntity);
	}

	@Override
	public List<QuestionAnswerEntity> getAllUploadedQuestionAnswers() throws Exception {
		return questionAnswerDao.getAllUploadedQuestionAnswers();
	}

	@Override
	public String deleteFolderAndMeterialsById(Integer idToDelete) throws Exception {

		boolean isDeleted=false;
		try
		{
			
			QuestionAnswerEntity obj =  questionAnswerDao.getMetrialsDetailsById(idToDelete);
			if(obj!=null) {
				
				boolean check = questionAnswerDao.deleteFolderAndMeterialsById(idToDelete);
				if(check)
				{
					
					isDeleted=true;
					if(obj.getQuestionFileName()!=null )
					{
						File questionfile = new File(context.getRealPath(obj.getQuestionFolderPath())+obj.getQuestionFolderId()+"."+obj.getQuestionFileExt());
						File answerfile = new File(context.getRealPath(obj.getAnswerFolderPath())+obj.getAnswerFolderId()+"."+obj.getAnswerFileExt());
						File dir = new File(context.getRealPath("/resources/MetrialsUploads/QuestionSheets/"+obj.getQuestionFolderId()+"/"));
						File dir2 = new File(context.getRealPath("/resources/MetrialsUploads/AnswersSheets/"+obj.getAnswerFolderId()+"/"));
						
						
						if(questionfile.exists())
						{
							questionfile.delete();
							
						}
						if(answerfile.exists())
						{
							answerfile.delete();
							
						}
						FileUtils.deleteDirectory(dir);
						FileUtils.deleteDirectory(dir2);
						
					}
				}
				
			}
			
		}
		catch(Exception e)
		{
			isDeleted=false;
		}
		
		
		return isDeleted==true?"Record deleted Successfully":"Record not deleted Successfully";
	
	}

	@Override
	public Optional<QuestionAnswerEntity> getUploadedQuestionAnswersById(Integer id) throws Exception {
		return questionAnswerDao.getUploadedQuestionAnswersById(id);
	}

	@Override
	public Optional<QuestionAnswerEntity> downloadSheets(String folderId, String action) throws Exception {
		
		
		return questionAnswerDao.getQuestionAnswerDetailsByFolderId(folderId, action);
	}

	@Override
	public String reSubmitAnswerSheet(String answerFolderId) throws Exception {
		
		return questionAnswerDao.reSubmitAnswerSheet(answerFolderId);
	}

	@Override
	public List<QuestionMasterEntity> getAllUploadedQuestions() throws Exception {
		return questionAnswerDao.getAllUploadedQuestions();
	}

	@Override
	public Optional<QuestionMasterEntity> downloadQuestionSheets(String folderId, String action) throws Exception {
		return questionAnswerDao.getQuestionDetailsByFolderId(folderId, action);
	}
	
	
	
 

}
