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
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userId;
	
	@NotNull @NotBlank @NotEmpty(message = "Name is mandatory") 
	private String userName;
	
	@NotNull @Pattern(regexp = "[0-9]{10}",message = "Mobile number should be of 10 digits")
	private String userMobile;
	
	@NotNull(message = "wallet balance is mandatory") 
	@Min(value = 1000, message = "Minimum wallet balance is 1000")
	private Integer walletBalance;
	
	@OneToOne
	@JsonIgnore
	private Feedback feedback;
	
	@ManyToMany(cascade = CascadeType.ALL )
	@JsonIgnore
	private List<Booking> booking;
	
	
	private String password;
	
	private String role;
	
	
	public User() {
		// TODO Auto-generated constructor stub
	}


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


	public String getUserMobile() {
		return userMobile;
	}


	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
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


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public User(Integer userId, @NotNull @NotBlank @NotEmpty(message = "Name is mandatory") String userName,
			@NotNull @Pattern(regexp = "[0-9]{10}", message = "Mobile number should be of 10 digits") String userMobile,
			@NotNull(message = "wallet balance is mandatory") @Min(value = 1000, message = "Minimum wallet balance is 1000") Integer walletBalance,
			Feedback feedback, List<Booking> booking, String password, String role) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userMobile = userMobile;
		this.walletBalance = walletBalance;
		this.feedback = feedback;
		this.booking = booking;
		this.password = password;
		this.role = role;
	}


	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userMobile=" + userMobile + ", walletBalance="
				+ walletBalance + ", feedback=" + feedback + ", booking=" + booking + ", password=" + password
				+ ", role=" + role + "]";
	}
	

}
