package com.online.videostreaming.classrooms.onlineclassrooms.drnusers.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.online.videostreaming.classrooms.onlineclassrooms.drnusers.EndUserDetails;

@Qualifier("endUserDetailsService")
@Service
public class EndUserDetailsService implements UserDetailsService {
    @Autowired
    private  UserService userService;
   
    @Transactional
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	
    	EndUserDetails endUserDetails=null;
		try {
			endUserDetails = userService.findUserByUserName(username)
			.map(EndUserDetails::new)
			.orElseThrow(() -> new UsernameNotFoundException("No user found"));
			 return endUserDetails;
		} catch (UsernameNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
        return endUserDetails;
    }
}
