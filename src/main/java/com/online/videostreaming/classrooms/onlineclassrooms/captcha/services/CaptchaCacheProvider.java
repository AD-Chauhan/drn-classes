package com.online.videostreaming.classrooms.onlineclassrooms.captcha.services;

import javax.servlet.http.HttpServletRequest;

import com.online.videostreaming.classrooms.onlineclassrooms.captcha.CaptchaCode;

public interface CaptchaCacheProvider<String, V> {

	void put(HttpServletRequest request, String key, V value);

	Object get(HttpServletRequest request, String key);

}
