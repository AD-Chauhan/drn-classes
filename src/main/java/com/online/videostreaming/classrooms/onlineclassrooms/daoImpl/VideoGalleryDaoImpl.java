package com.online.videostreaming.classrooms.onlineclassrooms.daoImpl;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.online.videostreaming.classrooms.onlineclassrooms.dao.VideoGalleryDao;
import com.online.videostreaming.classrooms.onlineclassrooms.entity.CommentReply;
import com.online.videostreaming.classrooms.onlineclassrooms.entity.VideoComment;
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

	@Override
	public boolean saveComment(VideoComment vc) throws Exception {
		
		try
		{
			Session session = currentSession();
			beginTransaction();
			session.save(vc);
			
			commitTransaction();
		}
		catch(Exception e){
			rollbackTransaction();
			e.printStackTrace();
			return false;
		}
		finally{
			closeSession();
		}
		return true;
	}


	@Override
	public boolean saveReply(CommentReply cr) throws Exception {
		try
		{
			Session session = currentSession();
			beginTransaction();
			session.save(cr);
			
			commitTransaction();
		}
		catch(Exception e){
			rollbackTransaction();
			e.printStackTrace();
			return false;
		}
		finally{
			closeSession();
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	public List<Object[]> findVideoCommentReply(String  folderId) throws Exception {
	
		try
		{
			Session session = currentSession();
			StringBuilder sb=new StringBuilder();
			sb.append("SELECT vc.folderid,vc.video_comment_id,vc.comment,cr.reply,vc.created_by as created_by2,vc.created_date as created_date2,cr.created_by as created_by1,cr.created_date as created_date1 FROM video_gallary vg");
			sb.append(" INNER JOIN video_comment vc ON vc.folderid=vg.folder_id");
			sb.append(" LEFT JOIN  comment_reply cr ON  cr.comment_id=vc.video_comment_id");
			sb.append(" WHERE vg.folder_id=:folderId order by vc.video_comment_id desc");
			Query query = session.createNativeQuery(sb.toString());
			query.setParameter("folderId", folderId);
			return query.getResultList();
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return null;
	}

}
