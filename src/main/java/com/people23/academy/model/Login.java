package com.people23.academy.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Class model that defines the fields to login in the application
 * 
 * @author 23 People Company
 *
 */
@Component
public class Login {
	
	@Value("${token.user}")
	private String user;
	
	@Value("${token.password}")
	private String password;
	
	public String getUser() {
		return user;
	}
	
	public void setUser(String user) {
		this.user = user;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
}
