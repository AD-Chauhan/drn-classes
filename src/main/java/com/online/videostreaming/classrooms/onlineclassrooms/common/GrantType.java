package com.online.videostreaming.classrooms.onlineclassrooms.common;

import java.util.HashMap;
import java.util.Map;

public enum GrantType {
  AUTHORIZATION_CODE(1,"authorization_code"),
  PASSWORD(2,"password"),
  CLIENT_CREDENTIALS(3,"client_credentials"),
  REFRESH_TOKEN(4,"refresh_token");
  

public static final Map<Integer, String> mappings = new HashMap<>(10);
	
	
	private final Integer key;
    private final String value;
    
	private GrantType(Integer key,String value) {
       
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
		for (GrantType grantType : GrantType.values()) {
			mappings.put(grantType.getKey(), grantType.getValue());
		}
	}
	
	
	
}
