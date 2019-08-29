package com.example.stockspring.controller;

import java.sql.SQLException;
import java.util.Random;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.stockspring.model.Company;
import com.example.stockspring.model.Stock;
import com.example.stockspring.service.StockService;
import com.example.stockspring.service.StockServiceImpl;

@Controller
public class StockControllerImpl implements StockController{

	@Autowired
	private StockService stockService=new StockServiceImpl();


	//-----------------Opens Register stock Page--------------------------

	@RequestMapping(value = "/registerStock", method = RequestMethod.GET)
	public String registerStock(ModelMap model) throws SQLException {
		System.out.println("add employee");
		Stock stock=new Stock();
		//e.setEmail("sdfsf");
		//	e.setSalary(4564.56f);
		model.addAttribute("e1", stock);
		return "importStock";

	}
	
	@RequestMapping(value = "/registerStock", method = RequestMethod.POST) 
	public String registerStock(@Valid Stock stock, BindingResult result, Model model) throws SQLException { 
		System.out.println("inside post method"); 
		Random r = new Random(); 
		int num = r.nextInt(9000) + 1000;
		stock.setStockexchange_id(num);
		System.out.println(stock);
		if(result.hasErrors()){ 
			System.out.println("errors");
			System.out.println(result.getAllErrors()); 
			model.addAttribute("e1", stock);
			return "error"; 
		}
		if(stockService.insertStock(stock))
			//model.addAttribute("name", employee.getName()); 
			return	"redirect:/listStock"; 
		else 
			return "error"; 
	}

	//-------------------Opens Stock Details Page-------------------------

	@RequestMapping(path = "/listStock")
	public ModelAndView listStock(ModelMap model) throws Exception {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("stockDetails");
		System.out.println("Inside stock controller get all");
		mv.addObject("stockList",stockService.getAllStock());
		return mv;

	}


}