 package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.demo.entity.Customer;
import com.example.demo.service.CustomerService;


@RestController
@RequestMapping("entity")
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	
	@GetMapping(value="/customer")
	public ResponseEntity<List<Customer>> getAllCustomer(){
		List<Customer> customers = customerService.getAllCustomer();
		return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
	}
	@GetMapping(value="/customer/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable("id") Integer customerId){
		Customer customersGet = customerService.getCustomerById(customerId);
		return new ResponseEntity<Customer>(customersGet, HttpStatus.OK);
	}
	
	@DeleteMapping(value="/customer/{id}")
	public ResponseEntity<Void> deleteCustomerById(@PathVariable("id") Integer customerId){
		customerService.deleteCustomer(customerId);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	@PostMapping(value="/customer")
	public ResponseEntity<Void> createCustomer(Customer customers, UriComponentsBuilder builder){
		boolean flag = customerService.addCustomer(customers);
		if(flag == false) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/entity/customer/{id}").buildAndExpand(customers.getCustomerId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/customer")
	public ResponseEntity<Customer> updateCustomer(Customer customersUpdate) {
		customerService.editCustomer(customersUpdate);
		return new ResponseEntity<Customer>(customersUpdate, HttpStatus.OK);
	}
	
	
}
