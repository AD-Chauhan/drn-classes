package com.online.videostreaming.classrooms.onlineclassrooms.services;

import java.util.List;

import com.online.videostreaming.classrooms.onlineclassrooms.entity.VideoUploadEntity;
import com.online.videostreaming.classrooms.onlineclassrooms.forms.VideoUploadEntityForm;

public interface VideoGalleryService {

	
	 public int uploadFile(VideoUploadEntity videoUploadForm) throws Exception;
	 
	 public List<VideoUploadEntity> getAllUploadedVideos() throws Exception;
	 
	 public boolean updateVideoDetails(VideoUploadEntity videoUploadEntity) throws Exception;
	 
	 
	 public String deleteFolderAndVideoById(Integer idToDelete) throws Exception;
	 
	 public VideoUploadEntity getVideoDetailsByFolderId(String Id) throws Exception;

	 public List<VideoUploadEntityForm> getAllUploadedVideosForView() throws Exception;
	 

	 public boolean saveComment(String Id, String comment, String createdBy) throws Exception;
	 public boolean saveReply(Integer commentId,String replyId, String createdBy) throws Exception;
	 
	 public List<Object[]> findVideoCommentReply(String  folderId) throws Exception;
}
