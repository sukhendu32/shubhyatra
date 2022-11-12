package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.FlightException;
import com.masai.models.Flight;
import com.masai.services.FlightService;

@RestController
public class FlightController {
	
	@Autowired
	private FlightService fService;
	
	@PostMapping("/flight")
	public Flight registerFlight(@RequestBody Flight flight) throws FlightException
	{
		return fService.registerFlight(flight);
	}
	
	@DeleteMapping("/flight/{Id}")
	public Flight deleteFlight(@PathVariable("Id") Integer Id) throws FlightException
	{
		return fService.deleteFlightById(Id);
	}
	
	@GetMapping("/flight")
	public List<Flight> viewAllFlight() throws FlightException
	{
		return fService.viewAllFlight();
		
	}
	

}
