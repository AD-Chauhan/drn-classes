package com.online.videostreaming.classrooms.onlineclassrooms.enums;

import java.util.HashMap;
import java.util.Map;

public enum Batch {



	CLASS9(1, "CLASS 9"), 
	
	CLASS10(2,"CLASS 10"),
	
	CLASS11(3,"CLASS 11"),
	
	CLASS12(4,"CLASS 12");
	
	public static final Map<Integer, String> mappings = new HashMap<>(16);
	
	
	private final Integer key;
    private final String value;
    
	private Batch(Integer key,String value) {
       
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
		for (Batch batch : Batch.values()) {
			mappings.put(batch.getKey(), batch.getValue());
		}
	}
	
	
	

	
	
}
