package com.masai.services;

import java.util.List;

import com.masai.models.Customer;

public interface CustomerService {
	
	public Customer registerCustomer(Customer customer);
	
	public Customer deleteCustomerById(Integer customerId);
	
	public List<Customer> viewAllCustomer();

}
