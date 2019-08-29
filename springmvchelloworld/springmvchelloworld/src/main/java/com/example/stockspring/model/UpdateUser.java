package com.example.stockspring.model;

public class UpdateUser {

	private String username;
	private String password;
	private String email;
	private long mobilenumber;
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
	public long getMobilenumber() {
		return mobilenumber;
	}
	public void setMobilenumber(long mobilenumber) {
		this.mobilenumber = mobilenumber;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public UpdateUser(String username, String password, String email, long mobilenumber) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.mobilenumber = mobilenumber;
	}
	public UpdateUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
