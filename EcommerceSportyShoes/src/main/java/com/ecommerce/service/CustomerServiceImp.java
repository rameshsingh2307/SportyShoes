package com.ecommerce.service;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.Repository.CustomerRespository;
import com.ecommerce.Repository.ProductRepository;
import com.ecommerce.entity.Customer;
import com.ecommerce.entity.Product;

@Transactional
@Service
public class CustomerServiceImp implements CustomerService {
	
	@Autowired
	CustomerRespository customerRespository;
	
	@Override
	public Iterable<Customer> findAll() {		
		return customerRespository.findAll();
	}

	@Override
	public Iterable<Customer> searchByName(String serachText) {
		return customerRespository.searchByName(serachText);	
	}

	@Override
	public void save(Customer customer) {
		customerRespository.save(customer);
		
	}

	@Override
	public Customer getCustomer(String name) {
		customerRespository.getCustomer(name);
		return null;
	}

}
