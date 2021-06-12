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
@Table(name="blog_gallary")
public class BlogUploadEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	@GenericGenerator(name = "sequence", strategy = "sequence", parameters={@Parameter(name="sequence",value="blog_gallary_id_seq")})
    @Id
    @GeneratedValue(generator = "sequence")
	
	@Column(name="blog_gallary_id")
	private Integer blogGallaryId;
	
	@Column(name="blog_name")
	private String blogName;
	
	@Column(name="blog_title")
	private String blogTitle;
	
	
	@Column(name="description")
	private String description;
	
	@Column(name="execution_time")
	private String executionTime;
	
	
	@Column(name="original_path")
	private String originalPath;
	
	@Column(name="original_file_name")
	private String originalFileName;
	
	@Column(name="original_file_name600")
	private String originalFileName600;
	
	@Column(name="original_file_name800")
	private String originalFileName800;
	
	@Column(name="original_file_ext")
	private String originalFileExt;
	

	

	@Column(name="folder_id")
	private String folderId;
	
	
	@Column(name="created_by")
	private String createdby;
	
	@Column(name="created_date")
	private Timestamp  createdDate;
	
	
	public String getOriginalFileName600() {
		return originalFileName600;
	}

	public void setOriginalFileName600(String originalFileName600) {
		this.originalFileName600 = originalFileName600;
	}

	public String getOriginalFileName800() {
		return originalFileName800;
	}

	public void setOriginalFileName800(String originalFileName800) {
		this.originalFileName800 = originalFileName800;
	}

	public Integer getBlogGallaryId() {
		return blogGallaryId;
	}

	public void setBlogGallaryId(Integer blogGallaryId) {
		this.blogGallaryId = blogGallaryId;
	}

	public String getBlogName() {
		return blogName;
	}

	public void setBlogName(String blogName) {
		this.blogName = blogName;
	}

	public String getBlogTitle() {
		return blogTitle;
	}

	public void setBlogTitle(String blogTitle) {
		this.blogTitle = blogTitle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getExecutionTime() {
		return executionTime;
	}

	public void setExecutionTime(String executionTime) {
		this.executionTime = executionTime;
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

	public String getFolderId() {
		return folderId;
	}

	public void setFolderId(String folderId) {
		this.folderId = folderId;
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

	
	
	
	
}
