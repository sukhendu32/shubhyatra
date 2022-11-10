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
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userId;
	
	private String userName;
	
	private String mobile;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Booking> booking;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public List<Booking> getBooking() {
		return booking;
	}

	public void setBooking(List<Booking> booking) {
		this.booking = booking;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", mobile=" + mobile + ", booking=" + booking
				+ "]";
	}

	public User(Integer userId, String userName, String mobile, List<Booking> booking) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.mobile = mobile;
		this.booking = booking;
	}
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	

}
