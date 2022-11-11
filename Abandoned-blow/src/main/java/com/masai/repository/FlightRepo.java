package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.models.Flight;

@Repository
public interface FlightRepo extends JpaRepository<Flight, Integer>{
	
	public Flight findByFlightCompany(String name);

}
