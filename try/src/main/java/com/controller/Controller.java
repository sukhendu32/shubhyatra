package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.model.Flight;
import com.model.Hotel;
import com.model.User;
import com.model.UserDTO;
import com.service.AllService;

@RestController
public class Controller {
	
	@Autowired
	private AllService s;
	
	@PostMapping("/flight")
	public String bookFlight(@RequestBody Flight flight)
	{
		return s.flightRegister(flight);
		
	}
	

	@PostMapping("/hotel")
	public String bookHotel(@RequestBody Hotel hotel)
	{
		return s.hotelRegister(hotel);
		
	}
	

	@PostMapping("/user")
	public String registerUser(@RequestBody User user)
	{
		return s.userRegister(user);
		
	}
	
	@PostMapping("/booking")
	public String booking(@RequestBody UserDTO u)
	{
		return s.bookingRegister(u);
	}
	

	
	
	
	

}
