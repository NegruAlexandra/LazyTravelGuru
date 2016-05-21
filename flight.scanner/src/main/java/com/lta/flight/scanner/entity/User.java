package com.lta.flight.scanner.entity;

public class User {
	private String username;
	private String email;
	private String password;
	
	
	
	public User(String username, String email, String password) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	private boolean isValidUser(){
		boolean isValid = false;
		if("dragos".equals(username) && "1234".equals(password) || "dragos@yahoo.com".equals(email) && "1234".equals(password)){
			isValid=true;
		}
		return isValid;
	}


}
