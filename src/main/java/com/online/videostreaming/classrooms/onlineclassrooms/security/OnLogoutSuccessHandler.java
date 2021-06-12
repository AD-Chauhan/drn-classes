package com.online.videostreaming.classrooms.onlineclassrooms.security;



import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class OnLogoutSuccessHandler extends  SimpleUrlLogoutSuccessHandler {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public void onLogoutSuccess(HttpServletRequest req, HttpServletResponse res, Authentication authentication)
			throws IOException, ServletException {

		logger.debug("Performing logout");
		invalidateSession(req);
		/*
		 * String returnTo = req.getScheme() + "://" + req.getServerName(); if
		 * ((req.getScheme().equals("http") && req.getServerPort() != 80) ||
		 * (req.getScheme().equals("https") && req.getServerPort() != 443)) { returnTo
		 * += ":" + req.getServerPort(); } returnTo += "/"; String logoutUrl =
		 * String.format(
		 * "https://10.25.214.185:9090/auth-server/logout?user_id=%s&returnTo=%s",
		 * authentication.getName(), returnTo);
		 */
		 SecurityContextHolder.clearContext();
			/*
			 * try { res.sendRedirect(logoutUrl); } catch (IOException e) {
			 * e.printStackTrace(); }
			 */
	}

	private void invalidateSession(HttpServletRequest request) {
		if (request.getSession() != null) {
			request.getSession().invalidate();
		}
	}

}
