package com.online.videostreaming.classrooms.onlineclassrooms.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
@Entity
@Table(name="video_gallary")

public class VideoUploadEntity implements Serializable {

	
	
	private static final long serialVersionUID = 1L;
	@GenericGenerator(name = "sequence", strategy = "sequence", parameters={@Parameter(name="sequence",value="video_gallary_id_seq")})
    @Id
    @GeneratedValue(generator = "sequence")
	
	@Column(name="video_gallary_id")
	private Integer videoGallaryId;
	
	@Column(name="video_name")
	private String videoName;
	
	@Column(name="video_title")
	private String videoTitle;
	
	@Column(name="course_category")
	private Integer courseCategory;
	
	@Column(name="description")
	private String description;
	
	@Column(name="batch")
	private String batch;
	
	
	@Column(name="original_path")
	private String originalPath;
	
	@Column(name="original_file_name")
	private String originalFileName;
	
	@Column(name="original_file_ext")
	private String originalFileExt;
	
	@Column(name="is_write")
	private boolean isWrite;
	
	@Column(name="thumbnail_path")
	private String thumbnailPath;
	
	@Column(name="is_thumbnail")
	private boolean isThumbnail;
	
	@Column(name="compressed_path")
	private String compressedPath;
	
	@Column(name="is_compressed")
	private boolean isCompressed;
	
	@Column(name="created_by")
	private String createdby;
	
	@Column(name="created_date")
	private Timestamp  createdDate;

	@Column(name="thumbnail_file_name")
	private String thumbnailFileName;
	
	@Column(name="folder_id")
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

	public Integer getCourseCategory() {
		return courseCategory;
	}

	public void setCourseCategory(Integer courseCategory) {
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
