package com.masai.services;

import java.util.List;

import com.masai.exception.HotelException;
import com.masai.models.Hotel;

public interface HotelService {
	
	public Hotel registerHotel(Hotel hotel) throws HotelException;
	
	public Hotel deleteHotelById(Integer hotelId) throws HotelException;
	
	public List<Hotel> viewAllHotel() throws HotelException;
	

}
