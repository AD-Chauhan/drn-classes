package com.online.videostreaming.classrooms.onlineclassrooms.forms;

public class LoginForm {

	private String userName;
	private String password;

	private String hPwd;
	
	private String _csrf;

	private String captchaAnswer;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String gethPwd() {
		return hPwd;
	}

	public void sethPwd(String hPwd) {
		this.hPwd = hPwd;
	}

	public String getCaptchaAnswer() {
		return captchaAnswer;
	}

	public void setCaptchaAnswer(String captchaAnswer) {
		this.captchaAnswer = captchaAnswer;
	}

	public String get_csrf() {
		return _csrf;
	}

	public void set_csrf(String _csrf) {
		this._csrf = _csrf;
	}
	
	

}
