package com.online.videostreaming.classrooms.onlineclassrooms.drnusers.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.online.videostreaming.classrooms.onlineclassrooms.entity.UsersEntity;

@Service
public class UserAuthenticationService {

  private final DaoAuthenticationProvider daoAuthenticationProvider;

  public UserAuthenticationService(PasswordEncoder passwordEncoder,
                                   @Qualifier("endUserDetailsService") UserDetailsService userDetailsService) {
    this.daoAuthenticationProvider = new DaoAuthenticationProvider();
    this.daoAuthenticationProvider.setPasswordEncoder(passwordEncoder);
    this.daoAuthenticationProvider.setUserDetailsService(userDetailsService);
  }

  public UsersEntity authenticate(String username, String password) throws AuthenticationException {
    UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
    Authentication authentication = this.daoAuthenticationProvider.authenticate(authenticationToken);
    return (UsersEntity) authentication.getPrincipal();
  }
}
