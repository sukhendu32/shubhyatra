package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.models.Booking;
import com.masai.models.Customer_Checkout;
import com.masai.services.CustomerCheckoutService;

@RestController
public class CheckoutController {
	
	@Autowired
	private CustomerCheckoutService cService;
	
	@PostMapping("/checkout")
	public List<Booking> customerCheckout(@RequestBody Customer_Checkout cc)
	{
		return cService.bookService(cc);
	}
	
	@PostMapping("/checkoutFlight/{Id}/{flightName}")
	public Booking flightBooking(@PathVariable("Id") Integer Id, @PathVariable("flightName") String flightName)
	{
		return cService.flightBooking(Id, flightName);
	}
	
	@PostMapping("/checkoutHotel/{Id}/{hotelName}")
	public Booking hotelBooking(@PathVariable("Id") Integer Id, @PathVariable("hotelName") String hotelName)
	{
		return cService.hotelBooking(Id, hotelName);
	}
	
	@PostMapping("/checkoutTourPackage/{Id}/{tourPackageName}")
	public Booking tourPackageBooking(@PathVariable("Id") Integer Id, @PathVariable("tourPackageName") String tourPackageName)
	{
		return cService.tourPackageBooking(Id, tourPackageName);
	}
	

}
