package com.ecommerce.Repository;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ecommerce.entity.OrderDetail;
import com.ecommerce.entity.Product;

public interface PurchaseRespository extends CrudRepository<OrderDetail, Long> {
	@Modifying
	@Query("select p from OrderDetail p where lower(p.category) like %:searchText%")
	public Iterable<OrderDetail> searchByCategory(String searchText);
	
	
	@Modifying
	@Query("select p from OrderDetail p where p.purchaseDate = :searchDate")
	public Iterable<OrderDetail> searchByDate(LocalDate searchDate);
}
