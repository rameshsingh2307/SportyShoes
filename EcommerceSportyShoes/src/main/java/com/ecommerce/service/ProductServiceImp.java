package com.ecommerce.service;




import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.ecommerce.Repository.ProductRepository;

import com.ecommerce.entity.Product;

@Transactional
@Service
public class ProductServiceImp implements ProductService {
	
	@Autowired
	ProductRepository productRepository;
	
	@Override
	public void save(Product product) {
		productRepository.save(product);
	}

	@Override
	public Iterable<Product> findAll() {		
		return productRepository.findAll();
	}

	@Override
	public void deleteByProductId(Long id) {
		productRepository.deleteById(id);
		
	}

	@Override
	public Product findByProductId(Long id) {
		return productRepository.findById(id).get();
	}

	@Override
	public void update(Long long1, String string, String string2) {
		productRepository.update(long1, string, string2);
	}


}
