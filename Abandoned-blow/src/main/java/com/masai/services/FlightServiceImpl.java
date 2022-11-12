package com.masai.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.FlightException;
import com.masai.models.Flight;
import com.masai.repository.FlightRepo;

@Service
public class FlightServiceImpl  implements FlightService{

	@Autowired
	private FlightRepo fRepo; 
	
	@Override
	public Flight registerFlight(Flight flight) throws FlightException{
		
		Flight f = fRepo.save(flight);
		
		if(f!=null)
		{
			return f;
		}
		else
		{
			return null;
		}
	}

	@Override
	public Flight deleteFlightById(Integer flightId) throws FlightException{
		
		Optional<Flight> opt = fRepo.findById(flightId);
		
		if(opt.isPresent())
		{
			Flight f2 = opt.get();
			
			fRepo.delete(f2);
			
			return f2;
		}
		else
		{
			return null;
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
			return null;
		}
	}

}
