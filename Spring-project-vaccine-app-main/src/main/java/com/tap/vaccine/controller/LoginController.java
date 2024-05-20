package com.tap.vaccine.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpSession;

import com.tap.vaccine.RegisterEntity.RegisterEntity;
import com.tap.vaccine.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	

	@RequestMapping("/getLoginData")
	public String getLoginData() {
		return "/login";
	}

	@RequestMapping("/getLogin")
	public String getLoginData(@RequestParam String email, @RequestParam String password, Model model,HttpServletRequest request) {
		System.out.println("inside the login method");
		

		if (!loginService.validateEmail(email)) {
			model.addAttribute("email", "Enter the valid Email");
			return "/login";
		}

		if (!loginService.validatePassword(password)) {
			model.addAttribute("password", "Enter the valid password");
			return "/login";
		}

		boolean exists = loginService.emailExists(email);

		if (exists) {
			System.out.println("exists is true");
			boolean isPassword;
			try {
				isPassword = loginService.correctPassword(email, password);
				if (isPassword) {

					boolean isValid = loginService.validateLogin(email, password);
					if (isValid) {
						RegisterEntity entity = loginService.FindUsername(email);
						HttpSession session =request.getSession(true);
						session.setAttribute("Email",email);
						System.out.println("isvalid is true");
						model.addAttribute("username",entity.getEmail());
						model.addAttribute("memberCount", entity.getMemberCount());
						return "/home";
					}

				} 
			} catch (Exception e) {
				model.addAttribute("mismatch",e.getMessage());
				return "/login";
			}

			

		} else {
			System.out.println("exists is true");
			model.addAttribute("mismatch", "Enter the Registered Email...");
			return "/login";
		}
		return "/login";

	}

}
