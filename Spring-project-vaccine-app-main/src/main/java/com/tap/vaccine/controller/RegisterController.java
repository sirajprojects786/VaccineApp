package com.tap.vaccine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.tap.vaccine.service.RegisterService;
@Controller
public class RegisterController {
	
	public RegisterController() {
		
		System.out.println("inside of register controller");
	}
	@Autowired
	private RegisterService registerService;
	
	@RequestMapping("/getRegisterData")
	public String getRegisterData()
	{
		
		return "/Register";
		
	}
	@RequestMapping("/getData")
	public String getData(@RequestParam String username,@RequestParam String password,@RequestParam String confirmpassword,
			@RequestParam String email,@RequestParam String mobilenumber,
			@RequestParam String gender,@RequestParam String dob,Model model)
	
	{
		System.out.println("inside of controller getdata()");
		
		if(!registerService.validateUsername(username))
		{
			model.addAttribute("username", "Enter the valid username");
			return "/Register";
		}
		
		
		if(!registerService.validatePassword(password))
		{
			model.addAttribute("password", "Enter the valid password");
			return "/Register";
		}
		
		if(!registerService.validateConfirmPassword(confirmpassword))
		{
			model.addAttribute("confirmpassword", "password and confirm should be same");
			return "/Register";
		}
		
		if(!registerService.validateEmail(email))
		{
			model.addAttribute("email", "Enter the valid email");
			return "/Register";
		}
		
		if(!registerService.validateGender(gender))
		{
			model.addAttribute("email", "Enter the valid gender");
			return "/Register";
		}
		
		/*if(registerService.validateGenderOption( gender))
		{
			
			boolean option = registerService.validateGenderOption(gender);
			if(!option)
			{
				model.addAttribute("gender", "Choose the options of the Gender");
				return "/Register";
			}
			else{
			
			return "/Register";
			}
			
		}*/
		
		if(!registerService.validateMobileNumber(mobilenumber))
		{
			model.addAttribute("mobilenumber", "Enter the valid mobilenumber");
			return "/Register";
		}
		
		if(!registerService.validateBob(dob))
		{
			model.addAttribute("dob", "Enter the valid dob");
			return "/Register";
		}
		
		boolean valid = registerService.validateData(username,password,confirmpassword,email,mobilenumber,gender,dob);
		if(valid)
		{
			model.addAttribute("responseMessage", "Data is successfully stored & mail is sent to your gmail");
			return "/Register";
		}
		else {
			model.addAttribute("responseMessage", "Data is invalid & please try again.... ");
			return "/Register";	
		}		
	}

	
	
	
	

}
