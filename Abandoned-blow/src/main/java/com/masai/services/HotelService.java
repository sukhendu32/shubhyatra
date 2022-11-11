package com.masai.services;

import java.util.List;

import com.masai.models.Hotel;

public interface HotelService {
	
	public Hotel registerHotel(Hotel hotel);
	
	public Hotel deleteHotelById(Integer hotelId);
	
	public List<Hotel> viewAllHotel();
	

}
