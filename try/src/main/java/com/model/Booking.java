package com.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Booking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer bookingId;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Flight flight;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Hotel hotel;
	
	
	private LocalDateTime time;

	public Integer getBookingId() {
		return bookingId;
	}

	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	
	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", flight=" + flight + ", hotel=" + hotel + ", time=" + time + "]";
	}

	public Booking(Integer bookingId, Flight flight, Hotel hotel, LocalDateTime time) {
		super();
		this.bookingId = bookingId;
		this.flight = flight;
		this.hotel = hotel;
	
		this.time = time;
	}
	
	public Booking() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	

}
