package com.masai.services;

import java.util.List;

import com.masai.models.Flight;

public interface FlightService {
	
	public Flight registerFlight(Flight flight);
	
	public Flight deleteFlightById(Integer flightId);
	
	public List<Flight> viewAllFlight();

}
