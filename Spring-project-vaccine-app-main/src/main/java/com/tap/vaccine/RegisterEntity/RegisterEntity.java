package com.tap.vaccine.RegisterEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="REGISTER")

public class RegisterEntity implements java.io.Serializable {


	@Id
	@Column(name="ID")
	private int id;
	@Column(name="USERNAME")
	private String username;
	@Column(name="PASSWORD")
	private String password ;
	@Column(name="EMAIL")
	private String email;
	@Column(name="MOBILENUMBER")
	private String mobilenumber;
	@Column(name="GENDER")
	private String gender;
	@Column(name="DOB")
	private String dob;
	@Column(name="LOGIN_ATTEMPT")
	private int loginAttempt;
	@Column(name="MEMBER_COUNT")
	private int memberCount;
	
	
	
	public RegisterEntity() {
		System.out.println("register entity constructor");
	}


	public RegisterEntity(int id, String username, String password, String email, String mobilenumber, String gender,
			String dob) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.mobilenumber = mobilenumber;
		this.gender = gender;
		this.dob = dob;
	}
	public RegisterEntity(int id, String username, String password, String email, String mobilenumber, String gender,
			String dob, int loginAttempt, int memberCount) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.mobilenumber = mobilenumber;
		this.gender = gender;
		this.dob = dob;
		this.loginAttempt = loginAttempt;
		this.memberCount = memberCount;
	}


	public int getId() {
		return id;
	}
	public int getMemberCount() {
		return memberCount;
	}


	public String getUsername() {
		return username;
	}


	public String getPassword() {
		return password;
	}


	public String getEmail() {
		return email;
	}


	public String getMobileNumber() {
		return mobilenumber;
	}


	public String getGender() {
		return gender;
	}


	public String getDob() {
		return dob;
	}
	
	public int  getLoginAttempt() {
		return loginAttempt;
	}

	public void setUsername(String username) {
		this.username = username;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public void setMobileNumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public void setDob(String dob) {
		this.dob = dob;
	}
	
	public void setLoginAttempt(int loginAttempt)
	{
		this.loginAttempt=loginAttempt;
	}
	public void setMemberCount(int memberCount)
	{
		this.memberCount=memberCount;
	}


	@Override
	public String toString() {
		return "RegisterEntity [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", mobilenumber=" + mobilenumber + ", gender=" + gender + ", dob=" + dob +", loginAttempt=" + loginAttempt +", memberCount=" + memberCount + "]";
	}


	public RegisterEntity(String username, String password, String email, String mobilenumber, String gender,
			String dob) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.mobilenumber = mobilenumber;
		this.gender = gender;
		this.dob = dob;
	}
	
	
	

}
