package com.example.stockspring.controller;

import java.sql.SQLException;

import javax.validation.Valid;

import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;

import com.example.stockspring.model.CompareCompany;

public interface CompareController {
	public String getCompareCompany(ModelMap model) throws SQLException;
	public String getCompare(@Valid CompareCompany compareCompany,Model model) throws SQLException, Exception;
}
