package com.online.videostreaming.classrooms.onlineclassrooms.security;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import com.online.videostreaming.classrooms.onlineclassrooms.drnusers.service.UserService;
import com.online.videostreaming.classrooms.onlineclassrooms.entity.UsersEntity;
import com.online.videostreaming.classrooms.onlineclassrooms.utils.WebConstant;
@Component
public class LoginFailureHandler extends SimpleUrlAuthenticationFailureHandler {
	@Autowired
	private UserService userService;
    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException exception) throws IOException, ServletException {
        httpServletResponse.setStatus(HttpStatus.UNAUTHORIZED.value());

       
        try {
    		
        String username = httpServletRequest.getParameter("username");
        
        Optional<UsersEntity> user = userService.findUserByUserName(username);
         
        if (user.isPresent()) {
            if (user.get().isEnabled() && user.get().getIsAccountNonLocked()) {
                if (user.get().getFailedAttempt() < WebConstant.MAX_FAILED_ATTEMPTS - 1) {
                    userService.increaseFailedAttempts(user.get());
                } else {
                    userService.lock(user.get());
                    exception = new LockedException("Your account has been locked due to 3 failed attempts."
                            + " It will be unlocked after 24 hours.");
                }
            } else if (!user.get().getIsAccountNonLocked()) {
                if (userService.unlockWhenTimeExpired(user.get())) {
                    exception = new LockedException("Your account has been unlocked. Please try to login again.");
                }
            }
            
            httpServletRequest.getSession().setAttribute(WebAttributes.AUTHENTICATION_EXCEPTION, exception);
             
        }
     
	   } catch (Exception e) {
		   
		   e.printStackTrace();
	   }
        super.setDefaultFailureUrl("/login?error");
        super.onAuthenticationFailure(httpServletRequest, httpServletResponse, exception);
    
    
    }
}