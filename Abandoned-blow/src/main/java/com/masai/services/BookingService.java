package com.masai.services;

import java.util.List;

import com.masai.exceptions.BookingException;
import com.masai.exceptions.UserException;
import com.masai.models.Booking;

public interface BookingService {

	public Booking deleteBookingById(Integer bookingId) throws BookingException;
	
	public List<Booking> viewBookingById(Integer userId) throws UserException;
	
	public List<Booking> viewAllBooking() throws BookingException;

}
