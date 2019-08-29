package com.example.stockspring.model;

public class Username {

	private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Username(String username) {
		super();
		this.username = username;
	}

	public Username() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Username [username=" + username + "]";
	}
	
}
