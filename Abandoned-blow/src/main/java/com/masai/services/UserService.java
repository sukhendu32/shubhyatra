package com.masai.services;

import java.util.List;

import com.masai.exceptions.UserException;
import com.masai.models.User;

public interface UserService {
	
	public User registerUser(User user) throws UserException;
	
	public User updateUser(User user) throws UserException;
	
	public User deleteUserById(Integer userId) throws UserException;
	
	public User findUserById(Integer userId) throws UserException;
	
	public List<User> viewAllUser() throws UserException;

}
