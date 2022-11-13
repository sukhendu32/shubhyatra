package com.masai.service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.*;
import com.masai.model.*;
import com.masai.repository.*;

@Service
@Transactional
public class UserAuthenticationServiceImpl implements UserAuthenticationService {
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	SessionRepository sessionRepo;
	
	@Override
	public User userSignUp(User user) throws UserAlreadyExistsException {
		Optional<User> opt = userRepo.findByEmail(user.getEmail());
		if(opt.isPresent()) {
			throw new UserAlreadyExistsException("User already registered");
		}
		userRepo.save(user);
		return user;
	}

	@Override
	public SessionDTO userLogin(UserDTO user) throws InvalidCredentialsException {
		Optional<User> opt = userRepo.findByEmail(user.getEmail());
		if(!opt.isPresent()) {
			throw new InvalidCredentialsException("User doesn't exists...");
		}
		Optional<CurrentUserLoginSession> sessionExistence = sessionRepo.findByUserId(opt.get().getUserId());
		if(sessionExistence.isPresent()) {
			throw new InvalidCredentialsException("User already logged in");
		}
		if(!(opt.get().getEmail().equals(user.getEmail()))){
			throw new InvalidCredentialsException("Invalid Email Address...");
		}
		else if(!(opt.get().getPassword().equals(user.getPassword()))) {
			throw new InvalidCredentialsException("Invalid Password...");
		}
		else if(!(opt.get().getPassword().equals(user.getPassword()) && opt.get().getEmail().equals(user.getEmail()))){
			throw new InvalidCredentialsException("Invalid Credentials...");
		}
		SessionDTO sdt = new SessionDTO();
		CurrentUserLoginSession culs = new CurrentUserLoginSession();
		String authKey = UUID.randomUUID().toString();
		culs.setAuthKey(authKey);
		culs.setSessionStartTime(LocalDateTime.now());
		sdt.setAuthKey(culs.getAuthKey());
		sdt.setSessionStartTime(culs.getSessionStartTime());
		culs.setUserId(opt.get().getUserId());
		sessionRepo.save(culs);
		return sdt;
	}

	@Override
	public String userLogout(String authKey)throws InvalidCredentialsException {
		Optional<CurrentUserLoginSession> culs = sessionRepo.findByAuthKey(authKey);
		if(!culs.isPresent()) {
			throw new InvalidCredentialsException("User has not logged In with key : "+authKey);
		}
		sessionRepo.delete(culs.get());
		return "Logged out successfully.";
	}

	@Override
	public User makeUserAdmin(String userEmail,String code) throws InvalidCredentialsException {
		if(!code.equals("admin")) {
			throw new InvalidCredentialsException("Invalid Passcode...");
		}
		else if(userEmail.equals(null)) {
			throw new InvalidCredentialsException("Invalid Email Address");
		}
		Optional<User> user = userRepo.findByEmail(userEmail);
		if(!user.isPresent()) {
			throw new InvalidCredentialsException("User not found with Id "+userEmail);
		}
		user.get().setUserType("admin");
		userRepo.save(user.get());
		return user.get();
	}

	@Override
	public boolean updateUser(User user) throws InvalidCredentialsException {
		Optional<User> checkUser = userRepo.findByEmail(user.getEmail());
		if(!checkUser.isPresent())throw new InvalidCredentialsException("User doesn't exists with Id "+user.getEmail());
		User u = userRepo.save(user);
		return u!=null;
}

	@Override
	public User deleteUser(Integer userId, String authKey) throws InvalidCredentialsException {
		Optional<CurrentUserLoginSession> culs = sessionRepo.findByAuthKey(authKey);
		if(!culs.isPresent()) {
			throw new InvalidCredentialsException("Invalid Authentication Key");
		}
		String userType = userRepo.findById(culs.get().getUserId()).get().getUserType();
		if(userType.equalsIgnoreCase("user")) {
			throw new InvalidCredentialsException("Unauthorized Request...");
		}
		Optional<User> user = userRepo.findById(userId);
		if(!user.isPresent())throw new InvalidCredentialsException("User doesn't exits with Id "+userId);
		userRepo.delete(user.get());
		return user.get();
	}	
}
