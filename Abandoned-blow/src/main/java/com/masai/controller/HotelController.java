package com.masai.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exceptions.HotelException;
import com.masai.models.Hotel;
import com.masai.services.HotelService;

@RestController
public class HotelController {
	
	@Autowired
	private HotelService hService;
	
	@PostMapping("/hotel")
	public ResponseEntity<Hotel>  registerHotel(@Valid @RequestBody Hotel hotel) throws HotelException
	{
		Hotel h = hService.registerHotel(hotel); 
		return new ResponseEntity<Hotel>(h, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/hotel/{userId}")
	public ResponseEntity<Hotel> deleteHotel(@PathVariable("userId") Integer Id) throws HotelException
	{
		
			Hotel h = hService.deleteHotelById(Id); 
			return new ResponseEntity<Hotel>(h,HttpStatus.OK);
	
	}
	
	@GetMapping("/hotel")
	public ResponseEntity<List<Hotel>> viewAllHotel() throws HotelException
	{
		List<Hotel> list = hService.viewAllHotel();
		return new ResponseEntity<List<Hotel>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/hotel/{userId}")
	public ResponseEntity<Hotel> findHotelById(@PathVariable("userId") Integer Id) throws HotelException
	{
		
			Hotel h = hService.findHotelById(Id); 
			return new ResponseEntity<Hotel>(h,HttpStatus.OK);
	
	}
	
	@PutMapping("/hotel")
	public ResponseEntity<Hotel> updateHotelDetails(@Valid @RequestBody Hotel hotel) throws HotelException
	{
		Hotel h = hService.updateHotel(hotel);
		
		return new ResponseEntity<Hotel>(h,HttpStatus.OK);
	}

}
