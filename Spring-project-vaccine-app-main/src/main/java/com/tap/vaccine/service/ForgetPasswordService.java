package com.tap.vaccine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tap.vaccine.Dao.ForgetPasswordDao;


@Component
public class ForgetPasswordService {
	
	@Autowired
	private ForgetPasswordDao forget;

	public boolean validateData(String email, String password, String confirmPassword) {
		boolean flag=false;
		if (!email.isEmpty() && email != null && !email.isBlank()) {
			flag = true;
			System.out.println("username is valid");
		} else {
			flag = false;
			System.out.println("username is invalid");
			return flag;
		}
		if (!password.isEmpty() && password != null && !password.isBlank()) {
			flag = true;
			System.out.println("password is valid");
		} else {
			flag = false;
			System.out.println("password is invalid");
			return flag;
		}
		if (!confirmPassword.isEmpty() && confirmPassword != null && !confirmPassword.isBlank()) {
			flag = true;
			System.out.println("confirmPassword is valid");
		} else {
			flag = false;
			System.out.println("confirmPassword is invalid");
			return flag;
		}
		if (confirmPassword.equals(password)) {
			System.out.println("passwords is same");
		} else {
			System.out.println("passwords are not correct ");
		}
		
		if(flag) {
			boolean isForget = forget.resetPasswordByEmail(email,password);
			if(isForget)
			{
				forget.sendEmail(email, password);
			}
			return isForget;
			
		}
		

		return flag;
		
		
	}
	public boolean validateEmail(String email) {
		boolean flag = false;
		if (!email.isEmpty() && email != null && !email.isBlank()) {
			flag = true;
		} else {
			flag = false;
		}

		return flag;
	}

	String s = "";

	public boolean validatePassword(String password) {
		boolean flag = false;
		if (!password.isEmpty() && password != null && !password.isBlank()) {
			flag = true;
			s = password;
		} else {
			flag = false;
		}

		return flag;
	}

	public boolean validateConfirmPassword(String confirmPassword) {
		boolean flag = false;
		if (!confirmPassword.isEmpty() && confirmPassword != null && !confirmPassword.isBlank()
				&& s.equals(confirmPassword)) {
			flag = true;
		} else {
			flag = false;
		}

		return flag;
	}


}
