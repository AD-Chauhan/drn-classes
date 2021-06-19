package com.online.videostreaming.classrooms.onlineclassrooms.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Component

public class RestAuthenticationEntryPoint implements AuthenticationEntryPoint {
  @Override
  public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException ) throws IOException, ServletException {    
    response.setContentType("application/json");
    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
    response.getOutputStream().println("{ \"error\": \"" + authException.getMessage() + "\" }");
  }

  @ExceptionHandler(value = { AccessDeniedException.class })
  public void commence(HttpServletRequest request, HttpServletResponse response, AccessDeniedException ex ) throws IOException {
    response.setContentType("application/json");
    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
    response.getOutputStream().println("{ \"error\": \"" + ex.getMessage() + "\" }");
  }
  
  //AuthenticationCredentialsNotFoundException
  
  @ExceptionHandler(value = { AuthenticationCredentialsNotFoundException.class })
  public void AuthenticationCredentialsNotFoundException(HttpServletRequest request, HttpServletResponse response, AccessDeniedException ex ) throws IOException {
    response.setContentType("application/json");
    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
    response.getOutputStream().println("{ \"error\": \"" + ex.getMessage() + "\" }");
  }
}
