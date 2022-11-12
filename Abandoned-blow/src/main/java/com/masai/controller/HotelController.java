package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.HotelException;
import com.masai.models.Hotel;
import com.masai.services.HotelService;

@RestController
public class HotelController {
	
	@Autowired
	private HotelService hService;
	
	@PostMapping("/hotel")
	public Hotel registerHotel(@RequestBody Hotel hotel) throws HotelException
	{
		return hService.registerHotel(hotel);
	}
	
	@DeleteMapping("/hotel/{Id}/{user}")
	public Hotel deleteHotel(@PathVariable("Id") Integer Id, @PathVariable("user") String user) throws HotelException
	{
		if(user.equals("admin"))
		{
			return hService.deleteHotelById(Id);
		}
		else
		{
			return null;
		}
		
	}
	
	@GetMapping("/hotel")
	public List<Hotel> viewAllHotel() throws HotelException
	{
		return hService.viewAllHotel();
	}

}
