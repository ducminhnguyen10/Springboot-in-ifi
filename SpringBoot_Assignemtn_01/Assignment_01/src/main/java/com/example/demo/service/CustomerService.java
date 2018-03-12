package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Customer;
import com.example.demo.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	public List<Customer> getAllCustomer(){
		return customerRepository.findAll();
	}
	
	public Customer getCustomerById(int customerId) {
		return customerRepository.findOne(customerId);
	}
	
	public boolean addCustomer(Customer customer) {
		Customer customers=new Customer(customer.getCustomerName(), customer.getCustomerAddress(), customer.getCustomerAge());
		if(customerRepository.save(customers)!=null) {
			return true;
		}
		return false;
	}
	
	public boolean deleteCustomer(int customerId) {
		if(this.getCustomerById(customerId)!=null) {
			customerRepository.delete(customerId);
			return true;
		}
		return false;
	}
	
	public boolean editCustomer(Customer customer) {
		//Customer customerEdit = this.getCustomerById(customer.getCustomerId());
		//customerEdit.setCustomerAddress(customer.getCustomerAddress());;
		Customer customerEdit= new Customer(customer.getCustomerId(),customer.getCustomerName(), customer.getCustomerAddress(), customer.getCustomerAge());
		customerEdit.setCustomerId(customer.getCustomerId());
		if(customerRepository.save(customerEdit)!=null) {
			return true;
		}
		return false;
	}
	
	
}
