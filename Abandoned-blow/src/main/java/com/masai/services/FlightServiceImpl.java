package com.masai.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exceptions.FlightException;
import com.masai.models.Flight;
import com.masai.repository.FlightRepo;

@Service
public class FlightServiceImpl  implements FlightService{

	@Autowired
	private FlightRepo fRepo; 
	
	@Override
	public Flight registerFlight(Flight flight) throws FlightException {
		
		Flight f = fRepo.save(flight);
		
		if(f!=null)
		{
			return f;
		}
		else
		{
			throw new FlightException("Flight not registered");
		}
	}

	@Override
	public Flight deleteFlightById(Integer flightId) throws FlightException {
		
		Optional<Flight> opt = fRepo.findById(flightId);
		
		if(opt.isPresent())
		{
			Flight f2 = opt.get();
			
			fRepo.delete(f2);
			
			return f2;
		}
		else
		{
			throw new FlightException("Flight does not exist with Id "+flightId);
		}
	}

	@Override
	public List<Flight> viewAllFlight() throws FlightException {
		List<Flight> list = fRepo.findAll();
		
		if(list.size()>0)
		{
			return list;
		}
		else
		{
			throw new FlightException("Flights not available!");
		}
	}

	@Override
	public Flight updateFlight(Flight flight) throws FlightException {
		
		Optional<Flight> opt = fRepo.findById(flight.getFlightId());
		
		if(opt.isPresent())
		{
			fRepo.save(flight);
			
			return flight;
		}
		else
		{
			throw new FlightException("Flight not found by given details");
		}
		
		
	}
	
	
	@Override
	public Flight findFlightById(Integer flightId) throws FlightException {
		
		Optional<Flight> opt = fRepo.findById(flightId);
		
		if(opt.isPresent())
		{
			Flight f2 = opt.get();
			
			return f2;
		}
		else
		{
			throw new FlightException("Flight does not exist with Id "+flightId);
		}
	}

}
