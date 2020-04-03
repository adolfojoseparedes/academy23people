package com.people23.academy.security;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import lombok.extern.log4j.Log4j2;

/**
 * Entry point for JWT authentication generation
 * 
 * @author 23 People Company
 *
 */
@Component
@Log4j2
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

	/**
    * Method that initiates authentication JWT
    * @param request HttpServletRequest request
    * @param response HttpServletResponse response
    * @return void not return value
    */
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		log.info("component JwtAuthenticationEntryPoint - calling commence method");
		response.sendError(HttpServletResponse.SC_UNAUTHORIZED, " Not Authorized ");
	}
}
