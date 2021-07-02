package com.online.videostreaming.classrooms.onlineclassrooms.filters;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.online.videostreaming.classrooms.onlineclassrooms.captcha.CaptchaType;
import com.online.videostreaming.classrooms.onlineclassrooms.captcha.exception.CaptchaAuthenticationException;
import com.online.videostreaming.classrooms.onlineclassrooms.captcha.services.impl.CaptchaService;
import com.online.videostreaming.classrooms.onlineclassrooms.exceptions.CredentialsAuthenticationException;

public class CaptchaValidationFilter extends UsernamePasswordAuthenticationFilter implements InitializingBean {
	public CaptchaValidationFilter() {

	}

	private CaptchaService captchaService;
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	private final String redirectUriParameter = "/login?error";
	public CaptchaValidationFilter(CaptchaService captchaService) {

		this.captchaService = captchaService;
		setUsernameParameter("userName");
		super.setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher("/login", "POST"));
	}

	@Autowired
	@Qualifier("authenticationManagerBean")
	public void setAuthenticationManager(AuthenticationManager authenticationManager) {
		super.setAuthenticationManager(authenticationManager);
	}

	@Autowired
	@Qualifier("loginFailureHandler")
	@Override
	public void setAuthenticationFailureHandler(AuthenticationFailureHandler failureHandler) {
		super.setAuthenticationFailureHandler(failureHandler);
	}

	@Autowired
	@Qualifier("authenticationSuccessHandler")
	@Override
	public void setAuthenticationSuccessHandler(AuthenticationSuccessHandler successHandler) {
		super.setAuthenticationSuccessHandler(successHandler);
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws CredentialsAuthenticationException {

		String captchaAnswer = request.getParameter("captchaAnswer");

		if (captchaAnswer != null || !"".equals(captchaAnswer)) {
			Boolean isValid = captchaService.validateCaptchaCode(request, "CAPTCHA_KEY" + request.getSession().getId(),
					captchaAnswer, CaptchaType.IMG);
			if (!isValid) {
				SecurityContextHolder.clearContext();
				try {
					this.CaptchaError(request, response, new CaptchaAuthenticationException(
							"The captcha you entered is incorrect. Please try again."));
				} catch (IOException e) {
					e.printStackTrace();
				}
				return null;
			} else {
				String username = (String) request.getParameter("userName");
				username = (username != null) ? username : "";
				username = username.trim();
				String password = (String) request.getParameter("password");
				password = (password != null) ? password : "";
				UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(
						username, password);
				setDetails(request, authRequest);
				return this.getAuthenticationManager().authenticate(authRequest);

			}

		} else {

			return null;
		}

	}

	private void CaptchaError(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException {

		request.getSession().setAttribute(WebAttributes.AUTHENTICATION_EXCEPTION, exception);
		this.redirectStrategy.sendRedirect(request, response, this.redirectUriParameter);

	}

	

}