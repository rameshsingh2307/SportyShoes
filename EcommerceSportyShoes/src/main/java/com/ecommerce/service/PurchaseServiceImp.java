package com.ecommerce.service;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.Repository.PurchaseRespository;
import com.ecommerce.entity.OrderDetail;

@Service
public class PurchaseServiceImp implements PurchaseService {
	
	
	@Autowired
	private PurchaseRespository purchaseRespository;
	
	@Override
	public Iterable<OrderDetail> findAll() {
		// TODO Auto-generated method stub
		return purchaseRespository.findAll();
	}

	@Override
	public Iterable<OrderDetail> searchByCategory(String categoryName) {
		// TODO Auto-generated method stub
		return purchaseRespository.searchByCategory(categoryName);
	}

	@Override
	public Iterable<OrderDetail> searchByDate(LocalDate searchDate) {
		// TODO Auto-generated method stub

		/*
		 * String searchDatePass =null; searchDatePass = searchDate.toString();
		 */
		return purchaseRespository.searchByDate(searchDate);
	}

	@Override
	public void save(OrderDetail orderDetail) {
		purchaseRespository.save(orderDetail);
		
	}

}
