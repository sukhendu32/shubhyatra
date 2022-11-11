package com.masai.model;

public class Customer_Checkout {
	
	private Integer customerId;
	
	private String tourPackageName;
	
	private String hotelName;
	
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
