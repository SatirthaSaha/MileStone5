package com.example.stockspring.service;

import java.sql.SQLException;

import com.example.stockspring.model.Login;
import com.example.stockspring.model.User;

public interface UserService {

	public boolean registerUser(User user) throws SQLException;
	public User loginUser(Login login)throws SQLException;
	public boolean checkAdminid(String admin);
	public User forgotPassword(String username);
}
