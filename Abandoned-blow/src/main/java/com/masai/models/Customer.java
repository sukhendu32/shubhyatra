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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer customerId;
	
	private String customerName;
	
	private String customerMobile;
	
	private Integer walletBalance;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	private Feedback feedback;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Booking> booking;
	
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}


	public Customer(Integer customerId, String customerName, String customerMobile, Integer walletBalance,
			Feedback feedback, List<Booking> booking) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerMobile = customerMobile;
		this.walletBalance = walletBalance;
		this.feedback = feedback;
		this.booking = booking;
	}


	public Integer getCustomerId() {
		return customerId;
	}


	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}


	public String getCustomerName() {
		return customerName;
	}


	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	public String getCustomerMobile() {
		return customerMobile;
	}


	public void setCustomerMobile(String customerMobile) {
		this.customerMobile = customerMobile;
	}


	public Integer getWalletBalance() {
		return walletBalance;
	}


	public void setWalletBalance(Integer walletBalance) {
		this.walletBalance = walletBalance;
	}


	public Feedback getFeedback() {
		return feedback;
	}


	public void setFeedback(Feedback feedback) {
		this.feedback = feedback;
	}


	public List<Booking> getBooking() {
		return booking;
	}


	public void setBooking(List<Booking> booking) {
		this.booking = booking;
	}


	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", customerMobile="
				+ customerMobile + ", walletBalance=" + walletBalance + ", feedback=" + feedback + ", booking="
				+ booking + "]";
	}
	
	
	

}
