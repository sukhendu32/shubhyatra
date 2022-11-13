package com.masai.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exceptions.CustomerException;
import com.masai.exceptions.FlightException;
import com.masai.exceptions.HotelException;
import com.masai.exceptions.PaymentException;
import com.masai.exceptions.TourPackageException;
import com.masai.models.Booking;
import com.masai.models.Customer_Checkout;
import com.masai.services.CustomerCheckoutService;

@RestController
public class CheckoutController {
	
	@Autowired
	private CustomerCheckoutService cService;
	
	@PostMapping("/checkout")
	public ResponseEntity<List<Booking>> customerCheckout(@Valid @RequestBody Customer_Checkout cc) throws CustomerException, FlightException, HotelException, TourPackageException, PaymentException
	{
		List<Booking> list = cService.bookService(cc);
		
		return new ResponseEntity<List<Booking>>(list, HttpStatus.CREATED);
	}
	
	@PostMapping("/checkoutFlight/{Id}/{flightName}")
	public ResponseEntity<Booking> flightBooking(@PathVariable("Id") Integer Id,@Valid @PathVariable("flightName") String flightName) throws FlightException, CustomerException, PaymentException
	{
		Booking b = cService.flightBooking(Id, flightName);
		
		return new ResponseEntity<Booking>(b,HttpStatus.CREATED);
	}
	
	@PostMapping("/checkoutHotel/{Id}/{hotelName}")
	public ResponseEntity<Booking> hotelBooking(@PathVariable("Id") Integer Id,@Valid @PathVariable("hotelName") String hotelName) throws HotelException, CustomerException, PaymentException
	{
		Booking b = cService.hotelBooking(Id, hotelName);
		
		return new ResponseEntity<Booking>(b, HttpStatus.CREATED);
	}
	
	@PostMapping("/checkoutTourPackage/{Id}/{tourPackageName}")
	public ResponseEntity<Booking> tourPackageBooking(@PathVariable("Id") Integer Id,@Valid @PathVariable("tourPackageName") String tourPackageName) throws TourPackageException, CustomerException, PaymentException
	{
		Booking b = cService.tourPackageBooking(Id, tourPackageName);
		
		return new ResponseEntity<Booking>(b, HttpStatus.CREATED);
	}
	

}
