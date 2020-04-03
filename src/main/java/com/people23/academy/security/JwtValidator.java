package com.people23.academy.security;

import org.springframework.stereotype.Component;
import com.people23.academy.constants.Constants;
import com.people23.academy.model.JwtUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.extern.log4j.Log4j2;

/**
 * Generator JWT validator
 * 
 * @author 23 People Company
 *
 */
@Component
@Log4j2
public class JwtValidator {

	/**
    * Method for validate token versus secret constant, user id constant and user role
    * @param token JWT alphanumeric token
    * @return JwtUser object JWT user
    */
	public JwtUser validate(String token) {
		log.info("component JwtValidator - calling validate method");
		JwtUser jwtUser = null;
		
		try {
			Claims body = Jwts.parser()
					.setSigningKey(Constants.YOUR_SECRET)
					.parseClaimsJws(token)
					.getBody();
			
			jwtUser = new JwtUser();
			jwtUser.setUserName(body.getSubject());
			jwtUser.setId(Long.parseLong((String) body.get(Constants.USER_ID)));
			jwtUser.setRole((String) body.get(Constants.ROLE));
			
		}catch(Exception e) {
			log.warn(e);
		}
		return jwtUser;
	}
}
