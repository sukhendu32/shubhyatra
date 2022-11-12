package com.masai.exceptions;

import java.time.LocalDateTime;

public class MyErrorDetails {
	
	private LocalDateTime time;
	private String description;
	private String message;
	
	
	public MyErrorDetails(LocalDateTime time, String description, String message) {
		super();
		this.time = time;
		this.description = description;
		this.message = message;
	}
	public LocalDateTime getTime() {
		return time;
	}
	public void setTime(LocalDateTime time) {
		this.time = time;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "MyErrorDetails [time=" + time + ", description=" + description + ", message=" + message + "]";
	}
	
	public MyErrorDetails() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
