package com.masai.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.models.Customer;
import com.masai.repository.CustomerRepo;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerRepo cRepo;
	
	
	@Override
	public Customer registerCustomer(Customer customer) {
		
		Customer c = cRepo.save(customer);
		
		if(c!=null)
		{
			return c;
		}
		else
		{
			return null;
		}
	}

	@Override
	public Customer deleteCustomerById(Integer customerId) {
		
		Optional<Customer> opt = cRepo.findById(customerId);
		
		if(opt.isPresent())
		{
			cRepo.delete(opt.get());
			
			return opt.get();
		}
		else
		{
			return null;
		}
	}

	@Override
	public List<Customer> viewAllCustomer() {
		List<Customer> list =  cRepo.findAll();
		
		if(list.size()>0)
		{
			return list;
		}
		else
		{
			return null;
		}
	}

}
