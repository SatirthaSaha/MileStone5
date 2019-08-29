package com.example.stockspring.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

import com.example.stockspring.model.Login;
import com.example.stockspring.model.User;

public interface UserController {
	
	//public String Home(ModelMap model) throws SQLException;
	public String registerUser(@Valid User user, BindingResult result, Model model) throws SQLException;
	public String loginUser(@Valid Login login, BindingResult result, Model model, HttpSession session) throws SQLException;
	public String userLanding(ModelMap model) throws SQLException;
	public String AccessDenied(ModelMap model) throws SQLException;
}
