package com.masai.services;

import java.util.List;
import java.util.Optional;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exceptions.FlightException;
import com.masai.exceptions.HotelException;
import com.masai.models.Booking;
import com.masai.models.Hotel;
import com.masai.models.TourPackage;
import com.masai.repository.BookingRepo;
import com.masai.repository.HotelRepo;
import com.masai.repository.TourPackageRepo;

@Service
public class HotelServiceImpl implements HotelService{

	@Autowired
	private HotelRepo hRepo;
	
	@Autowired
	private BookingRepo bRepo;
	
	@Autowired
	private TourPackageRepo tRepo;
	
	@Override
	public Hotel registerHotel(Hotel hotel) throws HotelException {
		
		Hotel h = hRepo.save(hotel);
		
		if(h!=null)
		{
			return h;
		}
		else
		{
			throw new HotelException("Hotel not registered!");
		}
	}

	@Override
	public Hotel deleteHotelById(Integer hotelId) throws HotelException {
		
		Optional<Hotel> opt = hRepo.findById(hotelId);
		
		
			
		if(opt.isPresent())
		{
			List<Booking> list = bRepo.findAll();
			
			for(Booking b:list)
			{
				if(b.getBookedHotel().equals(opt.get()))
				{
					throw new HotelException("This hotel has bookings!");
				}
			}
			
			List<TourPackage> listTour  = tRepo.findAll();
			
			for(TourPackage t:listTour)
			{
				if(t.getHotel().getHotelId()==hotelId)
				{
					throw new HotelException("This hotel is registered with TourPackage!");
				}
			}
			
			hRepo.delete(opt.get());
			
			return opt.get();
		}
		else
		{
			throw new HotelException("Hotel does not exist with Id "+hotelId);
		}
		
		
	}

	@Override
	public List<Hotel> viewAllHotel() throws HotelException {
		
		List<Hotel> list = hRepo.findAll();
		
		if(list.size()>0)
		{
			return list;
		}
		else
		{
			throw new HotelException("Hotels not available!");
		}
	}

	@Override
	public Hotel updateHotel(Hotel hotel) throws HotelException {
		
		Optional<Hotel> opt = hRepo.findById(hotel.getHotelId());
		
		if(opt.isPresent())
		{
			
			hRepo.save(hotel);
			
			return hotel;
		}
		else
		{
			throw new HotelException("Hotel not found by given details");
		}
		
	}
	
	@Override
	public Hotel findHotelById(Integer hotelId) throws HotelException {
		
		Optional<Hotel> opt = hRepo.findById(hotelId);
		
		if(opt.isPresent())
		{
			return opt.get();
		}
		else
		{
			throw new HotelException("Hotel does not exist with Id "+hotelId);
		}
	}

}
