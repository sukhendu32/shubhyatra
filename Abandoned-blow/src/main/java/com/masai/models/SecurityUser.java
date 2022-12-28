package com.masai.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class SecurityUser implements UserDetails{
	
	User user;
	
	public SecurityUser(User user) {
		super();
		this.user = user;
	}


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
		
		SimpleGrantedAuthority grantedAuthority = new SimpleGrantedAuthority(user.getRole());
		
		grantedAuthorities.add(grantedAuthority);
	
		return grantedAuthorities;
	}


	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return user.getPassword();
	}


	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getUserName();
	}


	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	
}
