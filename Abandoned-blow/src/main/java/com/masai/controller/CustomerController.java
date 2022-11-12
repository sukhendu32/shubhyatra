package com.masai.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exceptions.CustomerException;
import com.masai.models.Customer;
import com.masai.services.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService cService;
	
	@PostMapping("/customer")
	public ResponseEntity<Customer> registerCustomer(@Valid @RequestBody Customer customer) throws CustomerException
	{
		Customer c = cService.registerCustomer(customer);
		return 	new ResponseEntity<Customer>(c,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/customer/{userId}")
	public ResponseEntity<Customer> deleteCustomer(@PathVariable("userId") Integer Id) throws CustomerException
	{
		Customer c = cService.deleteCustomerById(Id);
		return new ResponseEntity<Customer>(c,HttpStatus.OK);
	}
	
	@GetMapping("/customer")
	public ResponseEntity<List<Customer>> viewAllCustomer() throws CustomerException
	{
		List<Customer> list = cService.viewAllCustomer();
		return new ResponseEntity<List<Customer>>(list,HttpStatus.OK);
	}
	
	@GetMapping("/customer/{userId}")
	public ResponseEntity<Customer> findCustomerById(@PathVariable("userId") Integer Id) throws CustomerException
	{
		Customer c = cService.findCustomerById(Id);
		return new ResponseEntity<Customer>(c,HttpStatus.OK);
	}
	
	@PutMapping("/customer")
	public ResponseEntity<Customer> udateCustomerDetails(@Valid @RequestBody Customer customer) throws CustomerException
	{
		Customer c = cService.updateCustomer(customer);
		
		return new ResponseEntity<Customer>(c,HttpStatus.OK);
	}
	
	

}
