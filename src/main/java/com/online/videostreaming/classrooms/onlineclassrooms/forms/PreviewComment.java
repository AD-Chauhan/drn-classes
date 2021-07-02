package com.online.videostreaming.classrooms.onlineclassrooms.forms;

import java.sql.Timestamp;

public class PreviewComment{
	private Integer cId;
	private String commnent;
	private String createdby;
	private String  createdDate;
	public Integer getcId() {
		return cId;
	}
	public void setcId(Integer cId) {
		this.cId = cId;
	}
	public String getCommnent() {
		return commnent;
	}
	public void setCommnent(String commnent) {
		this.commnent = commnent;
	}
	
	
	
	public String getCreatedby() {
		return createdby;
	}
	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cId == null) ? 0 : cId.hashCode());
		result = prime * result + ((commnent == null) ? 0 : commnent.hashCode());
		result = prime * result + ((createdby == null) ? 0 : createdby.hashCode());
		result = prime * result + ((createdDate == null) ? 0 : createdDate.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PreviewComment other = (PreviewComment) obj;
		if (cId == null) {
			if (other.cId != null)
				return false;
		} else if (!cId.equals(other.cId))
			return false;
		if (commnent == null) {
			if (other.commnent != null)
				return false;
		} else if (!commnent.equals(other.commnent))
			return false;
		if (createdby == null) {
			if (other.createdby != null)
				return false;
		} else if (!createdby.equals(other.createdby))
			return false;
		if (createdDate == null) {
			if (other.createdDate != null)
				return false;
		} else if (!createdDate.equals(other.createdDate))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return  commnent;
	}
	
	
}