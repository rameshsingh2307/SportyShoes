package com.ecommerce.Repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import com.ecommerce.entity.User;

public interface PasswordRepository extends CrudRepository<User, Long> {
	
	@Query("SELECT u FROM User u WHERE u.username = :username")
	public User getUserByUsername(String username);
	
	@Modifying
	@Query("UPDATE User c SET c.username = :userName, c.password=:newPassword WHERE c.username = :userName")
	public void update(String userName, String newPassword);
}
