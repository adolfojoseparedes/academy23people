package com.people23.academy.security;

import org.springframework.stereotype.Component;
import com.people23.academy.constants.Constants;
import com.people23.academy.model.JwtUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.log4j.Log4j2;

/**
 * Generator JWT token
 * 
 * @author 23 People Company
 *
 */
@Component
@Log4j2
public class JwtGenerator {
	
	/**
    * Method that generate alphanumeric value for token
    * @param jwtUser object JWT user
    * @return UserDetails user details information
    */
	public String generate(JwtUser jwtUser) {
		log.info("component JwtGenerator - calling generate method");
		Claims claims = Jwts.claims()
				.setSubject(jwtUser.getUserName());
		claims.put(Constants.USER_ID, String.valueOf(jwtUser.getId()));
		claims.put(Constants.ROLE, jwtUser.getRole());
		
		return Jwts.builder()
				.setClaims(claims)
				.signWith(SignatureAlgorithm.HS256, Constants.YOUR_SECRET)
				.compact();
	}
}
