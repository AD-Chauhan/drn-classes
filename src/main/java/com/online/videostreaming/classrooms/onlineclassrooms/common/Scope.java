package com.online.videostreaming.classrooms.onlineclassrooms.common;

import java.util.HashMap;
import java.util.Map;

public enum Scope {
	  OPENID("openid","openid"),
	  OFFLINE_ACCESS("offline_access","offline_access"),
	  EMAIL("email","email"),
	  ADDRESS("address","address"),
	  PHONE("phone","phone"),
	  PROFILE("profile","profile");
	  
	 
public static final Map<String, String> mappings = new HashMap<>(6);
	
	
	private final String key;
    private final String value;
    
	private Scope(String key,String value) {
       
        this.value = value;
        this.key = key;
    }

	public String getKey() {
		return key;
	}

	public String getValue() {
		return value;
	}
	
	static {
		for (Scope scopes : Scope.values()) {
			mappings.put(scopes.getKey(), scopes.getValue());
		}
	}
	
	
	
	
	

	
	}