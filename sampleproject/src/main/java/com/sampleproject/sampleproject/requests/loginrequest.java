package com.sampleproject.sampleproject.requests;

import jakarta.validation.constraints.NotBlank;

public class loginrequest {
	@NotBlank(message="enter user name")
	private String email;
	
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
	@NotBlank(message="enter password")
	private String password;
}
