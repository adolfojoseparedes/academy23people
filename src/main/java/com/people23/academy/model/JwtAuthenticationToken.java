package com.people23.academy.model;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

/**
 * Class model that defines the properties for token-based authentication JWT
 * 
 * @author 23 People Company
 *
 */
public class JwtAuthenticationToken extends UsernamePasswordAuthenticationToken {

	private static final long serialVersionUID = 1L;
	
	private String token;
	
	public JwtAuthenticationToken(String token) {
		super(null, null);
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public Object getCredentials() {
		return null;
	}

	@Override
	public Object getPrincipal() {
		return null;
	}
}
