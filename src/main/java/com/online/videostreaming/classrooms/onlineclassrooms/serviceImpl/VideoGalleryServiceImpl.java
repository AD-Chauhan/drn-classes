package com.online.videostreaming.classrooms.onlineclassrooms.serviceImpl;

import java.io.File;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.online.videostreaming.classrooms.onlineclassrooms.dao.VideoGalleryDao;
import com.online.videostreaming.classrooms.onlineclassrooms.entity.CommentReply;
import com.online.videostreaming.classrooms.onlineclassrooms.entity.VideoComment;
import com.online.videostreaming.classrooms.onlineclassrooms.entity.VideoUploadEntity;
import com.online.videostreaming.classrooms.onlineclassrooms.enums.Batch;
import com.online.videostreaming.classrooms.onlineclassrooms.enums.CourseCategory;
import com.online.videostreaming.classrooms.onlineclassrooms.enums.CourseCategory2;
import com.online.videostreaming.classrooms.onlineclassrooms.forms.VideoUploadEntityForm;
import com.online.videostreaming.classrooms.onlineclassrooms.services.VideoGalleryService;
@Service
public class VideoGalleryServiceImpl implements VideoGalleryService {

	@Autowired
	private VideoGalleryDao VideoGalleryDao;
	
	@Autowired
    ServletContext context;
	@Transactional
	@Override
	public int uploadFile(VideoUploadEntity videoUploadEntity) throws Exception {
		
		
		
		return VideoGalleryDao.uploadFile(videoUploadEntity);
	}
	@Override
	public List<VideoUploadEntity> getAllUploadedVideos() throws Exception {
		return VideoGalleryDao.getAllUploadedVideos();
	}
	
	@Override
	public List<VideoUploadEntityForm> getAllUploadedVideosForView() throws Exception {
		
		List<VideoUploadEntity> fetchlist=VideoGalleryDao.getAllUploadedVideos();
		
		return fetchlist==null?null:fetchlist.stream().map(mapper->{
			
			VideoUploadEntityForm videoUploadEntity=new VideoUploadEntityForm();
			videoUploadEntity.setBatch(Batch.mappings.get(Integer.parseInt(mapper.getBatch())));
			videoUploadEntity.setCompressed(mapper.isCompressed());
			videoUploadEntity.setCompressedPath(mapper.getCompressedPath());
			if (Integer.parseInt(mapper.getBatch()) == 1 || Integer.parseInt(mapper.getBatch()) == 2) {

				videoUploadEntity
						.setCourseCategory(CourseCategory.mappings.get(mapper.getCourseCategory()));

			} else if (Integer.parseInt(mapper.getBatch()) == 3 || Integer.parseInt(mapper.getBatch()) == 4) {

				videoUploadEntity
						.setCourseCategory(CourseCategory2.mappings.get(mapper.getCourseCategory()));

			}
			
			videoUploadEntity.setCreatedby(mapper.getCreatedby());
			videoUploadEntity.setCreatedDate(mapper.getCreatedDate());
			videoUploadEntity.setDescription(mapper.getDescription());
			videoUploadEntity.setFolderId(mapper.getFolderId());
			videoUploadEntity.setOriginalFileExt(mapper.getOriginalFileExt());
			videoUploadEntity.setOriginalFileName(mapper.getOriginalFileName());
			videoUploadEntity.setOriginalPath(mapper.getOriginalPath());
			videoUploadEntity.setThumbnail(mapper.isThumbnail());
			videoUploadEntity.setThumbnailFileName(mapper.getThumbnailFileName());
			videoUploadEntity.setThumbnailPath(mapper.getThumbnailPath());
			videoUploadEntity.setVideoGallaryId(mapper.getVideoGallaryId());
			videoUploadEntity.setVideoName(mapper.getVideoName());
			videoUploadEntity.setVideoTitle(mapper.getVideoTitle());
			videoUploadEntity.setWrite(mapper.isWrite());
			return videoUploadEntity;
			
			
		}).collect(Collectors.toList());
	}
	@Override
	public boolean updateVideoDetails(VideoUploadEntity videoUploadEntity) throws Exception {
		return VideoGalleryDao.updateVideoDetails(videoUploadEntity);
	}

	@Override
	public String deleteFolderAndVideoById(Integer idToDelete) throws Exception {
		boolean isDeleted=false;
		try
		{
			
			VideoUploadEntity obj =  VideoGalleryDao.getVideoDetailsById(idToDelete);
			boolean check = VideoGalleryDao.deleteVideoById(idToDelete);
			if(check)
			{
				
				isDeleted=true;
				if(obj.getOriginalFileName()!=null && obj.getThumbnailFileName()!=null)
				{
					File videofile = new File(context.getRealPath(obj.getOriginalPath())+obj.getOriginalFileName());
					File thumbfile = new File(context.getRealPath(obj.getThumbnailPath())+obj.getThumbnailFileName());
					File dir = new File(context.getRealPath("/resources/VideosUploads/"+obj.getFolderId()+"/Videos/"));
					File dir2 = new File(context.getRealPath("/resources/VideosUploads/"+obj.getFolderId()+"/Thumbnail/"));
					
					if(videofile.exists())
					{
						videofile.delete();
					}
					
					if(thumbfile.exists())
					{
						thumbfile.delete();
					}
					FileUtils.deleteDirectory(dir);
					FileUtils.deleteDirectory(dir2);
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
		
		
		return isDeleted==true?"Record deleted Successfully":"Record not deleted Successfully";
	}
	@Override
	public VideoUploadEntity getVideoDetailsByFolderId(String Id) throws Exception {
		return VideoGalleryDao.getVideoDetailsByFolderId( Id);
	}
	@Override
	public boolean saveComment(String Id, String comment, String createdBy) throws Exception {
		VideoComment vc=new VideoComment();
		vc.setComment(comment);
		vc.setFolderId(Id);
		vc.setCreatedby(createdBy);
		vc.setCreatedDate(Timestamp.valueOf(LocalDateTime.now()));
		return VideoGalleryDao.saveComment(vc);
	}
	@Override
	public boolean saveReply(Integer commentId, String reply, String createdBy) throws Exception {
		CommentReply cr=new CommentReply();
		cr.setReply(reply);
		cr.setVideoCommentId(commentId);
		cr.setCreatedby(createdBy);
		cr.setCreatedDate(Timestamp.valueOf(LocalDateTime.now()));
		return VideoGalleryDao.saveReply(cr);
	}
	@Override
	public List<Object[]> findVideoCommentReply(String folderId) throws Exception {
		return VideoGalleryDao.findVideoCommentReply(folderId);
	}

}
