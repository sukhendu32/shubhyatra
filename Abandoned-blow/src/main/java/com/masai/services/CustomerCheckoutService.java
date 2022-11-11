package com.masai.services;

import java.util.List;

import com.masai.models.Booking;
import com.masai.models.Customer_Checkout;

public interface CustomerCheckoutService {
	
	public List<Booking> bookService(Customer_Checkout cc);
	
	public Booking flightBooking(Integer Id, String flightName);
	
	public Booking hotelBooking(Integer Id, String hotelName);
	
	public Booking tourPackageBooking(Integer Id, String tourPackageName);
	

}
