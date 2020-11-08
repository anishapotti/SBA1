package com.iiht.evaluation.eloan.dto;



public class UserDetailsDto {
	
	
	private String Firstname;
	private String Lastname;
	private String birthday;
	
	private String username;
	private Long MobileNumber;
	private String password;
	private String Email ;
	public String getFirstname() {
		return Firstname;
	}
	public void setFirstname(String firstname) {
		Firstname = firstname;
	}
	public String getLastname() {
		return Lastname;
	}
	public void setLastname(String lastname) {
		Lastname = lastname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Long getMobileNumber() {
		return MobileNumber;
	}
	public void setMobileNumber(Long mobileNumber) {
		MobileNumber = mobileNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public UserDetailsDto(String firstname, String lastname, String username, String birthday, Long mobileNumber, String password,
			String email) {
		super();
		Firstname = firstname;
		Lastname = lastname;
		this.username = username;
		this.birthday= birthday;
		MobileNumber = mobileNumber;
		this.password = password;
		Email = email;
	}
	
	
}