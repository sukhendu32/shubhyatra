package com.service;

import com.model.Flight;
import com.model.Hotel;
import com.model.User;
import com.model.UserDTO;

public interface AllService {
	
	public String flightRegister(Flight flight);
	
	public String hotelRegister(Hotel hotel);
	
	public String userRegister(User user);
	
	public String bookingRegister(UserDTO userDTO);

}
