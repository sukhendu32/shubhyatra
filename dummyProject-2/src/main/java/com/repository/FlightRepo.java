package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.Flight;

@Repository
public interface FlightRepo extends JpaRepository<Flight, Integer>{

}
