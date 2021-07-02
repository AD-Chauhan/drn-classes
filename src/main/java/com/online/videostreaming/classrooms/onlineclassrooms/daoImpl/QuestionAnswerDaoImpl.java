package com.online.videostreaming.classrooms.onlineclassrooms.daoImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.online.videostreaming.classrooms.onlineclassrooms.dao.QuestionAnswerDao;
import com.online.videostreaming.classrooms.onlineclassrooms.entity.QuestionAnswerEntity;
import com.online.videostreaming.classrooms.onlineclassrooms.entity.QuestionMasterEntity;
import com.online.videostreaming.classrooms.onlineclassrooms.forms.SearchForm;
import com.online.videostreaming.classrooms.onlineclassrooms.utils.HibernateSessionUtils;
@Repository
@Transactional
public class QuestionAnswerDaoImpl extends HibernateSessionUtils implements QuestionAnswerDao {

	@Override
	public int uploadQuestionFile(QuestionMasterEntity questionAnswerEntity) throws Exception {
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
	public boolean deleteFolderAndQuestionById(Integer idToDelete) throws Exception {
		try
		{
			Session session = currentSession();
			beginTransaction();
			
			session.delete(session.get(QuestionMasterEntity.class, idToDelete));
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


	@Override
	public List<QuestionMasterEntity> getAllUploadedQuestions() throws Exception {

try{
			
			
			Session session = currentSession();
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<QuestionMasterEntity> criteria = builder.createQuery(QuestionMasterEntity.class);
			Root<QuestionMasterEntity> root = criteria.from(QuestionMasterEntity.class);
			List<Order> orderList = new ArrayList<Order>();
			orderList.add(builder.desc(root.get("batch")));
			orderList.add(builder.desc(root.get("courseCategory")));
			return session.createQuery(
	                 criteria.select(root).orderBy(orderList))
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
	public Optional<QuestionMasterEntity> downloadQuestionSheets(String folderId, String action) throws Exception {
		return null;
	}

	@Override
	public Optional<QuestionMasterEntity> getQuestionDetailsByFolderId(String folderId, String action)
			throws Exception {
		if(action.trim().equals("QUESTION")) {
			try{
				Session session = currentSession();
				CriteriaBuilder builder = session.getCriteriaBuilder();
				CriteriaQuery<QuestionMasterEntity> criteria = builder.createQuery(QuestionMasterEntity.class);
				Root<QuestionMasterEntity> root = criteria.from(QuestionMasterEntity.class);
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
			
		}
		return null;
	}

	@Override
	public QuestionMasterEntity getAllUploadedQuestionsById(Integer questionId) throws Exception {
		try{
			Session session = currentSession();
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<QuestionMasterEntity> criteria = builder.createQuery(QuestionMasterEntity.class);
			Root<QuestionMasterEntity> root = criteria.from(QuestionMasterEntity.class);
			return session.createQuery(
	                 criteria.select(root).where(builder.equal(root.get("questionId"), questionId)))
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
	public QuestionAnswerEntity getAllUploadedQuestionAnswersById(Integer id,String email,String rollno) throws Exception {
		try{
			Session session = currentSession();
			QuestionAnswerEntity questionAnswerEntity=null;
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<QuestionAnswerEntity> criteria = builder.createQuery(QuestionAnswerEntity.class);
			Root<QuestionAnswerEntity> root = criteria.from(QuestionAnswerEntity.class);
			questionAnswerEntity=session.createQuery(
	                 criteria.select(root).where(builder.equal(root.get("questionId"), id),builder.equal(root.get("answerCreatedByEmail"), email),builder.equal(root.get("answerCreatedByRollNo"), rollno)))
			           .getSingleResult();
			
			return questionAnswerEntity;
		}
		catch(javax.persistence.NoResultException e)
		{
			return null;
		}
		finally
		{
			closeSession();
		}
	}

	@Override
	public List<QuestionAnswerEntity> getAllUploadedQuestionAnswersByKeyword(SearchForm searchForm) throws Exception {
		try{
			Session session = currentSession();
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<QuestionAnswerEntity> query = builder.createQuery(QuestionAnswerEntity.class);
			EntityType<QuestionAnswerEntity> type = session.getMetamodel().entity(QuestionAnswerEntity.class);
			Root<QuestionAnswerEntity> root = query.from(QuestionAnswerEntity.class);
			query.where(builder.or(builder.like(root.get("meterialName"), "%" + searchForm.getKeyword()==""?null:searchForm.getKeyword() + "%"),
					builder.like(
				            builder.lower(
				                root.get(
				                    type.getDeclaredSingularAttribute("answerCreatedByRollNo", String.class)
				                )
				            ), "%" + searchForm.getKeyword()==""?null:searchForm.getKeyword().toLowerCase() + "%"
				        ), 
				        builder.like(
				            builder.lower(
				                root.get(
				                    type.getDeclaredSingularAttribute("answerCreatedByName", String.class)
				                )
				            ), "%" + searchForm.getKeyword()==""?null:searchForm.getKeyword().toLowerCase() + "%"
				        ), 
				        builder.like(
				            builder.lower(
				                root.get(
				                    type.getDeclaredSingularAttribute("answerCreatedByEmail", String.class)
				                )
				            ), "%" + searchForm.getKeyword()==""?null:searchForm.getKeyword().toLowerCase() + "%"
				        ),
			        builder.equal(root.get("batch"), searchForm.getBatch().toString()),
			        builder.equal(root.get("courseCategory"), searchForm.getCourseCategory().toString())
			        ));

			query.orderBy(builder.asc(root.get("answerCreatedByName")),
			            builder.asc(root.get("answerCreatedByEmail")));
			return session.createQuery(query).getResultList();
		}
		catch(Exception e)
		{
			return null;
		}
		finally
		{
			closeSession();
		}
		
		
	}
	
	
	
	
	
}
