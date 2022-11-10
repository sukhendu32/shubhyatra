package com.masai.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "Flight")
@Data
@ToString
public class Flight {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer flightId;
	
	private String flightType; // first class/ business class/ economy class
	
	private String flightNumber;
	
	private Integer capacity;
	
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Travels tDetails;
	
	

}
