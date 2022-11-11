package com.masai.models;

import java.util.List;

import javax.persistence.Embedded;
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
	
	private String flightCompany;
	
	private Integer availableSeats;
	
	private Integer flightPrice;
	
	@Embedded
	private Route route;
	
	@OneToMany
	private List<Customer> customer;
	
	
	public Flight() {
		// TODO Auto-generated constructor stub
	}


	public Flight(Integer flightId, String flightCompany, Integer availableSeats, Integer flightPrice, Route route,
			List<Customer> customer) {
		super();
		this.flightId = flightId;
		this.flightCompany = flightCompany;
		this.availableSeats = availableSeats;
		this.flightPrice = flightPrice;
		this.route = route;
		this.customer = customer;
	}


	public Integer getFlightId() {
		return flightId;
	}


	public void setFlightId(Integer flightId) {
		this.flightId = flightId;
	}


	public String getFlightCompany() {
		return flightCompany;
	}


	public void setFlightCompany(String flightCompany) {
		this.flightCompany = flightCompany;
	}


	public Integer getAvailableSeats() {
		return availableSeats;
	}


	public void setAvailableSeats(Integer availableSeats) {
		this.availableSeats = availableSeats;
	}


	public Integer getFlightPrice() {
		return flightPrice;
	}


	public void setFlightPrice(Integer flightPrice) {
		this.flightPrice = flightPrice;
	}


	public Route getRoute() {
		return route;
	}


	public void setRoute(Route route) {
		this.route = route;
	}


	public List<Customer> getCustomer() {
		return customer;
	}


	public void setCustomer(List<Customer> customer) {
		this.customer = customer;
	}


	@Override
	public String toString() {
		return "Flight [flightId=" + flightId + ", flightCompany=" + flightCompany + ", availableSeats="
				+ availableSeats + ", flightPrice=" + flightPrice + ", route=" + route + ", customer=" + customer + "]";
	}
	
	
	

}
