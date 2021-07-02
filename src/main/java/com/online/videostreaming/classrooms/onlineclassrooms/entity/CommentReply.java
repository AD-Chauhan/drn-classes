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
@Table(name = "comment_reply")

public class CommentReply implements Serializable {

	private static final long serialVersionUID = 1L;
	@GenericGenerator(name = "sequence", strategy = "sequence", parameters = {
			@Parameter(name = "sequence", value = "video_reply_id_seq") })
	@Id
	@GeneratedValue(generator = "sequence")

	@Column(name = "video_reply_id")
	private Integer videoReplyId;

	@Column(name = "reply")
	private String reply;

	
	@Column(name = "comment_id")
	private Integer videoCommentId;

	@Column(name="created_by")
	private String createdby;
	
	@Column(name="created_date")
	private Timestamp  createdDate;
	

	public Integer getVideoReplyId() {
		return videoReplyId;
	}


	public void setVideoReplyId(Integer videoReplyId) {
		this.videoReplyId = videoReplyId;
	}


	public String getReply() {
		return reply;
	}


	public void setReply(String reply) {
		this.reply = reply;
	}


	public Integer getVideoCommentId() {
		return videoCommentId;
	}


	public void setVideoCommentId(Integer videoCommentId) {
		this.videoCommentId = videoCommentId;
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

