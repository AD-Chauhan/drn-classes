package com.online.videostreaming.classrooms.onlineclassrooms.enums;

import java.util.HashMap;
import java.util.Map;

public enum CourseCategory {

	MATHS(1, "Maths"), 
	
	SCIENCE(2,"Science"),
	
	ENGLISH(3,"English"),
	
	HINDI(4,"Hindi");
	
	public static final Map<Integer, String> mappings = new HashMap<>(16);
	
	
	private final Integer key;
    private final String value;
    
	private CourseCategory(Integer key,String value) {
       
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
		for (CourseCategory fileDescriptions : CourseCategory.values()) {
			mappings.put(fileDescriptions.getKey(), fileDescriptions.getValue());
		}
	}
	
	
}
