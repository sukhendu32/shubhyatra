package com.masai.services;

import java.util.List;

import com.masai.models.Booking;

public interface BookingService {

	public Booking deleteBookingById(Integer bookingId);
	
	public List<Booking> viewBookingById(Integer userId);
	
	public List<Booking> viewAllBooking();

}
