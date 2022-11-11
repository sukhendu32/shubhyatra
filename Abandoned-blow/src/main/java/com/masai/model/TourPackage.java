package com.masai.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class TourPackage {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer tourPackageId;
	
	private String tourPackageName;
	
	private Integer tourPackagePrice;
	
	private Integer numberOfdays;
	
	private Flight flight;
	
	private Hotel hotel;
	
	@OneToMany
	private List<Customer> customer;
	
	
	public TourPackage() {
		// TODO Auto-generated constructor stub
	}


	public TourPackage(Integer tourPackageId, String tourPackageName, Integer tourPackagePrice, Integer numberOfdays,
			Flight flight, Hotel hotel, List<Customer> customer) {
		super();
		this.tourPackageId = tourPackageId;
		this.tourPackageName = tourPackageName;
		this.tourPackagePrice = tourPackagePrice;
		this.numberOfdays = numberOfdays;
		this.flight = flight;
		this.hotel = hotel;
		this.customer = customer;
	}


	public Integer getTourPackageId() {
		return tourPackageId;
	}


	public void setTourPackageId(Integer tourPackageId) {
		this.tourPackageId = tourPackageId;
	}


	public String getTourPackageName() {
		return tourPackageName;
	}


	public void setTourPackageName(String tourPackageName) {
		this.tourPackageName = tourPackageName;
	}


	public Integer getTourPackagePrice() {
		return tourPackagePrice;
	}


	public void setTourPackagePrice(Integer tourPackagePrice) {
		this.tourPackagePrice = tourPackagePrice;
	}


	public Integer getNumberOfdays() {
		return numberOfdays;
	}


	public void setNumberOfdays(Integer numberOfdays) {
		this.numberOfdays = numberOfdays;
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


	public List<Customer> getCustomer() {
		return customer;
	}


	public void setCustomer(List<Customer> customer) {
		this.customer = customer;
	}


	@Override
	public String toString() {
		return "TourPackage [tourPackageId=" + tourPackageId + ", tourPackageName=" + tourPackageName
				+ ", tourPackagePrice=" + tourPackagePrice + ", numberOfdays=" + numberOfdays + ", flight=" + flight
				+ ", hotel=" + hotel + ", customer=" + customer + "]";
	}
	
	
	
	
	

}
