package com.example.stockspring.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.stockspring.model.Login;
import com.example.stockspring.model.UpdateUser;
import com.example.stockspring.model.User;

public interface UserDao extends JpaRepository<User, String> {

	/*
	public User loginUser(Login login);
	public boolean registerUser(User user);
	public boolean updateUser(UpdateUser user);
	*/
	
	User findByUsername(String username);
}
