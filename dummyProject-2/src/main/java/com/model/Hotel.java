package com.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Hotel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer hotelId;
	
	private String hotelName;
	
	private Integer price;
	
	private String hotelDestination;
	
	
	@OneToMany
	@JsonIgnore
	private List<User> user;

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

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getHotelDestination() {
		return hotelDestination;
	}

	public void setHotelDestination(String hotelDestination) {
		this.hotelDestination = hotelDestination;
	}

	public List<User> getUser() {
		return user;
	}

	public void setUser(List<User> user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Hotel [hotelId=" + hotelId + ", hotelName=" + hotelName + ", price=" + price + ", hotelDestination="
				+ hotelDestination + ", user=" + user + "]";
	}

	public Hotel(Integer hotelId, String hotelName, Integer price, String hotelDestination, List<User> user) {
		super();
		this.hotelId = hotelId;
		this.hotelName = hotelName;
		this.price = price;
		this.hotelDestination = hotelDestination;
		this.user = user;
	}
	
	public Hotel() {
		// TODO Auto-generated constructor stub
	}
	

}
