package com.online.videostreaming.classrooms.onlineclassrooms.enums;

import java.util.HashMap;
import java.util.Map;

public enum CourseCategory2 {

	MATHS(1, "Maths"), 
	
	SCIENCE(2,"Science"),
	
	ENGLISH(3,"English"),
	
	CHEMISTRY(3,"Chemistry"),
	
	HINDI(4,"Hindi");
	
	public static final Map<Integer, String> mappings = new HashMap<>(16);
	
	
	private final Integer key;
    private final String value;
    
	private CourseCategory2(Integer key,String value) {
       
        this.value = value;
        this.key = key;
    }

	public Integer getKey() {
		return key;
	}

	public String getValue() {
		return value;
	}
	
	static {
		for (CourseCategory2 fileDescriptions : CourseCategory2.values()) {
			mappings.put(fileDescriptions.getKey(), fileDescriptions.getValue());
		}
	}
	
	
	
}
