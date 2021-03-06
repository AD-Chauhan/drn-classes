package com.online.videostreaming.classrooms.onlineclassrooms.dao;

import java.util.List;

import com.online.videostreaming.classrooms.onlineclassrooms.entity.CommentReply;
import com.online.videostreaming.classrooms.onlineclassrooms.entity.VideoComment;
import com.online.videostreaming.classrooms.onlineclassrooms.entity.VideoUploadEntity;

public interface VideoGalleryDao {

	public int uploadFile(VideoUploadEntity videoUploadEntity) throws Exception;
	
	public List<VideoUploadEntity> getAllUploadedVideos() throws Exception;
	
	public boolean updateVideoDetails(VideoUploadEntity videoUploadEntity) throws Exception;
	
	public boolean deleteVideoById(Integer idToDelete) throws Exception;
	
	public VideoUploadEntity getVideoDetailsById(Integer Id) throws Exception ;
	public VideoUploadEntity getVideoDetailsByFolderId(String Id) throws Exception;
	public boolean saveComment(VideoComment vc) throws Exception;
	 
	 public boolean saveReply(CommentReply cr) throws Exception;
	 
	 public List<Object[]> findVideoCommentReply(String  folderId) throws Exception;
}
