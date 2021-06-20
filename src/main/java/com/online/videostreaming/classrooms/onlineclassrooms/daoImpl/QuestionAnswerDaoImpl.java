package com.online.videostreaming.classrooms.onlineclassrooms.daoImpl;

import java.util.List;
import java.util.Optional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.online.videostreaming.classrooms.onlineclassrooms.dao.QuestionAnswerDao;
import com.online.videostreaming.classrooms.onlineclassrooms.entity.QuestionAnswerEntity;
import com.online.videostreaming.classrooms.onlineclassrooms.entity.UsersEntity;
import com.online.videostreaming.classrooms.onlineclassrooms.entity.VideoUploadEntity;
import com.online.videostreaming.classrooms.onlineclassrooms.utils.HibernateSessionUtils;
@Repository
@Transactional
public class QuestionAnswerDaoImpl extends HibernateSessionUtils implements QuestionAnswerDao {

	@Override
	public int uploadQuestionFile(QuestionAnswerEntity questionAnswerEntity) throws Exception {
int saveCount=0;
		
		try
		{
			Session session = currentSession();
			beginTransaction();
			session.save(questionAnswerEntity);
			
			commitTransaction();
		}
		catch(Exception e){
			rollbackTransaction();
			saveCount=1;
		}
		finally{
			closeSession();
		}
		return saveCount;
	}

	@Override
	public int uploadAnswerFile(QuestionAnswerEntity questionAnswerEntity) throws Exception {
int saveCount=0;
		
		try
		{
			Session session = currentSession();
			beginTransaction();
			session.update(questionAnswerEntity);
			
			commitTransaction();
		}
		catch(Exception e){
			rollbackTransaction();
			saveCount=1;
		}
		finally{
			closeSession();
		}
		return saveCount;
	}

	@Override
	public List<QuestionAnswerEntity> getAllUploadedQuestionAnswers() throws Exception {
try{
			
			
			Session session = currentSession();
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<QuestionAnswerEntity> criteria = builder.createQuery(QuestionAnswerEntity.class);
			Root<QuestionAnswerEntity> root = criteria.from(QuestionAnswerEntity.class);
			return session.createQuery(
	                 criteria.select(root).orderBy(builder.desc(root.get("questionAnswerId"))))
			           .getResultList();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
		finally
		{
			closeSession();
		}
	}

	@Override
	public boolean deleteFolderAndMeterialsById(Integer idToDelete) throws Exception {
		try
		{
			Session session = currentSession();
			beginTransaction();
			
			session.delete(session.get(QuestionAnswerEntity.class, idToDelete));
			commitTransaction();
			return true;
		}
		catch(Exception e){
			rollbackTransaction();
			throw e; 
		}
		finally{
			closeSession();
		}
	}

	@Override
	public QuestionAnswerEntity getMetrialsDetailsById(Integer Id) throws Exception {
		try{
			Session session = currentSession();
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<QuestionAnswerEntity> criteria = builder.createQuery(QuestionAnswerEntity.class);
			Root<QuestionAnswerEntity> root = criteria.from(QuestionAnswerEntity.class);
			return session.createQuery(
	                 criteria.select(root).where(builder.equal(root.get("questionAnswerId"), Id)))
			           .getSingleResult();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
		finally
		{
			closeSession();
		}
	}

	@Override
	public Optional<QuestionAnswerEntity> getUploadedQuestionAnswersById(Integer id) throws Exception {
		try {
			Session session = currentSession();
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<QuestionAnswerEntity> criteria = builder.createQuery(QuestionAnswerEntity.class);
			Root<QuestionAnswerEntity> root = criteria.from(QuestionAnswerEntity.class);
			return Optional.ofNullable(session.createQuery(
	                 criteria.select(root).where(builder.equal(root.get("questionAnswerId"), id))
	                 )
			           .getSingleResult());
			
		} catch (Exception e) {
			
			return null;
		}finally
		{
			closeSession();
		}
	}

	@Override
	public Optional<QuestionAnswerEntity> getQuestionAnswerDetailsByFolderId(String folderId, String action) throws Exception {
		
		if(action.trim().equals("QUESTION")) {
			try{
				Session session = currentSession();
				CriteriaBuilder builder = session.getCriteriaBuilder();
				CriteriaQuery<QuestionAnswerEntity> criteria = builder.createQuery(QuestionAnswerEntity.class);
				Root<QuestionAnswerEntity> root = criteria.from(QuestionAnswerEntity.class);
				return  Optional.ofNullable(session.createQuery(
		                 criteria.select(root).where(builder.equal(root.get("questionFolderId"), folderId.trim())))
				           .getSingleResult());
			}
			catch(Exception e)
			{
				e.printStackTrace();
				throw e;
			}
			finally
			{
				closeSession();
			}
			
		}else if(action.trim().equals("ANSWER")) {
			
			try{
				Session session = currentSession();
				CriteriaBuilder builder = session.getCriteriaBuilder();
				CriteriaQuery<QuestionAnswerEntity> criteria = builder.createQuery(QuestionAnswerEntity.class);
				Root<QuestionAnswerEntity> root = criteria.from(QuestionAnswerEntity.class);
				return  Optional.ofNullable(session.createQuery(
		                 criteria.select(root).where(builder.equal(root.get("answerFolderId"), folderId.trim())))
				           .getSingleResult());
			}
			catch(Exception e)
			{
				e.printStackTrace();
				throw e;
			}
			finally
			{
				closeSession();
			}
		}
		
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String reSubmitAnswerSheet(String answerFolderId) throws Exception {
		try {
			Session session = currentSession();
			beginTransaction();
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaUpdate<QuestionAnswerEntity> criteria = builder.createCriteriaUpdate(QuestionAnswerEntity.class);
			Root<QuestionAnswerEntity> root = criteria.from(QuestionAnswerEntity.class);
			criteria.set("isAnswered", false);
			criteria.where(builder.equal(root.get("answerFolderId"), answerFolderId.trim()));
			session.createQuery(criteria).executeUpdate();
			commitTransaction();
			return "true";
		} catch (Exception e) {
			
			rollbackTransaction();
			return "false";
		}finally
		{
			closeSession();
		}
	}

	
	
	
}
