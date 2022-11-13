package com.masai.controller;

import java.time.LocalDateTime;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.service.UserAuthenticationService;

import com.masai.exception.*;
import com.masai.model.*;
import com.masai.service.*;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController {
	
	@Autowired
	UserAuthenticationService service;
	
	@PostMapping(value = "/signup")
	public ResponseEntity<MessageDTO> userSignUp(@Valid @RequestBody User user)throws UserAlreadyExistsException{
		
		User signedUpUser = service.userSignUp(user);
		
		MessageDTO message = new MessageDTO(); 
		
		if(signedUpUser != null) {
			message.setMessage("Registered Successfully");
			message.setTimestamp(LocalDateTime.now());
		}
		
		return new ResponseEntity<MessageDTO>(message,HttpStatus.CREATED);
	}
	
	@PostMapping("/login")
	public ResponseEntity<SessionDTO> userSignIn(@Valid @RequestBody UserDTO user)throws UserAlreadyExistsException, InvalidCredentialsException{
		SessionDTO sdt = service.userLogin(user);
		return new ResponseEntity<SessionDTO>(sdt,HttpStatus.OK);
	}
	
	@PostMapping("/logout")
	public ResponseEntity<MessageDTO> userLogout(@RequestParam(value = "key") String authKey)throws InvalidCredentialsException{
		MessageDTO message = new MessageDTO(); 
		
		String msg = service.userLogout(authKey);
		message.setMessage(msg);
		message.setTimestamp(LocalDateTime.now());
		
		return new ResponseEntity<MessageDTO>(message,HttpStatus.OK);
	}
	
	@PutMapping("/profile")
	public ResponseEntity<String> updateUser(@Valid @RequestBody User user)throws InvalidCredentialsException{
		 service.updateUser(user);
		return new ResponseEntity<String>("User updated successfully...",HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<User> deleteUser(@RequestParam Integer userid,@RequestParam String authKey)throws InvalidCredentialsException{
		User u = service.deleteUser(userid, authKey);
		return new ResponseEntity<User>(u,HttpStatus.OK);
	}
	
	@PostMapping("/appoint")
	public ResponseEntity<User> appointNewAdmin(@RequestParam("email") String email,@RequestParam("code") String passcode)throws InvalidCredentialsException{
		User user = service.makeUserAdmin(email, passcode);
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
}
