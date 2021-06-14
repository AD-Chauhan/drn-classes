package com.online.videostreaming.classrooms.onlineclassrooms.security;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.provider.endpoint.DefaultRedirectResolver;
import org.springframework.security.oauth2.provider.endpoint.RedirectResolver;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.online.videostreaming.classrooms.onlineclassrooms.drnusers.EndUserDetails;
import com.online.videostreaming.classrooms.onlineclassrooms.drnusers.service.UserService;

@Component
public class LoginSuccessHandlar extends SimpleUrlAuthenticationSuccessHandler {

	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	private final String redirectUrlAdmin = "/admin-dashboard";
	private final String redirectUrlUsers = "/home-page";

	private UserService userService;

	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		try {
			EndUserDetails userDetails = (EndUserDetails) authentication.getPrincipal();

		if (userDetails.getFailedAttempt() > 0) {
			userService.resetFailedAttempts(userDetails.getEmail());
		}
		request.getSession().setAttribute("userDetails", userDetails);
		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
		authorities.forEach(authority -> {
			if (authority.getAuthority().equals("ROLE_ADMIN")) {
				

					Map<String, String> params = new HashMap<>();
					for (Entry<String, String[]> entry : request.getParameterMap().entrySet()) {
						params.put(entry.getKey(), entry.getValue()[0]);
					}

					try {
						redirectStrategy.sendRedirect(request, response,
								ServletUriComponentsBuilder.fromCurrentContextPath().path(redirectUrlAdmin).toUriString());
						return;
					} catch (IOException e) {
						
						e.printStackTrace();
					}

				
			}else if (authority.getAuthority().equals("ROLE_USERS")){
				
				try {
					redirectStrategy.sendRedirect(request, response,
							ServletUriComponentsBuilder.fromCurrentContextPath().path(redirectUrlUsers).toUriString());
					return;
				} catch (IOException e) {
					
					e.printStackTrace();
				}
			}
			
			
			
			
		});
		} catch (Exception e) {
			e.printStackTrace();
			try {
				redirectStrategy.sendRedirect(request, response,
						ServletUriComponentsBuilder.fromCurrentContextPath().path("/login").toUriString());
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		


	}

}
