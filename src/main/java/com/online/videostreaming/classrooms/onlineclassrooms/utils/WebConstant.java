package com.online.videostreaming.classrooms.onlineclassrooms.utils;

public interface WebConstant {

	public String FORBIDDEN_URL = "/forbidden";
	public String LOGIN_TIMEOUT_URL = "/loginTimeout";
	public String LOGIN_URL = "/login";
	public String LOGOUT_URL = "/logout";
	public  int MAX_FAILED_ATTEMPTS = 3;
	public  long LOCK_TIME_DURATION = 24 * 60 * 60 * 1000; 
	
	public final String CLIEN_ID = "drn-client";
	public final String CLIENT_SECRET = "drn-secret";
	public final String GRANT_TYPE_PASSWORD = "password";
	public final String CLIENT_CREDENTIALS = "client_credentials";
	public final String REFRESH_TOKEN = "refresh_token";
	public final String IMPLICIT = "implicit";
	public final String SCOPE_READ = "read";
	public final String SCOPE_WRITE = "write";
	public final String TRUST = "trust";
	public final int ACCESS_TOKEN_VALIDITY_SECONDS = 1*60*60;
	public final int FREFRESH_TOKEN_VALIDITY_SECONDS = 6*60*60;
	
}
