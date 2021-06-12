package com.online.videostreaming.classrooms.onlineclassrooms.daoImpl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.online.videostreaming.classrooms.onlineclassrooms.dao.BlogDao;
import com.online.videostreaming.classrooms.onlineclassrooms.entity.BlogUploadEntity;
import com.online.videostreaming.classrooms.onlineclassrooms.entity.VideoUploadEntity;
import com.online.videostreaming.classrooms.onlineclassrooms.utils.HibernateSessionUtils;
@Repository
@Transactional
public class BlogDaoImpl extends HibernateSessionUtils implements BlogDao {

	@Override
	public int uploadBlogFile(BlogUploadEntity blogUploadEntity) throws Exception {
		
		int saveCount=0;
		
		try
		{
			Session session = currentSession();
			beginTransaction();
			session.save(blogUploadEntity);
			
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
	public List<BlogUploadEntity> getAllUploadedBlogs() throws Exception {
		try{
			
			
			Session session = currentSession();
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<BlogUploadEntity> criteria = builder.createQuery(BlogUploadEntity.class);
			Root<BlogUploadEntity> root = criteria.from(BlogUploadEntity.class);
			return session.createQuery(
	                 criteria.select(root).orderBy(builder.desc(root.get("blogGallaryId"))))
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
	public List<BlogUploadEntity> getAllUploadedBlogsByLimit() throws Exception {
		try{
			
			
			Session session = currentSession();
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<BlogUploadEntity> criteria = builder.createQuery(BlogUploadEntity.class);
			Root<BlogUploadEntity> root = criteria.from(BlogUploadEntity.class);
			return session.createQuery(
	                 criteria.select(root).orderBy(builder.desc(root.get("blogGallaryId")))).setMaxResults(5)
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
	public BlogUploadEntity getBlogDetailsById(Integer Id) throws Exception {
		
		try{
			Session session = currentSession();
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<BlogUploadEntity> criteria = builder.createQuery(BlogUploadEntity.class);
			Root<BlogUploadEntity> root = criteria.from(BlogUploadEntity.class);
			return session.createQuery(
	                 criteria.select(root).where(builder.equal(root.get("blogGallaryId"), Id)))
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
	public boolean deleteBlogById(Integer idToDelete) throws Exception {
		try
		{
			Session session = currentSession();
			beginTransaction();
			
			session.delete(session.get(BlogUploadEntity.class, idToDelete));
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

	
	
	
	
	
}
