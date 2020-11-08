package com.iiht.evaluation.eloan.model;

public class User {
	
	private static String username;
	private String password;
	public User()
	{
	
	}
	
	public  String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		User.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public User(String username, String password) {
		super();
		User.username = username;
		this.password = password;
	}
	

}
