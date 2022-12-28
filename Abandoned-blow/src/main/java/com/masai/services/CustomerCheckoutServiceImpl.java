package com.masai.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exceptions.UserException;
import com.masai.exceptions.FlightException;
import com.masai.exceptions.HotelException;
import com.masai.exceptions.PaymentException;
import com.masai.exceptions.TourPackageException;
import com.masai.models.Booking;
import com.masai.models.User;
import com.masai.models.Customer_Checkout;
import com.masai.models.Flight;
import com.masai.models.Hotel;
import com.masai.models.TourPackage;
import com.masai.repository.BookingRepo;
import com.masai.repository.UserRepo;
import com.masai.repository.FlightRepo;
import com.masai.repository.HotelRepo;
import com.masai.repository.TourPackageRepo;

@Service
public class CustomerCheckoutServiceImpl implements CustomerCheckoutService{

	@Autowired
	private BookingRepo bRepo;
	
	@Autowired
	private FlightRepo fRepo;
	
	@Autowired
	private HotelRepo hRepo;
	
	@Autowired
	private TourPackageRepo tRepo;
	
	@Autowired
	private UserRepo cRepo;
	
	@Override
	public List<Booking> bookService(Customer_Checkout cc) throws FlightException, HotelException, TourPackageException, UserException, PaymentException{
		
		Optional<User> opt = cRepo.findById(cc.getCustomerId());
		
		if(opt.isPresent())
		{
			User c = opt.get();
			
			if(cc.getFlightName().length()>0 && !cc.getFlightName().equals("string")) 
			{
								
			 Flight f=	fRepo.findByFlightCompany(cc.getFlightName());
			 
			 if(f!=null)
			 {
				 
				 if(c.getWalletBalance()>=f.getFlightPrice())
				 {
					 
					 
					 Booking b=new Booking();
					 
					 b.setBookedFlight(f);
					 b.setBookingAmount(f.getFlightPrice());
					 b.setBookingTime(LocalDateTime.now());
					 
//					 f.getCustomer().add(c);
					 
					 c.getBooking().add(b);
					 
					 c.setWalletBalance(c.getWalletBalance()-f.getFlightPrice());
					 
					 bRepo.save(b);
				 }
				 else
				 {
					 throw new PaymentException("Insufficient balance to book the flight!");
				 }
				 
			 }
			 else
			 {
				 throw new FlightException("Flight not found By Name "+cc.getFlightName());
			 }
			 
			 
			 
			}
			
			
			if(cc.getHotelName().length()>0 && !cc.getTourPackageName().equals("string")) 
			{
				
				
			Hotel h = hRepo.findByHotelName(cc.getHotelName());
			
			if(h!=null)
			{
				
				if(c.getWalletBalance()>=h.getHotelPrice())
				{
					Booking b = new Booking();
					
					b.setBookedHotel(h);
					b.setBookingAmount(h.getHotelPrice());
					b.setBookingTime(LocalDateTime.now());
					
//					h.getCustomer().add(c);
					
					c.getBooking().add(b);
					
					c.setWalletBalance(c.getWalletBalance()-h.getHotelPrice());
					
					bRepo.save(b);
					
				}
				else
				{
					throw new PaymentException("Insufficient balance to book the hotel!");
				}

			}
			else
			{
				throw new HotelException("Hotel not found by Hotel name "+cc.getHotelName());
			}
			
			}
			
			if(cc.getTourPackageName().length()>0 && !cc.getTourPackageName().equals("string"))
			{
				
				TourPackage t = tRepo.findByTourPackageName(cc.getTourPackageName());
				
				if(t!=null)
				{
					
					if(c.getWalletBalance()>=t.getTourPackagePrice())
					{
						Booking b = new Booking();
						
						b.setBookedTourPackage(t);
						b.setBookingAmount(t.getTourPackagePrice());
						b.setBookingTime(LocalDateTime.now());
						
//						t.getCustomer().add(c);
						
						c.getBooking().add(b);
						
						c.setWalletBalance(c.getWalletBalance()-t.getTourPackagePrice());
						
						bRepo.save(b);				
						
					}
					else
					{
						throw new PaymentException("Insufficient balance to book the tour package!");
					}
					
				}
				else
				{
					throw new TourPackageException("TourPackage not found by given name "+cc.getTourPackageName());
				}
					
					
				
			}
			
			return c.getBooking();
			
		}
		else
		{
			throw new UserException("Customer not found By Id "+cc.getCustomerId());
			
		}
		
		
		
	}

	@Override
	public Booking flightBooking(Integer Id, String flightName) throws FlightException, UserException, PaymentException {
		
		Optional<User> opt = cRepo.findById(Id);
		
		if(opt.isPresent())
		{
			Booking b = new Booking();
			
			Flight f = fRepo.findByFlightCompany(flightName);
			
			if(f!=null)
			{
				User c = opt.get();
				
				if(c.getWalletBalance()>=f.getFlightPrice())
				{
					c.setWalletBalance(c.getWalletBalance()-f.getFlightPrice());
					
					cRepo.save(c);
					
					
//					f.getCustomer().add(opt.get());
					
					b.setBookedFlight(f);
					b.setBookingAmount(f.getFlightPrice());
					b.setBookingTime(LocalDateTime.now());
					
					opt.get().getBooking().add(b);
					
					bRepo.save(b);
					
					return b;
					
				}
				else
				{
					throw new PaymentException("Insufficient balance!");
				}
				
			}
			else
			{
				throw new FlightException("Flight not found By Name "+flightName);
			}
			
			
		}
		else
		{
			throw new UserException("Customer not found By Id "+Id);
			
		}
		
	}

	@Override
	public Booking hotelBooking(Integer Id, String hotelName) throws HotelException, UserException, PaymentException {
		
		Optional<User> opt = cRepo.findById(Id);
		
		if(opt.isPresent())
		{
			Booking b = new Booking();
			
			Hotel h = hRepo.findByHotelName(hotelName);
			
			if(h!=null)
			{
				User c = opt.get();
				
				if(c.getWalletBalance()>=h.getHotelPrice())
				{
					
					c.setWalletBalance(c.getWalletBalance()-h.getHotelPrice());
					
					cRepo.save(c);
					
//					h.getCustomer().add(opt.get());
					
					b.setBookedHotel(h);
					b.setBookingAmount(h.getHotelPrice());
					b.setBookingTime(LocalDateTime.now());
					
					opt.get().getBooking().add(b);
					
					bRepo.save(b);
					
					return b;
					
				}
				else
				{
					throw new PaymentException("Insufficient balance!");
				}
				
				
				
			}
			
			else
			{
				throw new HotelException("Hotel not found by Hotel name "+hotelName);
				
			}
			
			
		}
		
		throw new UserException("Customer not found by Id "+Id);
	}

	@Override
	public Booking tourPackageBooking(Integer Id, String tourPackageName) throws TourPackageException, UserException, PaymentException {
		
		Optional<User> opt = cRepo.findById(Id);
		
		if(opt.isPresent())
		{
			Booking b = new Booking();
			
			TourPackage t = tRepo.findByTourPackageName(tourPackageName);
			
			if(t!=null)
			{
				User c = opt.get();
				
				if(c.getWalletBalance()>=t.getTourPackagePrice())
				{
					
					c.setWalletBalance(c.getWalletBalance()-t.getTourPackagePrice());
					
					cRepo.save(c);
					
//					t.getCustomer().add(opt.get());
					
					b.setBookedTourPackage(t);
					b.setBookingAmount(t.getTourPackagePrice());
					b.setBookingTime(LocalDateTime.now());
					
					opt.get().getBooking().add(b);
					
					bRepo.save(b);
					
					return b;
				}
				else
				{
					throw new PaymentException("Insufficient balance!");
				}
				
			}
			else
			{
				throw new TourPackageException("TourPackage not found by given name "+tourPackageName);
			}
			
		}
		else
		{
			throw new UserException("Customer not found by Id "+Id);
		}
		
	}

}
