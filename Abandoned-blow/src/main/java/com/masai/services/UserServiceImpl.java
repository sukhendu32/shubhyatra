package com.masai.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exceptions.UserException;
import com.masai.models.Booking;
import com.masai.models.User;
import com.masai.models.Flight;
import com.masai.repository.BookingRepo;
import com.masai.repository.UserRepo;
import com.masai.repository.FlightRepo;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepo cRepo;

	@Autowired
	private FlightRepo fRepo;
	
	@Autowired
	private BookingRepo brepo;
	
	@Override
	public User registerUser(User user) throws UserException {
		
		User c = cRepo.save(user);
		
		if(c!=null)
		{
			return c;
		}
		else
		{
			throw new UserException("User not registered!");
		}
	}

	@Override
	public User deleteUserById(Integer userId) throws UserException {
		
		Optional<User> opt = cRepo.findById(userId);
		
		List<Flight> list = fRepo.findAll();
			
		if(opt.isPresent())
		{
			
			cRepo.delete(opt.get());
				
			return opt.get();
			
			
		}
		else
		{
			throw new UserException("User does not exist with Id "+userId);
		}
		
		
		
	}

	@Override
	public List<User> viewAllUser() throws UserException {
		List<User> list =  cRepo.findAll();
		
		if(list.size()>0)
		{
			return list;
		}
		else
		{
			throw new UserException("No user available!");
		}
	}

	@Override
	public User updateUser(User user) throws UserException {
		
		Optional<User> opt = cRepo.findById(user.getUserId());
		
		if(opt.isPresent())
		{
			cRepo.save(user);
			
			return user;
		}
		else
		{
			throw new UserException("Customer not found by given details");
		}
	}
	
	@Override
	public User findUserById(Integer userId) throws UserException {
		
		Optional<User> opt = cRepo.findById(userId);
		
		if(opt.isPresent())
		{
			return opt.get();
		}
		else
		{
			throw new UserException("Customer does not exist with Id "+userId);
		}
	}
	

}
