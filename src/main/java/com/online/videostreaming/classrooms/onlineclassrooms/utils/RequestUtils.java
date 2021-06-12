package com.online.videostreaming.classrooms.onlineclassrooms.utils;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import lombok.val;

public class RequestUtils {

    public static final String X_REQUESTED_WITH = "X-Requested-With";

    public static final String XMLHTTP_REQUEST = "XMLHttpRequest";

    
    public static String getUserAgent(HttpServletRequest request) {
        return StringUtils.trimToEmpty(request.getHeader(HttpHeaders.USER_AGENT));
    }

    
    public static boolean isAjaxRequest(HttpServletRequest request) {
        val header = request.getHeader(X_REQUESTED_WITH);
        val isAjax = StringUtils.equalsIgnoreCase(XMLHTTP_REQUEST, header);
        return isAjax;
    }

    
    public static HttpServletRequest getHttpServletRequest() {
        val attributes = RequestContextHolder.getRequestAttributes();
        return ((ServletRequestAttributes) attributes).getRequest();
    }

    
    public static String getSiteUrl() {
        val servletRequest = getHttpServletRequest();

        String scheme = servletRequest.getScheme();
        String host = servletRequest.getRemoteHost();
        int port = servletRequest.getServerPort();
        String path = servletRequest.getContextPath();

        String siteUrl = null;
        if (port == 80 || port == 443) {
            siteUrl = StringUtils.join(scheme, "://", host, path);
        } else {
            siteUrl = StringUtils.join(scheme, "://", host, ":", String.valueOf(port), path);
        }

        return siteUrl;
    }
}
