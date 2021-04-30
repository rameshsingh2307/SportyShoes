package com.ecommerce.Repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ecommerce.entity.Customer;

public interface CustomerRespository extends CrudRepository<Customer, Long> {
	@Modifying
	@Query("select c from Customer c where lower(c.firstName) like %:searchText% or lower(c.lastName) like %:searchText%")
	public Iterable<Customer> searchByName(String searchText);
	
	@Query("select c from Customer c where lower(c.firstName)= ':name'")
	public Customer getCustomer(String name);
	
	
	
}
