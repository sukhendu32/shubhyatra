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

import com.masai.exceptions.FlightException;
import com.masai.models.Flight;
import com.masai.services.FlightService;

@RestController
public class FlightController {
	
	@Autowired
	private FlightService fService;
	
	@PostMapping("/flight")
	public ResponseEntity<Flight>  registerFlight(@Valid @RequestBody Flight flight) throws FlightException
	{
		Flight f = fService.registerFlight(flight);
		return new ResponseEntity<Flight>(f, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/flight/{userId}")
	public ResponseEntity<Flight> deleteFlight(@PathVariable("userId") Integer Id) throws FlightException
	{
		Flight f = fService.deleteFlightById(Id);
		return new ResponseEntity<Flight>(f,HttpStatus.OK);
	}
	
	@GetMapping("/flight")
	public ResponseEntity<List<Flight>>  viewAllFlight() throws FlightException
	{
		List<Flight> list = fService.viewAllFlight(); 
		
		return new ResponseEntity<List<Flight>>(list, HttpStatus.OK);
				
	}
	
	@GetMapping("/flight/{userId}")
	public ResponseEntity<Flight> findFlightById(@PathVariable("userId") Integer Id) throws FlightException
	{
		Flight f = fService.findFlightById(Id);
		
		return new ResponseEntity<Flight>(f,HttpStatus.OK);
	}
	
	@PutMapping("/flight")
	public ResponseEntity<Flight> updateFlightDetails(@Valid @RequestBody Flight flight) throws FlightException
	{
		Flight f = fService.updateFlight(flight);
		
		return new ResponseEntity<Flight>(f,HttpStatus.OK);
	}
	

}
