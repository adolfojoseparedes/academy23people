package com.people23.academy.model;

import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Class model that defines the fields and properties for a token-based authentication JWT
 * at the user detail level
 * 
 * @author 23 People Company
 *
 */
public class JwtUserDetails implements UserDetails {
	
	private static final long serialVersionUID = 1L;
	
	private String userName;
	
	private String token;
	
	private Long id;
	
	private Collection<? extends GrantedAuthority> authorities;
	
	/**
    * Constructor of the JwtUserDetails class 
    * @param String user name for generate token
    * @param String id for generate token
    * @param String token generated
    * @param List<GrantedAuthority> authorities list
    */
	public JwtUserDetails(String userName, Long id, String token, List<GrantedAuthority> authorities) {
		super();
		this.userName = userName;
		this.token = token;
		this.id = id;
		this.authorities = authorities;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return null;
	}

	@Override
	public String getUsername() {
		return userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
