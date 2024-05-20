package com.tap.vaccine.Dao;

public interface ForgetPasswordDao {

	boolean resetPasswordByEmail(String email, String password);
	void sendEmail(String email, String password);


}
