package com.people23.academy.security;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import lombok.extern.log4j.Log4j2;

/**
 * Generator JWT success handler
 * 
 * @author 23 People Company
 *
 */
@Log4j2
public class JwtSuccessHandler implements AuthenticationSuccessHandler {

	/**
    * Method generate a authentication success
    * @param HttpServletRequest request
    * @param HttpServletResponse response
    * @return void not return value
    */
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		log.info("JwtSuccessHandler - Sucess on Authentication");
	}
}
