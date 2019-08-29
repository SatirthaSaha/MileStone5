package com.example.stockspring.controller;

import java.sql.SQLException;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

public interface StockController {

	public String registerStock(ModelMap model) throws SQLException;
	public ModelAndView listStock(ModelMap model) throws Exception;
}
