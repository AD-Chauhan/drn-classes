package com.online.videostreaming.classrooms.onlineclassrooms.security;



import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

public class OnLogoutSuccessHandler extends  SimpleUrlLogoutSuccessHandler {
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	

	@Override
	public void onLogoutSuccess(HttpServletRequest req, HttpServletResponse res, Authentication authentication)
			throws IOException {


		SecurityContextHolder.getContext().setAuthentication(null);
		SecurityContextHolder.clearContext();
		invalidateSession(req);

		redirectStrategy.sendRedirect(req, res,
				ServletUriComponentsBuilder.fromCurrentContextPath().path("/login").toUriString());
	}

	private void invalidateSession(HttpServletRequest request) {
		if (request.getSession() != null) {
			
			request.getSession().removeAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY);
			request.getSession().removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
			request.getSession(false);
			request.getSession().invalidate();

		}

		if (request.getCookies() != null) {
			for (final Cookie cookie : request.getCookies()) {
				cookie.setMaxAge(0);
			}

		}
	}

	

}
