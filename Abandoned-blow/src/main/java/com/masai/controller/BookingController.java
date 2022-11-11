package com.masai.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RestController;

import com.masai.models.Booking;
import com.masai.services.BookingService;

@RestController
public class BookingController {
	
	@Autowired
	private BookingService bService;
	
	@GetMapping("/booking/{Id}")
	public List<Booking> viewBookingById(@PathVariable("Id") Integer Id)
	{
		return bService.viewBookingById(Id);
	}
	
	@GetMapping("/booking")
	public List<Booking> viewAllBooking()
	{
		return bService.viewAllBooking();
	}
	
	@DeleteMapping("/booking/{Id}")
	public Booking deleteBookingById(@PathVariable("Id") Integer Id)
	{
		return bService.deleteBookingById(Id);
	}

}
