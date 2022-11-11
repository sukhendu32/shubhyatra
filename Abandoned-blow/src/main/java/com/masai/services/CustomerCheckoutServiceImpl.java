package com.masai.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.models.Booking;
import com.masai.models.Customer;
import com.masai.models.Customer_Checkout;
import com.masai.models.Flight;
import com.masai.models.Hotel;
import com.masai.models.TourPackage;
import com.masai.repository.BookingRepo;
import com.masai.repository.CustomerRepo;
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
	private CustomerRepo cRepo;
	
	@Override
	public List<Booking> bookService(Customer_Checkout cc){
		
		Optional<Customer> opt = cRepo.findById(cc.getCustomerId());
		
		List<Booking> ans=new ArrayList<>();
		
		if(opt.isPresent())
		{
			Customer c = opt.get();
			
			if(cc.getFlightName().length()>0 && !cc.getFlightName().equals("string")) {
				
				
			 Flight f=	fRepo.findByFlightCompany(cc.getFlightName());
			 
			 Booking b=new Booking();
			 
			 b.setBookedFlight(f);
			 b.setBookingAmount(f.getFlightPrice());
			 b.setBookingTime(LocalDateTime.now());
			 
			 f.getCustomer().add(c);
			 
			 c.getBooking().add(b);
			 
			 bRepo.save(b);
			 
			 
			 
			 ans.add(b);
			 
			 
			}
			
			if(cc.getHotelName().length()>0 && !cc.getTourPackageName().equals("string")) {
				
				
			Hotel h = hRepo.findByHotelName(cc.getHotelName());
			
			Booking b = new Booking();
			
			b.setBookedHotel(h);
			b.setBookingAmount(h.getHotelPrice());
			b.setBookingTime(LocalDateTime.now());
			
			h.getCustomer().add(c);
			
			c.getBooking().add(b);
			
			bRepo.save(b);
			
			ans.add(b);
				
			}
			
			if(cc.getTourPackageName().length()>0 && !cc.getTourPackageName().equals("string"))
			{
				
				TourPackage t = tRepo.findByTourPackageName(cc.getTourPackageName());
				
				Booking b = new Booking();
				
				b.setBookedTourPackage(t);
				b.setBookingAmount(t.getTourPackagePrice());
				b.setBookingTime(LocalDateTime.now());
				
				t.getCustomer().add(c);
				
				c.getBooking().add(b);
				
				bRepo.save(b);
				
				ans.add(b);
				
			}
			
			return ans;
			
		}
		
		return null;
		
		
	}

	@Override
	public Booking flightBooking(Integer Id, String flightName) {
		
		Optional<Customer> opt = cRepo.findById(Id);
		
		if(opt.isPresent())
		{
			Booking b = new Booking();
			
			Flight f = fRepo.findByFlightCompany(flightName);
			
			if(f!=null)
			{
				f.getCustomer().add(opt.get());
				
				b.setBookedFlight(f);
				b.setBookingAmount(f.getFlightPrice());
				b.setBookingTime(LocalDateTime.now());
				
				opt.get().getBooking().add(b);
				
				bRepo.save(b);
				
				return b;
				
				
			}
			else
			{
				return null;
			}
			
			
		}
		else
		{
			return null;
		}
		
	}

	@Override
	public Booking hotelBooking(Integer Id, String hotelName) {
		
		Optional<Customer> opt = cRepo.findById(Id);
		
		if(opt.isPresent())
		{
			Booking b = new Booking();
			
			Hotel h = hRepo.findByHotelName(hotelName);
			
			if(h!=null)
			{
				h.getCustomer().add(opt.get());
				
				b.setBookedHotel(h);
				b.setBookingAmount(h.getHotelPrice());
				b.setBookingTime(LocalDateTime.now());
				
				opt.get().getBooking().add(b);
				
				bRepo.save(b);
				
				return b;
				
				
			}
			
			return null;
			
			
		}
		
		return null;
	}

	@Override
	public Booking tourPackageBooking(Integer Id, String tourPackageName) {
		
		Optional<Customer> opt = cRepo.findById(Id);
		
		if(opt.isPresent())
		{
			Booking b = new Booking();
			
			TourPackage t = tRepo.findByTourPackageName(tourPackageName);
			
			if(t!=null)
			{
				t.getCustomer().add(opt.get());
				
				b.setBookedTourPackage(t);
				b.setBookingAmount(t.getTourPackagePrice());
				b.setBookingTime(LocalDateTime.now());
				
				opt.get().getBooking().add(b);
				
				bRepo.save(b);
				
				return b;
			}
			else
			{
				return null;
			}
			
		}
		else
		{
			return null;
		}
		
	}

}
