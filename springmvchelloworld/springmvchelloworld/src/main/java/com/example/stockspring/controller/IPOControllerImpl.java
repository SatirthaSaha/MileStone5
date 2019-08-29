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

import com.example.stockspring.model.Ipo_planned;
import com.example.stockspring.service.CompanyService;
import com.example.stockspring.service.IPOService;
import com.example.stockspring.service.StockService;

@Controller
public class IPOControllerImpl implements IPOController{
	
	@Autowired
	CompanyService companyService;
	@Autowired
	StockService stockService;
	@Autowired
	IPOService ipoService;

	@RequestMapping(value = "/updateIPODetails", method = RequestMethod.GET)
	public String getregisterIPO(ModelMap model) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Inside IPO controller");
		Ipo_planned ipo_planned=new Ipo_planned();
		model.addAttribute("ipo",ipo_planned);
		model.addAttribute("companyList",companyService.getCompanyList());
		System.out.println(stockService.getAllStock());
		model.addAttribute("stockList",stockService.getAllStock());
		return "updateIPODetails";
	}
	
	@RequestMapping(value = "/updateIPODetails", method = RequestMethod.POST) 
	public String registerIPO(@Valid Ipo_planned ipo_planned, BindingResult result, Model model) throws SQLException { 
		System.out.println("inside post method"); 
		Random r = new Random(); 
		int num = r.nextInt(9000) + 1000;
		ipo_planned.setId(num);
		System.out.println(ipo_planned);
		if(result.hasErrors()){ 
			System.out.println("errors");
			System.out.println(result.getAllErrors()); 
			model.addAttribute("e1", ipo_planned);
			return "error"; 
		}
		if(ipoService.registerIPO(ipo_planned))
			//model.addAttribute("name", employee.getName()); 
			return	"redirect:/updateIPODetails"; 
		else 
			return "error"; 
	}
	
	@RequestMapping(value="/getIPODetails")
	public ModelAndView getIPOList() throws Exception {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("IPOlist");
		mv.addObject("IPOList",ipoService.getIPOList());
		return mv;
	}

}
