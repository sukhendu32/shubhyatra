package com.masai.models;

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
	
	private LocalDateTime bookingTime;
	
	private Integer bookingAmount;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	private Hotel bookedHotel;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	private Flight bookedFlight;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	private TourPackage bookedTourPackage;
	
	
	public Booking() {
		// TODO Auto-generated constructor stub
	}


	public Booking(Integer bookingId, LocalDateTime bookingTime, Integer bookingAmount, Hotel bookedHotel,
			Flight bookedFlight, TourPackage bookedTourPackage) {
		super();
		this.bookingId = bookingId;
		this.bookingTime = bookingTime;
		this.bookingAmount = bookingAmount;
		this.bookedHotel = bookedHotel;
		this.bookedFlight = bookedFlight;
		this.bookedTourPackage = bookedTourPackage;
	}


	public Integer getBookingId() {
		return bookingId;
	}


	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}


	public LocalDateTime getBookingTime() {
		return bookingTime;
	}


	public void setBookingTime(LocalDateTime bookingTime) {
		this.bookingTime = bookingTime;
	}


	public Integer getBookingAmount() {
		return bookingAmount;
	}


	public void setBookingAmount(Integer bookingAmount) {
		this.bookingAmount = bookingAmount;
	}


	public Hotel getBookedHotel() {
		return bookedHotel;
	}


	public void setBookedHotel(Hotel bookedHotel) {
		this.bookedHotel = bookedHotel;
	}


	public Flight getBookedFlight() {
		return bookedFlight;
	}


	public void setBookedFlight(Flight bookedFlight) {
		this.bookedFlight = bookedFlight;
	}


	public TourPackage getBookedTourPackage() {
		return bookedTourPackage;
	}


	public void setBookedTourPackage(TourPackage bookedTourPackage) {
		this.bookedTourPackage = bookedTourPackage;
	}


	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", bookingTime=" + bookingTime + ", bookingAmount=" + bookingAmount
				+ ", bookedHotel=" + bookedHotel + ", bookedFlight=" + bookedFlight + ", bookedTourPackage="
				+ bookedTourPackage + "]";
	}
	
	
	
	
	

}
