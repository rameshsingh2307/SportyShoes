package com.ecommerce.service;


import com.ecommerce.entity.Customer;

public interface CustomerService {	
	public Iterable<Customer> findAll();
	public Iterable<Customer> searchByName(String serachText);
	public void save(Customer customer);
	public Customer getCustomer(String name);
}
