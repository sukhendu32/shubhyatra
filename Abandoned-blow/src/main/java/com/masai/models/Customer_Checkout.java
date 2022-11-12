package com.masai.models;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Customer_Checkout {
	
	@Min(value = 1, message ="Invalid Customer Id!")
	private Integer customerId;
	
	@NotNull @NotEmpty @NotBlank(message = "TourPackage name is mandatory")
	private String tourPackageName;
	
	@NotNull @NotEmpty @NotBlank(message = "Hotel name is mandatory")
	private String hotelName;
	
	@NotNull @NotEmpty @NotBlank(message = "Flight name is mandatory")
	private String flightName;
	
	
	public Customer_Checkout() {
		// TODO Auto-generated constructor stub
	}


	public Customer_Checkout(Integer customerId, String tourPackageName, String hotelName, String flightName) {
		super();
		this.customerId = customerId;
		this.tourPackageName = tourPackageName;
		this.hotelName = hotelName;
		this.flightName = flightName;
	}


	public Integer getCustomerId() {
		return customerId;
	}


	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}


	public String getTourPackageName() {
		return tourPackageName;
	}


	public void setTourPackageName(String tourPackageName) {
		this.tourPackageName = tourPackageName;
	}


	public String getHotelName() {
		return hotelName;
	}


	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}


	public String getFlightName() {
		return flightName;
	}


	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}


	@Override
	public String toString() {
		return "Customer_Checkout [customerId=" + customerId + ", tourPackageName=" + tourPackageName + ", hotelName="
				+ hotelName + ", flightName=" + flightName + "]";
	}
	
	
	
	
	
	

}
