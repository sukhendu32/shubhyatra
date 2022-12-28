package com.masai.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Hotel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer hotelId;
	
	@NotNull @NotEmpty @NotBlank(message = "Hotel name is mandatory")
	private String hotelName;
	
	@NotNull @NotEmpty @NotBlank(message = "Hotel location is mandatory")
	private String hotelLocation;
	
	@NotNull(message = "Hotel price is mandatory") 
	@Min(value = 300, message = "Minimum hotel price is 300")
	private Integer hotelPrice;
	
	@Min(value = 1, message = "Rating should not be less than 1") @Max(value = 5 , message = "Rating should not be greater 5")
	private Integer hotelRating;
	
	@Min(value = 1, message = "Minimum availabe rooms is 1")
	private Integer availableRooms;
	
	
	
	public Hotel() {
		// TODO Auto-generated constructor stub
	}


	public Hotel(Integer hotelId, String hotelName, String hotelLocation, Integer hotelPrice, Integer hotelRating,
			Integer availableRooms, List<User> customer) {
		super();
		this.hotelId = hotelId;
		this.hotelName = hotelName;
		this.hotelLocation = hotelLocation;
		this.hotelPrice = hotelPrice;
		this.hotelRating = hotelRating;
		this.availableRooms = availableRooms;
		
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


	


	@Override
	public String toString() {
		return "Hotel [hotelId=" + hotelId + ", hotelName=" + hotelName + ", hotelLocation=" + hotelLocation
				+ ", hotelPrice=" + hotelPrice + ", hotelRating=" + hotelRating + ", availableRooms=" + availableRooms
				+ ", customer=]";
	}
	
	
	

}
