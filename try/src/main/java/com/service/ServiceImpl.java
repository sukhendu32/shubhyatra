package com.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Booking;
import com.model.Flight;
import com.model.Hotel;
import com.model.User;
import com.model.UserDTO;
import com.repository.BookingRepo;
import com.repository.FlightRepo;
import com.repository.HotelRepo;

import com.repository.UserRepo;

@Service
public class ServiceImpl implements AllService{

	@Autowired
	private BookingRepo bRepo;
	
	@Autowired
	private FlightRepo fRepo;
	
	@Autowired
	private UserRepo uRepo;
	
	@Autowired
	private HotelRepo hRepo;
	

	
	
	
	
	@Override
	public String flightRegister(Flight flight) {
		
		fRepo.save(flight);
		
		return "success!";
	}

	

	@Override
	public String hotelRegister(Hotel hotel) {
		
		hRepo.save(hotel);
		
		return "success!";
	}

	@Override
	public String userRegister(User user) {
		
		uRepo.save(user);
		
		return "success!";
	}



	@Override
	public String bookingRegister(UserDTO userDTO) {
		
		if(userDTO.getUserId().length()>0)
		{
			Optional<User> u = uRepo.findById(Integer.parseInt(userDTO.getUserId()));
			
			User u2 = u.get();
			
			if(userDTO.getFlightId().length()>0)
			{
				Optional<Flight> f = fRepo.findById(Integer.parseInt(userDTO.getFlightId()));
				
				Flight f2 = f.get();
				
				f2.getUser().add(u2);
				
				Booking b = new Booking();
				
				b.setFlight(f2);
				
				b.setTime(LocalDateTime.now());
				
				u2.getBooking().add(b);
				
				bRepo.save(b);
			}
			
			if(userDTO.getHotelId().length()>0)
			{
				Optional<Hotel> h = hRepo.findById(Integer.parseInt(userDTO.getHotelId()) );
				
				Hotel h2 = h.get();
				
				h2.getUser().add(u2);
				
				Booking b = new Booking();
				
				b.setHotel(h2);
				
				b.setTime(LocalDateTime.now());
				
				u2.getBooking().add(b);
				
				bRepo.save(b);
				
				
			}
			
			return "booked successfully!";
			
			
		}
		else
		{
			return "wrong userId";
		}
	}

}
