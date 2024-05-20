package com.tap.vaccine.Dao;

import com.tap.vaccine.RegisterEntity.RegisterEntity;

public interface LoginDao {
	
	RegisterEntity getRegisterEntityByEmail(String email);
	boolean emailExist(String email);
	void  updateLoginAttempt(RegisterEntity entity);
	void sendBlockedEmail(String email, String username);

}
