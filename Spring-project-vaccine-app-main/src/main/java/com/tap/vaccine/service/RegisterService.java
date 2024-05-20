package com.tap.vaccine.service;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

import com.tap.vaccine.Dao.RegisterDAO;
import com.tap.vaccine.RegisterEntity.RegisterEntity;

@Component
public class RegisterService {
	

	public RegisterService() {
		System.out.println("inside of the register service");
	}

	boolean data = false;
	boolean isCorrect =false;

	@Autowired
	private RegisterDAO registerDAO;
	
	@Autowired
	private JavaMailSenderImpl javaMailSender;

	public boolean validateData(String username, String password, String confirmpassword, String email,
			String mobilenumber, String gender, String dob) {
		boolean flag = false;
		if (!username.isEmpty() && username != null && !username.isBlank()) {
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
		if (!confirmpassword.isEmpty() && confirmpassword != null && !confirmpassword.isBlank()) {
			flag = true;
			System.out.println("confirmpassword is valid");
		} else {
			flag = false;
			System.out.println("confirmpassword is invalid");
			return flag;
		}
		if (confirmpassword.equals(password)) {
			System.out.println("passwords is same");
		} else {
			System.out.println("passwords are not correct ");
		}

		if (!email.isEmpty() && email != null && !email.isBlank()) {
			flag = true;
			System.out.println("email is valid");
		} else {
			flag = false;
			System.out.println("email is invalid");
			return flag;
		}
		if (!gender.isEmpty() && gender != " " && !gender.isBlank()) {
			flag = true;
			System.out.println("gender is valid");
		} else {
			flag = false;
			System.out.println("gender is invalid");
			return flag;
		}
		if (!dob.isEmpty() && dob != null && !dob.isBlank()) {
			flag = true;
			System.out.println("dob is valid");
		} else {
			flag = false;
			System.out.println("dob is invalid");
			return flag;
		}

		if (!mobilenumber.isEmpty() && mobilenumber != null && !mobilenumber.isBlank()) {
			flag = true;
			System.out.println("mobilenumber is valid");
		} else {
			flag = false;
			System.out.println("mobilenumber should be in 10 digits");
			return flag;
		}
		if (flag) {
			RegisterEntity entity = new RegisterEntity(username, password, email, mobilenumber, gender, dob);
			data = registerDAO.saveData(entity);
			if(data)
			{	
					System.out.println("mail sent....");

			}
			else {
				System.out.println("something is wrong !!! enter the valid mail ");
				
			}
			return data ;

		}
		
		return flag;

	}

	public boolean validateUsername(String username) {
		boolean flag = false;
		if (!username.isEmpty() && username != null && !username.isBlank()) {
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

	public boolean validateConfirmPassword(String confirmpassword) {
		boolean flag = false;
		if (!confirmpassword.isEmpty() && confirmpassword != null && !confirmpassword.isBlank()
				&& s.equals(confirmpassword)) {
			flag = true;
		} else {
			flag = false;
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

	public boolean validateMobileNumber(String mobilenumber) {
		boolean flag = false;
		if (!mobilenumber.isEmpty() && mobilenumber != null && !mobilenumber.isBlank()) {
			flag = true;
		} else {
			flag = false;
		}

		return flag;
	}

	public boolean validateBob(String dob) {
		boolean flag = false;
		if (!dob.isEmpty() && dob != null && !dob.isBlank()) {
			flag = true;
		} else {
			flag = false;
		}

		return flag;
	}

	public boolean validateGender(String gender) {
		boolean flag = false;
		if (!gender.isEmpty() && gender != " " && !gender.isBlank()) {
			flag = true;
		} else {
			flag = false;
		}

		return flag;
	}

	public boolean validateGenderOption(String gender) {
		boolean flag = false;
		if (gender.equals("male")) {
			flag = true;
			return flag;
		} else if (gender.equals("female")) {
			flag = true;
			return flag;
		} else {
			flag = false;
			return flag;

		}

	}

	

}
