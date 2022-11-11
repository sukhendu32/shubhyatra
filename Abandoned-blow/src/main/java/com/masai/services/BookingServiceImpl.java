package com.masai.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public Booking deleteBookingById(Integer bookingId) {
		
		Optional<Booking> opt =  bRepo.findById(bookingId);
		
		if(opt.isPresent())
		{
			Booking b = opt.get();
			
			bRepo.delete(b);
			
			return b;
		}
		else
		{
			return null;
		}
	}

	@Override
	public List<Booking> viewBookingById(Integer userId) {
		
		Optional<Customer> opt = cRepo.findById(userId);
		
		if(opt.isPresent())
		{
			Customer c = opt.get();
			
			List<Booking> b = c.getBooking();
			
			return b;
		}
		else
		{
			return null;
		}
	}

	@Override
	public List<Booking> viewAllBooking() {
		
		List<Booking> b = bRepo.findAll();
		
		if(b.size()>0)
		{
			return b;
		}
		else
		{
			return null;
		}
	}

}
