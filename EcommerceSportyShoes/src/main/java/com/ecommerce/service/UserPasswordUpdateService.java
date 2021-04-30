package com.ecommerce.service;

import com.ecommerce.entity.Customer;
import com.ecommerce.entity.User;

public interface UserPasswordUpdateService {
	
	public User getUserByUsername(String username) throws CustomerNotFoundException;
	public void updatePassword(String userName, String newPassword);	
}
