package com.ecommerce.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.Repository.PasswordRepository;
import com.ecommerce.Repository.UserRepository;
import com.ecommerce.entity.User;

@Transactional
@Service
public class UserPasswordUpdateServiceImp implements UserPasswordUpdateService {
	
	
	@Autowired
	private PasswordRepository passwordRepository;
	
	@Override
	public void updatePassword(String userName, String newPassword) {
		passwordRepository.update(userName,newPassword);
		
	}
	
	@Override
	public User getUserByUsername(String username) throws CustomerNotFoundException
	{
		User user = passwordRepository.getUserByUsername(username);
		if (user!=null)
		{
			return user;
		}
		else
		{
			throw new CustomerNotFoundException("Could not find any customer!");
		}
	}
}
