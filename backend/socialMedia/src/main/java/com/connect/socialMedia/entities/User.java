package com.connect.socialMedia.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "users", uniqueConstraints = {@UniqueConstraint(name = "email", columnNames = { "email" }),
		@UniqueConstraint(name = "mobileNo", columnNames = { "mobileNo" })} )
public class User {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	int id;
	String userName;
	String password;
	String email;
	long mobileNo;
	
	
	public User() {}


	public User(int id, String userName, String password, String email, long mobileNo) {
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.mobileNo = mobileNo;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public long getMobileNo() {
		return mobileNo;
	}


	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}


	@Override
	public String toString() {
		return String.format("User [id=%s, userName=%s, password=%s, email=%s, mobileNo=%s]", id, userName, password,
				email, mobileNo);
	}
	

}
