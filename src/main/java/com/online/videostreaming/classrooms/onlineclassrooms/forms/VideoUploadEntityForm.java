package com.online.videostreaming.classrooms.onlineclassrooms.forms;

import java.io.Serializable;
import java.sql.Timestamp;

public class VideoUploadEntityForm implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer videoGallaryId;
	
	private String videoName;
	
	private String videoTitle;
	
	private String courseCategory;
	
	private String description;
	
	private String batch;
	
	private String originalPath;
	
	private String originalFileName;
	
	private String originalFileExt;
	
	private boolean isWrite;
	
	private String thumbnailPath;
	
	private boolean isThumbnail;
	
	private String compressedPath;
	
	private boolean isCompressed;
	
	private String createdby;
	
	private Timestamp  createdDate;

	private String thumbnailFileName;
	
	private String folderId;

	public Integer getVideoGallaryId() {
		return videoGallaryId;
	}

	public void setVideoGallaryId(Integer videoGallaryId) {
		this.videoGallaryId = videoGallaryId;
	}

	public String getVideoName() {
		return videoName;
	}

	public void setVideoName(String videoName) {
		this.videoName = videoName;
	}

	public String getVideoTitle() {
		return videoTitle;
	}

	public void setVideoTitle(String videoTitle) {
		this.videoTitle = videoTitle;
	}

	public String getCourseCategory() {
		return courseCategory;
	}

	public void setCourseCategory(String courseCategory) {
		this.courseCategory = courseCategory;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getBatch() {
		return batch;
	}

	public void setBatch(String batch) {
		this.batch = batch;
	}

	public String getOriginalPath() {
		return originalPath;
	}

	public void setOriginalPath(String originalPath) {
		this.originalPath = originalPath;
	}

	public String getOriginalFileName() {
		return originalFileName;
	}

	public void setOriginalFileName(String originalFileName) {
		this.originalFileName = originalFileName;
	}

	public String getOriginalFileExt() {
		return originalFileExt;
	}

	public void setOriginalFileExt(String originalFileExt) {
		this.originalFileExt = originalFileExt;
	}

	public boolean isWrite() {
		return isWrite;
	}

	public void setWrite(boolean isWrite) {
		this.isWrite = isWrite;
	}

	public String getThumbnailPath() {
		return thumbnailPath;
	}

	public void setThumbnailPath(String thumbnailPath) {
		this.thumbnailPath = thumbnailPath;
	}

	public boolean isThumbnail() {
		return isThumbnail;
	}

	public void setThumbnail(boolean isThumbnail) {
		this.isThumbnail = isThumbnail;
	}

	public String getCompressedPath() {
		return compressedPath;
	}

	public void setCompressedPath(String compressedPath) {
		this.compressedPath = compressedPath;
	}

	public boolean isCompressed() {
		return isCompressed;
	}

	public void setCompressed(boolean isCompressed) {
		this.isCompressed = isCompressed;
	}

	public String getCreatedby() {
		return createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public String getThumbnailFileName() {
		return thumbnailFileName;
	}

	public void setThumbnailFileName(String thumbnailFileName) {
		this.thumbnailFileName = thumbnailFileName;
	}

	public String getFolderId() {
		return folderId;
	}

	public void setFolderId(String folderId) {
		this.folderId = folderId;
	}
	
	
	
}
