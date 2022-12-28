package com.masai.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class TourPackage {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer tourPackageId;
	
	@NotNull @NotEmpty @NotBlank(message = "TourPackage name is mandatory")
	private String tourPackageName;
	
	@NotNull(message = "TourPackage price is mandatory") 
	@Min(value = 1500, message = "Minimum tourPackage price is 1500")
	private Integer tourPackagePrice;
	
	@Min(value = 1, message = "Number of days must be greater than 0")
	private Integer numberOfdays;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	private Flight flight;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	private Hotel hotel;
	
	
	public TourPackage() {
		// TODO Auto-generated constructor stub
	}


	public TourPackage(Integer tourPackageId, String tourPackageName, Integer tourPackagePrice, Integer numberOfdays,
			Flight flight, Hotel hotel, List<User> customer) {
		super();
		this.tourPackageId = tourPackageId;
		this.tourPackageName = tourPackageName;
		this.tourPackagePrice = tourPackagePrice;
		this.numberOfdays = numberOfdays;
		this.flight = flight;
		this.hotel = hotel;
		
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


	


	@Override
	public String toString() {
		return "TourPackage [tourPackageId=" + tourPackageId + ", tourPackageName=" + tourPackageName
				+ ", tourPackagePrice=" + tourPackagePrice + ", numberOfdays=" + numberOfdays + ", flight=" + flight
				+ ", hotel=" + hotel +  "]";
	}
	
	
	
	
	

}
