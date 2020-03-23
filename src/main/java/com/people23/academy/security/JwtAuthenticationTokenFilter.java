package com.people23.academy.security;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import com.people23.academy.constants.Constants;
import com.people23.academy.model.JwtAuthenticationToken;

/**
 * JWT authentication token filter class
 * 
 * @author 23 People Company
 *
 */
public class JwtAuthenticationTokenFilter extends AbstractAuthenticationProcessingFilter {

	/**
	 * Constructor
	 */
	public JwtAuthenticationTokenFilter() {
		super("/api/**");
	}

	/**
    * Method that initiates authentication JWT
    * @param HttpServletRequest request
    * @param HttpServletResponse response
    * @return Authentication object authentication
    */
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException, IOException, ServletException {
		
		String header = request.getHeader(Constants.AUTHORIZATION_HEADER);
		
		if(header == null || !header.startsWith(Constants.BEARER_TOKEN)) {
			throw new RuntimeException("Jwt is incorrect or nothing has come");
		}
		String authenticationToken = header.substring(7);
		JwtAuthenticationToken token = new JwtAuthenticationToken(authenticationToken);
		return getAuthenticationManager().authenticate(token);
	}

	/**
    * Method for successful authentication
    * @param HttpServletRequest request
    * @param HttpServletResponse response
    * @param FilterChain chain
    * @return void not return value
    */
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		super.successfulAuthentication(request, response, chain, authResult);
		chain.doFilter(request, response);
	}
}
