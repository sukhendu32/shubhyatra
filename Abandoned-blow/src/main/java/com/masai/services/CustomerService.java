package com.masai.services;

import java.util.List;

import com.masai.exceptions.CustomerException;
import com.masai.models.Customer;

public interface CustomerService {
	
	public Customer registerCustomer(Customer customer) throws CustomerException;
	
	public Customer updateCustomer(Customer customer) throws CustomerException;
	
	public Customer deleteCustomerById(Integer customerId) throws CustomerException;
	
	public Customer findCustomerById(Integer customerId) throws CustomerException;
	
	public List<Customer> viewAllCustomer() throws CustomerException;

}
