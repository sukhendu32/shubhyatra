package com.masai.services;

import java.util.List;

import com.masai.exception.FlightException;
import com.masai.models.Flight;

public interface FlightService {
	
	public Flight registerFlight(Flight flight) throws FlightException;
	
	public Flight deleteFlightById(Integer flightId) throws FlightException;
	
	public List<Flight> viewAllFlight() throws FlightException;

}
