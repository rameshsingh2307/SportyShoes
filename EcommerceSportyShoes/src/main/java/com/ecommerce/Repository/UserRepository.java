package com.ecommerce.Repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ecommerce.entity.Customer;
import com.ecommerce.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {

	@Query("SELECT u FROM User u WHERE u.username = :username")
	public User getUserByUsername(@Param(value = "username") String username);
	
	/*
	 * @Query("SELECT u FROM User u WHERE u.id = :id") public User
	 * getUserById(@Param("id") Long id);
	 * 
	 * public User findByResetPasswordToken(String token);
	 * 
	 * @Modifying
	 * 
	 * @Query("UPDATE User c SET c.username = :userName, c.password=:newPassword WHERE c.username = :userName"
	 * ) public void update(String userName, String newPassword);
	 */
}