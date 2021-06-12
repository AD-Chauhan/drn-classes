package com.online.videostreaming.classrooms.onlineclassrooms.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpMethod;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import com.online.videostreaming.classrooms.onlineclassrooms.utils.RequestUtils;

import lombok.val;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class DefaultAuthenticationEntryPoint extends LoginUrlAuthenticationEntryPoint {

    private final String loginTimeoutUrl;

    private final RequestMatcher authorizationRequestMatcher;
    public DefaultAuthenticationEntryPoint(String loginUrl, String loginTimeoutUrl) {
        super(loginUrl);
        this.loginTimeoutUrl = loginTimeoutUrl;
        RequestMatcher authorizationRequestGetMatcher = new AntPathRequestMatcher(
				"/oauth/authorize", HttpMethod.GET.name());
		this.authorizationRequestMatcher=authorizationRequestGetMatcher;
    }
    
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
            AuthenticationException authException) throws IOException, ServletException {

        if (RequestUtils.isAjaxRequest(request)) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        super.commence(request, response, authException);
    }

    @Override
    protected String determineUrlToUseForThisRequest(HttpServletRequest request, HttpServletResponse response,
            AuthenticationException exception) {
        val url = super.determineUrlToUseForThisRequest(request, response, exception);

        if (request.getRequestedSessionId() != null && !request.isRequestedSessionIdValid() && !this.authorizationRequestMatcher.matches(request)) {
           
            return this.loginTimeoutUrl;
        }

        return url;
    }
}

