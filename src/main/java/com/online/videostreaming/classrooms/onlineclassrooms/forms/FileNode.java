package com.online.videostreaming.classrooms.onlineclassrooms.forms;

import lombok.AllArgsConstructor;
import lombok.Data;


public class FileNode {
    private String fileName;
    private boolean isFIle;
	public FileNode() {
		super();
	}
	public FileNode(String fileName, boolean isFIle) {
		super();
		this.fileName = fileName;
		this.isFIle = isFIle;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public boolean isFIle() {
		return isFIle;
	}
	public void setFIle(boolean isFIle) {
		this.isFIle = isFIle;
	}
    
    
}