package com.ecommerce.Repository;




import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ecommerce.entity.Customer;
import com.ecommerce.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
	@Modifying
	@Query("UPDATE Product c SET c.productName = :productName, c.productCategory=:productCategory WHERE c.productId = :productId")
	void update(Long productId, String productName, String productCategory);
	
	

}
