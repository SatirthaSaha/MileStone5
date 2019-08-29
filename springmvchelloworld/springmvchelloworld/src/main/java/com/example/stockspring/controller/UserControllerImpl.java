package com.example.stockspring.controller;

import java.math.BigInteger;
import java.sql.SQLException;
import java.util.Random;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.stockspring.SendMail;
import com.example.stockspring.model.Login;
import com.example.stockspring.model.Otp;
import com.example.stockspring.model.User;
import com.example.stockspring.model.Username;
import com.example.stockspring.service.UserService;
import com.example.stockspring.service.UserServiceImpl;

@Controller
public class UserControllerImpl implements UserController {


	@Autowired 
	private UserService userService=new UserServiceImpl();
	SendMail sendMail=new SendMail();
	int otp;
	User u=new User();

	

	@RequestMapping(value = "/registerUser", method = RequestMethod.POST) 
	public String registerUser(@Valid User user, BindingResult result, Model model) throws SQLException { 
		System.out.println("inside post method"); 
		Random r = new Random(); 
		int num = (r.nextInt(90000) + 10000);
		user.setId(BigInteger.valueOf(num));
		user.setUsertype("user");
		System.out.println(user);
		otp=sendMail.sendMail(user.getEmail());
		u.setId(user.getId());
		u.setConfirmed(user.getConfirmed());
		u.setEmail(user.getEmail());
		u.setMobilenumber(user.getMobilenumber());
		u.setUsername(user.getUsername());
		u.setUsertype(user.getUsertype());
		u.setPassword(user.getPassword());
		/*if(userService.registerUser(user)) {
			System.out.println("if true");
			return	"redirect:/Home"; 
		}
		else {
			System.out.println("if false");
			return "error";
		} */
		 return "redirect:/otp";

	}

	@RequestMapping(value = "/registerAdmin", method = RequestMethod.POST) 
	public String registerAdmin(@Valid User user, BindingResult result, Model model) throws SQLException { 
		System.out.println("inside post method"); 
		Random r = new Random(); 
		int num = r.nextInt(90000) + 10000;
		user.setId(BigInteger.valueOf(num));
		user.setUsertype("admin");
		System.out.println(user);
		otp=sendMail.sendMail(user.getEmail());
		u.setId(user.getId());
		u.setConfirmed(user.getConfirmed());
		u.setEmail(user.getEmail());
		u.setMobilenumber(user.getMobilenumber());
		u.setUsername(user.getUsername());
		u.setUsertype(user.getUsertype());
		u.setPassword(user.getPassword());
		/*if(userService.registerUser(user)) {
			System.out.println("if true");
			return	"redirect:/Home"; 
		}
		else {
			System.out.println("if false");
			return "error";
		} */
		 return "redirect:/otp";

	}

	
	@RequestMapping(value = "/otp", method = RequestMethod.GET)
	public String otpPage(ModelMap model) throws SQLException {
		System.out.println("add employee");
		Otp otp1=new Otp();
		//e.setEmail("sdfsf");
		//	e.setSalary(4564.56f);
		model.addAttribute("o", otp1);
		return "OTP";

	}
	
	@RequestMapping(value = "/verifyOtp", method = RequestMethod.POST) 
	public String registerStock(@Valid Otp otp1, BindingResult result, Model model) throws SQLException { 
		System.out.println("inside post method");
		System.out.println("Otp1 otp is:"+otp1.getOtp());
		System.out.println("Otp sent: " + otp );
		if(otp==otp1.getOtp())
		{
			u.setConfirmed(1);
			if(userService.registerUser(u)) {
				System.out.println("if true");
				return	"redirect:/Home"; 
			}
			else {
				System.out.println("if false");
				return "error";
			}
		}
			
		else 
			return "error"; 
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST) 
	public String loginUser(@Valid Login login, BindingResult result, Model model, HttpSession session) throws SQLException { 
		System.out.println("inside post method"); 
		User user=userService.loginUser(login);
		
		System.out.println("++++++++++++++++++++"+user);
		if(user!=null) {

			session.setAttribute("user", user);
			if((user.getUsertype()).equals("user"))
				return	"redirect:/userLandingPage";
			else
				return "redirect:/adminLandingPage";
		}
		else 
			return "redirect:/Home"; 

	}

	//-------------------Opens Admin Landing Page-------------------------

	@RequestMapping(value = "/adminLandingPage", method = RequestMethod.GET)
	public String adminLanding(ModelMap model) throws SQLException {
		return "adminLandingPage";

	}	

	@RequestMapping(value = "/userLandingPage", method = RequestMethod.GET)
	public String userLanding(ModelMap model) throws SQLException {
		return "userLandingPage";

	}	

	//--------------------logout-----------------------------------------
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String login(HttpSession session) throws SQLException {
		session.invalidate();
		return "redirect:/Home";

	}	

	@RequestMapping(value = "/AccessDenied", method = RequestMethod.GET)
	public String AccessDenied(ModelMap model) throws SQLException {
		return "AccessDenied";

	}	
	
	@RequestMapping(value = "/checkAdminid")
	@ResponseBody
	public String checkAdminid(@RequestParam String admin) {
		System.out.println("=========================check email controller=====================");

		if (userService.checkAdminid(admin)) {
			return "Username is Available";
		} else
			return "Username is taken";
	}
	
	@RequestMapping(value = "/checkValidation")
	@ResponseBody
	public String checkValidation(@RequestParam String uname, String pass) throws SQLException {
		System.out.println("=========================check email controller=====================");
		Login login=new Login();
		login.setUsername(uname);
		login.setPassword(pass);
		if (userService.loginUser(login)==null) {
			return "Wrong credentials";
		} else
			return "Right";
	}
	
	@RequestMapping(value = "/forgotpassword", method = RequestMethod.GET)
	public String forgotpassword(ModelMap model) throws SQLException {
		Username u=new Username();
		model.addAttribute("o", u);
		return "ForgotPassword";

	}
	
	@RequestMapping(value = "/forgot", method = RequestMethod.POST)
	public String forgot(@Valid Username username,ModelMap model) throws SQLException {
		User u1=userService.forgotPassword(username.getUsername());
		sendMail.sendMail(u1.getEmail(), u1.getPassword());
		return "redirect:/Home";

	}
}



