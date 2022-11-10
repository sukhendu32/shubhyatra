package com.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Flight {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer flightId;
	
	private String flightName;
	
	private Integer price;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<User> user;

	public Integer getFlightId() {
		return flightId;
	}

	public void setFlightId(Integer flightId) {
		this.flightId = flightId;
	}

	public String getFlightName() {
		return flightName;
	}

	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public List<User> getUser() {
		return user;
	}

	public void setUser(List<User> user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Flight [flightId=" + flightId + ", flightName=" + flightName + ", price=" + price + ", user=" + user
				+ "]";
	}

	public Flight(Integer flightId, String flightName, Integer price, List<User> user) {
		super();
		this.flightId = flightId;
		this.flightName = flightName;
		this.price = price;
		this.user = user;
	}
	
	public Flight() {
		// TODO Auto-generated constructor stub
	}
	
	

}
