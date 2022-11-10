package com.model;


public class UserDTO {
	
	private String userId;
	
	private String hotelId;
	
	private String flightId;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getHotelId() {
		return hotelId;
	}

	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}

	public String getFlightId() {
		return flightId;
	}

	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}


	public UserDTO(String userId, String hotelId, String flightId) {
		super();
		this.userId = userId;
		this.hotelId = hotelId;
		this.flightId = flightId;
		
	}

	@Override
	public String toString() {
		return "UserDTO [userId=" + userId + ", hotelId=" + hotelId + ", flightId=" + flightId + "]";
	}
	
	
	public UserDTO() {
		// TODO Auto-generated constructor stub
	}
	
	
	

}
