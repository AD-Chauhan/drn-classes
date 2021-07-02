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
@Table(name="video_comment")

public class VideoComment implements Serializable {

	
	
	private static final long serialVersionUID = 1L;
	@GenericGenerator(name = "sequence", strategy = "sequence", parameters={@Parameter(name="sequence",value="video_comment_id_seq")})
    @Id
    @GeneratedValue(generator = "sequence")
	
	@Column(name="video_comment_id")
	private Integer videoCommentId;
	
	@Column(name="comment")
	private String comment;

	@Column(name="folderId")
	private String folderId;
	
	@Column(name="created_by")
	private String createdby;
	
	@Column(name="created_date")
	private Timestamp  createdDate;
	
	

	public Integer getVideoCommentId() {
		return videoCommentId;
	}

	public void setVideoCommentId(Integer videoCommentId) {
		this.videoCommentId = videoCommentId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
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
