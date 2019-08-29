package com.example.stockspring.controller;

import java.sql.SQLException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.stockspring.BarChart;
import com.example.stockspring.model.Company;
import com.example.stockspring.model.CompareCompany;
import com.example.stockspring.service.CompanyService;

@Controller
public class CompareControllerImpl implements CompareController {

	@Autowired
	CompanyService companyService;
	BarChart barChart=new BarChart();
	
	@RequestMapping(value = "/compareCompany", method = RequestMethod.GET)
	public String getCompareCompany(ModelMap model) throws SQLException {
		System.out.println("add employee");
		CompareCompany compareCompany=new CompareCompany();
		//e.setEmail("sdfsf");
		//	e.setSalary(4564.56f);
		model.addAttribute("e1", compareCompany);
		model.addAttribute("companyList",companyService.getCompanyList());
		return "CompareCompany";

	}
	
	@RequestMapping(value = "/compare", method = RequestMethod.POST)
	public String getCompare(@Valid CompareCompany compareCompany,Model model) throws Exception {
		Company c1=new Company();
		Company c2=new Company();
		c1=companyService.getCompanyDetails(compareCompany.getC1());
		c2=companyService.getCompanyDetails(compareCompany.getC2());
		System.out.println(c1);
		System.out.println(c2);
		barChart.getBar(c1, c2);
		return "redirect:/compareCompanyImage";
	}
	
	@RequestMapping(value = "/compareCompanyImage", method = RequestMethod.GET)
	public String userLanding(ModelMap model) throws SQLException {
		return "CompareCompanyImage";

	}	
	
	@RequestMapping(value = "/graph", method = RequestMethod.GET)
	public String graph(ModelMap model) throws SQLException {
		return "graph";

	}
}
