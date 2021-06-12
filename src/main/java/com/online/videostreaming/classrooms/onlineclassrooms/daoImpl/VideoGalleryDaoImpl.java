package com.online.videostreaming.classrooms.onlineclassrooms.daoImpl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.online.videostreaming.classrooms.onlineclassrooms.dao.VideoGalleryDao;
import com.online.videostreaming.classrooms.onlineclassrooms.entity.VideoUploadEntity;
import com.online.videostreaming.classrooms.onlineclassrooms.utils.HibernateSessionUtils;

@Repository
@Transactional
public class VideoGalleryDaoImpl extends HibernateSessionUtils implements VideoGalleryDao{

	@Override
	public int uploadFile(VideoUploadEntity videoUploadEntity) throws Exception {
		
		int saveCount=0;
		
		try
		{
			Session session = currentSession();
			beginTransaction();
			session.save(videoUploadEntity);
			
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

	@SuppressWarnings("unchecked")
	@Override
	public List<VideoUploadEntity> getAllUploadedVideos() throws Exception {
		try{
			
			
			Session session = currentSession();
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<VideoUploadEntity> criteria = builder.createQuery(VideoUploadEntity.class);
			Root<VideoUploadEntity> root = criteria.from(VideoUploadEntity.class);
			return session.createQuery(
	                 criteria.select(root).orderBy(builder.asc(root.get("videoGallaryId"))))
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
	public boolean updateVideoDetails(VideoUploadEntity videoUploadEntity) throws Exception {
		
		try
		{
			Session session = currentSession();
			beginTransaction();
			session.update(videoUploadEntity);
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
	public boolean deleteVideoById(Integer idToDelete) throws Exception {
		try
		{
			Session session = currentSession();
			beginTransaction();
			
			session.delete(session.get(VideoUploadEntity.class, idToDelete));
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
	public VideoUploadEntity getVideoDetailsById(Integer Id) throws Exception {
		
		try{
			Session session = currentSession();
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<VideoUploadEntity> criteria = builder.createQuery(VideoUploadEntity.class);
			Root<VideoUploadEntity> root = criteria.from(VideoUploadEntity.class);
			return session.createQuery(
	                 criteria.select(root).where(builder.equal(root.get("videoGallaryId"), Id)))
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
	public VideoUploadEntity getVideoDetailsByFolderId(String Id) throws Exception {
		
		try{
			Session session = currentSession();
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<VideoUploadEntity> criteria = builder.createQuery(VideoUploadEntity.class);
			Root<VideoUploadEntity> root = criteria.from(VideoUploadEntity.class);
			return session.createQuery(
	                 criteria.select(root).where(builder.equal(root.get("folderId"), Id.trim())))
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

}
