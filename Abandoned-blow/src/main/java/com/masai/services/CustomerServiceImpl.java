package com.masai.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exceptions.CustomerException;
import com.masai.models.Customer;
import com.masai.repository.CustomerRepo;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerRepo cRepo;
	
	
	@Override
	public Customer registerCustomer(Customer customer) throws CustomerException {
		
		Customer c = cRepo.save(customer);
		
		if(c!=null)
		{
			return c;
		}
		else
		{
			throw new CustomerException("Customer not registered!");
		}
	}

	@Override
	public Customer deleteCustomerById(Integer customerId) throws CustomerException {
		
		Optional<Customer> opt = cRepo.findById(customerId);
		
		if(opt.isPresent())
		{
			cRepo.delete(opt.get());
			
			return opt.get();
		}
		else
		{
			throw new CustomerException("Customer does not exist with Id "+customerId);
		}
	}

	@Override
	public List<Customer> viewAllCustomer() throws CustomerException {
		List<Customer> list =  cRepo.findAll();
		
		if(list.size()>0)
		{
			return list;
		}
		else
		{
			throw new CustomerException("No customer available!");
		}
	}

	@Override
	public Customer updateCustomer(Customer customer) throws CustomerException {
		
		Optional<Customer> opt = cRepo.findById(customer.getCustomerId());
		
		if(opt.isPresent())
		{
			cRepo.save(customer);
			
			return customer;
		}
		else
		{
			throw new CustomerException("Customer not found by given details");
		}
	}
	
	@Override
	public Customer findCustomerById(Integer customerId) throws CustomerException {
		
		Optional<Customer> opt = cRepo.findById(customerId);
		
		if(opt.isPresent())
		{
			return opt.get();
		}
		else
		{
			throw new CustomerException("Customer does not exist with Id "+customerId);
		}
	}
	

}
