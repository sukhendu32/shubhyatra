package com.masai.service;

import org.springframework.stereotype.Service;

import com.masai.exception.InvalidCredentialsException;
import com.masai.exception.UserAlreadyExistsException;
import com.masai.model.SessionDTO;
import com.masai.model.User;
import com.masai.model.UserDTO;


@Service
public interface UserAuthenticationService {
	
	public User userSignUp(User user) throws UserAlreadyExistsException;
	public SessionDTO userLogin(UserDTO user) throws InvalidCredentialsException;
	public String userLogout(String authKey) throws InvalidCredentialsException;
	public boolean updateUser(User user) throws InvalidCredentialsException;
	
	/* ADMIN ACCESS ONLY */
	public User deleteUser(Integer userId, String authKey) throws InvalidCredentialsException;
	public User makeUserAdmin(String userEmail, String passcode) throws InvalidCredentialsException;
	
}
