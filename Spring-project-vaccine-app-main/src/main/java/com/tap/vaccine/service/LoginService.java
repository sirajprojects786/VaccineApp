package com.tap.vaccine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tap.vaccine.Dao.LoginDaoImpl;
import com.tap.vaccine.RegisterEntity.RegisterEntity;

@Component
public class LoginService {
	@Autowired
	private LoginDaoImpl login;

	private static final int maxAttempt = 2;

	public boolean validateLogin(String email, String password) {
		boolean flag = false;
		System.out.println("inside of validatelogin()");

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
		if (flag) {

			RegisterEntity entity = login.getRegisterEntityByEmail(email);
			if ((entity.getPassword()).equals(password)) {

				return flag;
			} else {
				flag = false;

			}

		}

		return flag;

	}

	public boolean correctPassword(String email, String Password) throws Exception{
		boolean isValid = false;
		RegisterEntity entity = login.getRegisterEntityByEmail(email);
		if (entity != null) {
			if (entity.getLoginAttempt() > maxAttempt) {
				login.sendBlockedEmail(entity.getEmail(), entity.getUsername());
				throw new Exception ("your account is blocked .please reset the password.");
			}

			if ((entity.getPassword()).equals(Password)) {
				entity.setLoginAttempt(0);
				login.updateLoginAttempt(entity);
				isValid = true;
				return isValid;
			} else {
				entity.setLoginAttempt(entity.getLoginAttempt() + 1);
				login.updateLoginAttempt(entity);
				throw new Exception ("password is incorrect :"+(maxAttempt-entity.getLoginAttempt()+1)+"left");

			}
		}else {
			throw new Exception("mail is not present,please register !.....");
			
		}
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

	public boolean validatePassword(String password) {
		boolean flag = false;
		if (!password.isEmpty() && password != null && !password.isBlank()) {
			flag = true;
		} else {
			flag = false;
		}

		return flag;
	}

	public boolean emailExists(String email) {
		System.out.println("inside of emailExists()");
		boolean exist = login.emailExist(email);
		return exist;

	}

	public RegisterEntity FindUsername(String email) {
		return login.getRegisterEntityByEmail(email);
		
	}

}
