package com.online.videostreaming.classrooms.onlineclassrooms.utils;


import javax.servlet.http.HttpSession;

public class SessionAttributeUtils {

	private static final ThreadLocal<HttpSession> SESSION_HOLDER = new ThreadLocal<HttpSession>();

	public static void bindSession(HttpSession session) {
		SESSION_HOLDER.set(session);
	}

	public static Object getAttribute(String key) {
		return getSession().getAttribute(key);
	}

	public static void setAttribute(String key, Object value) {
		getSession().setAttribute(key, value);
	}

	public static void removeAttribute(String key) {
		getSession().removeAttribute(key);
	}

	private static HttpSession getSession() {
		HttpSession session = SESSION_HOLDER.get();
		if (session == null) {
			throw new IllegalStateException("No session buind with current session.");
		}
		return session;
	}

}
