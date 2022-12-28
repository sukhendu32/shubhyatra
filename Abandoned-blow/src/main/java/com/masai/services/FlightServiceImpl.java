package com.masai.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exceptions.FlightException;
import com.masai.exceptions.HotelException;
import com.masai.models.Booking;
import com.masai.models.Flight;
import com.masai.models.TourPackage;
import com.masai.repository.BookingRepo;
import com.masai.repository.FlightRepo;
import com.masai.repository.TourPackageRepo;

@Service
public class FlightServiceImpl  implements FlightService{

	@Autowired
	private FlightRepo fRepo; 
	
	@Autowired
	private BookingRepo bRepo;
	
	@Autowired
	private TourPackageRepo tRepo;
	
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
			List<Booking> list = bRepo.findAll();
			
			for(Booking b:list)
			{
				if(b.getBookedFlight().equals(opt.get()))
				{
					throw new FlightException("This Flight has bookings!");
				}
			}
			
			List<TourPackage> listTour  = tRepo.findAll();
			
			for(TourPackage t:listTour)
			{
				if(t.getFlight().getFlightId()==flightId)
				{
					throw new FlightException("This flight is registered with TourPackage!");
				}
			}
			
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
