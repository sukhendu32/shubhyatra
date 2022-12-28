package com.masai.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exceptions.BookingException;
import com.masai.exceptions.UserException;
import com.masai.exceptions.FlightException;
import com.masai.models.Booking;
import com.masai.models.User;
import com.masai.repository.BookingRepo;
import com.masai.repository.UserRepo;

@Service
public class BookingServiceImpl implements BookingService{

	@Autowired
	private BookingRepo bRepo;
	
	@Autowired
	private UserRepo cRepo;
	
	@Override
	public Booking deleteBookingById(Integer bookingId) throws BookingException{
		
		Optional<Booking> opt =  bRepo.findById(bookingId);
		
		List<User> list = cRepo.findAll();
		
		for(User c:list)
		{
			if(c.getBooking().contains(opt.get()))
			{
				c.getBooking().remove(opt.get());
				cRepo.save(c);
			}
			
		}
		
		
		
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
	public List<Booking> viewBookingById(Integer userId) throws UserException {
		
		Optional<User> opt = cRepo.findById(userId);
		
		if(opt.isPresent())
		{
			User c = opt.get();
			
			List<Booking> b = c.getBooking();
			
			return b;
		}
		else
		{
			throw new UserException("Customer does not exist with Id "+userId);
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
