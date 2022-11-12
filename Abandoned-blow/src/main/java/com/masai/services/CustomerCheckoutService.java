package com.masai.services;

import java.util.List;

import com.masai.exceptions.CustomerException;
import com.masai.exceptions.FlightException;
import com.masai.exceptions.HotelException;
import com.masai.exceptions.PaymentException;
import com.masai.exceptions.TourPackageException;
import com.masai.models.Booking;
import com.masai.models.Customer_Checkout;

public interface CustomerCheckoutService {
	
	public List<Booking> bookService(Customer_Checkout cc)throws CustomerException, FlightException, 
	HotelException, TourPackageException, PaymentException;
	
	public Booking flightBooking(Integer Id, String flightName)throws FlightException, CustomerException, PaymentException;
	
	public Booking hotelBooking(Integer Id, String hotelName)throws HotelException, CustomerException, PaymentException;
	
	public Booking tourPackageBooking(Integer Id, String tourPackageName)throws TourPackageException, CustomerException, PaymentException;
	

}
