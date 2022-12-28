package com.masai.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exceptions.UserException;
import com.masai.models.User;
import com.masai.services.UserService;

@RestController
@RequestMapping("/travel")
public class UserController {
	
	@Autowired
	private UserService uService;
	
	@Autowired
	private PasswordEncoder password;
	
	@PostMapping("")
	public ResponseEntity<User> registerCustomer(@Valid @RequestBody User user) throws UserException
	{
		user.setPassword(password.encode(user.getPassword()));
		
		User c = uService.registerUser(user);
		return 	new ResponseEntity<User>(c,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/customer/{userId}")
	public ResponseEntity<User> deleteCustomer(@PathVariable("userId") Integer Id) throws UserException
	{
		User c = uService.deleteUserById(Id);
		return new ResponseEntity<User>(c,HttpStatus.OK);
	}
	
	@GetMapping("/customer")
	public ResponseEntity<List<User>> viewAllCustomer() throws UserException
	{
		List<User> list = uService.viewAllUser();
		return new ResponseEntity<List<User>>(list,HttpStatus.OK);
	}
	
	@GetMapping("/customer/{userId}")
	public ResponseEntity<User> findCustomerById(@PathVariable("userId") Integer Id) throws UserException
	{
		User c = uService.findUserById(Id);
		return new ResponseEntity<User>(c,HttpStatus.OK);
	}
	
	@PutMapping("/customer")
	public ResponseEntity<User> udateCustomerDetails(@Valid @RequestBody User user) throws UserException
	{
		User c = uService.updateUser(user);
		
		return new ResponseEntity<User>(c,HttpStatus.OK);
	}
	
	

}
