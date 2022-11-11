package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.models.Booking;

@Repository
public interface BookingRepo extends JpaRepository<Booking, Integer>{

}
