package com.online.videostreaming.classrooms.onlineclassrooms.captcha.services.impl;



import javax.servlet.http.HttpServletRequest;

import com.online.videostreaming.classrooms.onlineclassrooms.captcha.services.CaptchaCacheProvider;
import com.online.videostreaming.classrooms.onlineclassrooms.utils.SessionUtils;

public class CaptchaSessionCacheProviderImpl<V> implements CaptchaCacheProvider<String, V> {


	@Override
	public void put(HttpServletRequest request, String key, V value) {
		
		 SessionUtils.setAttribute(request, key, value);
		
	}

	@Override
	public Object get(HttpServletRequest request,String key) {
		
		
		return SessionUtils.getAttribute(request, key);
	}

}
