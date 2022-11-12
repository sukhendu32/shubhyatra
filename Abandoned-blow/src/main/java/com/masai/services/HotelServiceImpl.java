package com.masai.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.HotelException;
import com.masai.models.Hotel;
import com.masai.repository.HotelRepo;

@Service
public class HotelServiceImpl implements HotelService{

	@Autowired
	private HotelRepo hRepo;
	
	@Override
	public Hotel registerHotel(Hotel hotel) throws HotelException{
		
		Hotel h = hRepo.save(hotel);
		
		if(h!=null)
		{
			return h;
		}
		else
		{
			return null;
		}
	}

	@Override
	public Hotel deleteHotelById(Integer hotelId) throws HotelException{
		
		Optional<Hotel> opt = hRepo.findById(hotelId);
		
		if(opt.isPresent())
		{
			hRepo.delete(opt.get());
			
			return opt.get();
		}
		else
		{
			return null;
		}
	}

	@Override
	public List<Hotel> viewAllHotel() throws HotelException{
		
		List<Hotel> list = hRepo.findAll();
		
		if(list.size()>0)
		{
			return list;
		}
		else
		{
			return null;
		}
	}

}
