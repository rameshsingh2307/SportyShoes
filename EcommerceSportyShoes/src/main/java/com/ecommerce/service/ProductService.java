package com.ecommerce.service;

import java.util.List;
import java.util.Optional;

import com.ecommerce.entity.Product;

public interface ProductService {
	public void save(Product product);
	public Iterable<Product> findAll();
	public void deleteByProductId(Long id);
	//public void updateByProductId(Long id);
	public Product findByProductId(Long id);
	public void update(Long long1, String string, String string2);
	
}
