package com.masai.services;

import java.util.List;

import com.masai.exceptions.UserException;
import com.masai.exceptions.FlightException;
import com.masai.exceptions.HotelException;
import com.masai.exceptions.PaymentException;
import com.masai.exceptions.TourPackageException;
import com.masai.models.Booking;
import com.masai.models.Customer_Checkout;

public interface CustomerCheckoutService {
	
	public List<Booking> bookService(Customer_Checkout cc)throws UserException, FlightException, 
	HotelException, TourPackageException, PaymentException;
	
	public Booking flightBooking(Integer Id, String flightName)throws FlightException, UserException, PaymentException;
	
	public Booking hotelBooking(Integer Id, String hotelName)throws HotelException, UserException, PaymentException;
	
	public Booking tourPackageBooking(Integer Id, String tourPackageName)throws TourPackageException, UserException, PaymentException;
	

}
