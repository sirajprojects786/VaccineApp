package com.tap.vaccine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tap.vaccine.service.ForgetPasswordService;

@Controller
public class ForgetPasswordController {
	
	@Autowired
	private ForgetPasswordService service;
	
	
	@RequestMapping("/getForgetPassword")
	public String getForgetPassword()
	{
		return "/forgetpassword";
	}
	@RequestMapping("/getNewPassword")
	public String getNewPassword(@RequestParam String email,@RequestParam String password ,
			@RequestParam String confirmPassword,Model model)
	{
		System.out.println("inside of getNewPassword()");
		if(!service.validateEmail(email))
		{
			model.addAttribute("email", "Enter the valid username");
			return "/forgetpassword";
		}
		
		
		if(!service.validatePassword(password))
		{
			model.addAttribute("password", "Enter the valid password");
			return "/forgetpassword";
		}
		
		if(!service.validateConfirmPassword(confirmPassword))
		{
			model.addAttribute("confirmpassword", "password and confirm should be same");
			return "/forgetpassword";
		}
		boolean data = service.validateData(email,password,confirmPassword);
		if(data)
		{
			model.addAttribute("data","password is successfully changed");
			return "/forgetpassword";
		}
		else {
			model.addAttribute("data","enter the valid email.please tryAgain!.......");
			return "/forgetpassword";
			
		}
		
	}

}
