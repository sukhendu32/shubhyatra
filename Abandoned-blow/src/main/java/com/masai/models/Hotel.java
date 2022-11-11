package com.masai.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Hotel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer hotelId;
	
	private String hotelName;
	
	private String hotelLocation;
	
	private Integer hotelPrice;
	
	private Integer hotelRating;
	
	private Integer availableRooms;
	
	@OneToMany
	private List<Customer> customer;
	
	
	public Hotel() {
		// TODO Auto-generated constructor stub
	}


	public Hotel(Integer hotelId, String hotelName, String hotelLocation, Integer hotelPrice, Integer hotelRating,
			Integer availableRooms, List<Customer> customer) {
		super();
		this.hotelId = hotelId;
		this.hotelName = hotelName;
		this.hotelLocation = hotelLocation;
		this.hotelPrice = hotelPrice;
		this.hotelRating = hotelRating;
		this.availableRooms = availableRooms;
		this.customer = customer;
	}


	public Integer getHotelId() {
		return hotelId;
	}


	public void setHotelId(Integer hotelId) {
		this.hotelId = hotelId;
	}


	public String getHotelName() {
		return hotelName;
	}


	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}


	public String getHotelLocation() {
		return hotelLocation;
	}


	public void setHotelLocation(String hotelLocation) {
		this.hotelLocation = hotelLocation;
	}


	public Integer getHotelPrice() {
		return hotelPrice;
	}


	public void setHotelPrice(Integer hotelPrice) {
		this.hotelPrice = hotelPrice;
	}


	public Integer getHotelRating() {
		return hotelRating;
	}


	public void setHotelRating(Integer hotelRating) {
		this.hotelRating = hotelRating;
	}


	public Integer getAvailableRooms() {
		return availableRooms;
	}


	public void setAvailableRooms(Integer availableRooms) {
		this.availableRooms = availableRooms;
	}


	public List<Customer> getCustomer() {
		return customer;
	}


	public void setCustomer(List<Customer> customer) {
		this.customer = customer;
	}


	@Override
	public String toString() {
		return "Hotel [hotelId=" + hotelId + ", hotelName=" + hotelName + ", hotelLocation=" + hotelLocation
				+ ", hotelPrice=" + hotelPrice + ", hotelRating=" + hotelRating + ", availableRooms=" + availableRooms
				+ ", customer=" + customer + "]";
	}
	
	
	

}
