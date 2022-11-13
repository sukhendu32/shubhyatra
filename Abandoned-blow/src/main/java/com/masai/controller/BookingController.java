package com.masai.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RestController;

import com.masai.exceptions.BookingException;
import com.masai.exceptions.CustomerException;
import com.masai.models.Booking;
import com.masai.services.BookingService;

@RestController
public class BookingController {
	
	@Autowired
	private BookingService bService;
	
	@GetMapping("/booking/{customerId}")
	public ResponseEntity<List<Booking>>  viewBookingById(@PathVariable("customerId") Integer Id) throws CustomerException
	{
		List<Booking> list = bService.viewBookingById(Id);
		
		return new ResponseEntity<List<Booking>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/booking")
	public ResponseEntity<List<Booking>>  viewAllBooking() throws BookingException
	{
		List<Booking> list = bService.viewAllBooking();
		
		return new ResponseEntity<List<Booking>>(list, HttpStatus.OK);
	}
	
	@DeleteMapping("/booking/{bookingId}")
	public ResponseEntity<Booking> deleteBookingById(@PathVariable("bookingId") Integer Id) throws BookingException
	{
		Booking b  = bService.deleteBookingById(Id);
		
		return new ResponseEntity<Booking>(b,HttpStatus.OK);
	}

}
