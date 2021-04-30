package com.ecommerce.service;




import java.time.LocalDate;
import java.util.Date;

import com.ecommerce.entity.OrderDetail;


public interface PurchaseService {
	public Iterable<OrderDetail> findAll();
	
	public Iterable<OrderDetail> searchByCategory(String categoryName);

	public Iterable<OrderDetail> searchByDate(LocalDate searchDate);
	
	public void save(OrderDetail orderDetails);
}
