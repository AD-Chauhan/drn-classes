package com.online.videostreaming.classrooms.onlineclassrooms.services;

import java.util.List;

import com.online.videostreaming.classrooms.onlineclassrooms.entity.VideoUploadEntity;

public interface VideoGalleryService {

	
	 public int uploadFile(VideoUploadEntity videoUploadForm) throws Exception;
	 
	 public List<VideoUploadEntity> getAllUploadedVideos() throws Exception;
	 
	 public boolean updateVideoDetails(VideoUploadEntity videoUploadEntity) throws Exception;
	 
	 
	 public String deleteFolderAndVideoById(Integer idToDelete) throws Exception;
	 
	 public VideoUploadEntity getVideoDetailsByFolderId(String Id) throws Exception;
}
