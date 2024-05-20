package com.tap.vaccine.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogoutController {

    @GetMapping("/logout")
    public String setLogout(HttpServletRequest request) {
        
        HttpSession session = request.getSession(false);

       
        if (session != null) {
    		String n =(String)session.getAttribute("Email");
            session.invalidate();
        }


        return "/logout";
    }
    @GetMapping("/login")
    public String Loginpage()
    {
    	return "/login";
    }
}

