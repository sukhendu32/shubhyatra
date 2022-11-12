package com.masai.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exceptions.BookingException;
import com.masai.exceptions.CustomerException;
import com.masai.exceptions.FlightException;
import com.masai.models.Booking;
import com.masai.models.Customer;
import com.masai.repository.BookingRepo;
import com.masai.repository.CustomerRepo;

@Service
public class BookingServiceImpl implements BookingService{

	@Autowired
	private BookingRepo bRepo;
	
	@Autowired
	private CustomerRepo cRepo;
	
	@Override
	public Booking deleteBookingById(Integer bookingId) throws BookingException{
		
		Optional<Booking> opt =  bRepo.findById(bookingId);
		
		if(opt.isPresent())
		{
			Booking b = opt.get();
			
			bRepo.delete(b);
			
			return b;
		}
		else
		{
			throw new BookingException("Booking does not exist with Id "+bookingId);
		}
	}

	@Override
	public List<Booking> viewBookingById(Integer userId) throws CustomerException {
		
		Optional<Customer> opt = cRepo.findById(userId);
		
		if(opt.isPresent())
		{
			Customer c = opt.get();
			
			List<Booking> b = c.getBooking();
			
			return b;
		}
		else
		{
			throw new CustomerException("Customer does not exist with Id "+userId);
		}
	}

	@Override
	public List<Booking> viewAllBooking() throws BookingException {
		
		List<Booking> b = bRepo.findAll();
		
		if(b.size()>0)
		{
			return b;
		}
		else
		{
			throw new BookingException("No bookings available!");
		}
	}

}
