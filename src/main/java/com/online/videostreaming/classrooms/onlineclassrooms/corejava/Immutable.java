package com.online.videostreaming.classrooms.onlineclassrooms.corejava;

import java.util.Date;




final class Immutable {

	private int id;
	private Date date;
	
	public Immutable(){
		
		this.id=1;
		this.date=new Date(); // mutable object;
	}
	
	public int getId() {
		return id;
	}
	
	public Date getDate() {
		return (Date)date.clone();
	}

	@Override
	public String toString() {
		return "ImmutableTest [id=" + id + ", date=" + date + "]";
	}
	
	
	
	
}