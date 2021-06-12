package com.online.videostreaming.classrooms.onlineclassrooms.drnusers;



import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.online.videostreaming.classrooms.onlineclassrooms.entity.UsersEntity;

public class EndUserDetails extends UsersEntity implements UserDetails {

private static final long serialVersionUID = 1L;

public EndUserDetails(UsersEntity user) {
    super(user.getUserId(), user.getFirstName(),user.getMiddleName(),user.getLastName(),user.getEmail(), user.getUserPassword(),
            user.getRoles(), user.getPhone(), user.getDeactivatedReason(), user.getBatch(),user.getCorrespondanceAddress(),
            user.getPermanentAddress(), user.getFatherName(), user.getMiddleName(),
            user.getFailedAttempt(),user.getIsAccountNonLocked(),user.getLockTime());
  }

  @Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();

		getRoles().forEach(r -> {
			authorities.add(new SimpleGrantedAuthority(r.getRole()));

		});

		return authorities;
	}

	@Override
	public String getUsername() {
		return getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public String getPassword() {
		return getUserPassword();
	}

}
