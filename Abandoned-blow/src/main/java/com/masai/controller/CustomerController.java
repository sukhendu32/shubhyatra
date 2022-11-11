package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.models.Customer;
import com.masai.services.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService cService;
	
	@PostMapping("/customer")
	public Customer registerCustomer(@RequestBody Customer customer)
	{
		return cService.registerCustomer(customer);	
	}
	
	@DeleteMapping("/customer/{Id}")
	public Customer deleteCustomer(@PathVariable("Id") Integer Id)
	{
		return cService.deleteCustomerById(Id);
	}
	
	@GetMapping("/customer")
	public List<Customer> viewAllCustomer()
	{
		return cService.viewAllCustomer();
	}

}
