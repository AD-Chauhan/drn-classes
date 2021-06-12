package com.online.videostreaming.classrooms.onlineclassrooms.utils;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.util.WebUtils;

import lombok.val;

public class SessionUtils {

    
    @SuppressWarnings("unchecked")
    public static <T> T getAttribute(HttpServletRequest request, String attributeName) {
        T ret = null;
        val session = getSession(request);
        val mutex = getMutex(request);
        if (mutex != null) {
            synchronized (mutex) {
                ret = (T) session.getAttribute(attributeName);
            }
        }
        return ret;
    }

    
    public static void setAttribute(HttpServletRequest request, String attributeName, Object value) {
        val session = getSession(request);
        val mutex = getMutex(request);
        if (mutex != null) {
            synchronized (mutex) {
                session.setAttribute(attributeName, value);
            }
        }
    }

    
    public static Object getMutex(HttpServletRequest request) {
        val session = getSession(request);

        if (session != null) {
            val mutex = WebUtils.getSessionMutex(session);
            return mutex;
        }

        return null;
    }

    
    public static HttpSession getSession(HttpServletRequest request) {
        return request.getSession(false);
    }
}