package com.example.stockspring.controller;

import java.sql.SQLException;

import javax.validation.Valid;

import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

import com.example.stockspring.model.Ipo_planned;

public interface IPOController {
	
	public String getregisterIPO(ModelMap model) throws Exception;
	public String registerIPO(@Valid Ipo_planned ipo_planned, BindingResult result, Model model) throws SQLException;
	public ModelAndView getIPOList() throws Exception;
}
