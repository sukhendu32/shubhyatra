package com.masai.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.masai.models.SecurityUser;
import com.masai.models.User;
import com.masai.repository.UserRepo;

@Service
public class MyUserDetailsService implements UserDetailsService{
	
	
	@Autowired
	UserRepo repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		//login to fetch the Employee from database
		
		
		User user= repository.findByUserName(username);
		
		if(user!=null)
		{
			return new SecurityUser(user);
		}
		else
		{
			throw new UsernameNotFoundException("User does not exist!!");
		}
		
	}

}
