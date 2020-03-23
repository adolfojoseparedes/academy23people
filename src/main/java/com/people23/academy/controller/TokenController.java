package com.people23.academy.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.people23.academy.model.JwtUser;
import com.people23.academy.model.Login;
import com.people23.academy.security.JwtGenerator;
import lombok.extern.log4j.Log4j2;


@RestController
@RequestMapping("/token")
@Log4j2
public class TokenController {
	
	private JwtGenerator jwtGenerator;
	
	@Value("${token.user}")
	private String validUser;
	
	@Value("${token.password}")
	private String validPassword;
	
	@Autowired
	private Login login;
	
	public TokenController(JwtGenerator jwtGenerator) {
		log.info("controller TokenController - constructor");
		this.jwtGenerator = jwtGenerator;
	}
	
	@PostMapping
	public ResponseEntity<?> generate() {
		log.info("controller TokenController - calling generate method");
		JwtUser jwtUser = new JwtUser();
		jwtUser = existUser(login);
		if(jwtUser != null) {
			List<String> lista = new ArrayList<>();
			lista.add(jwtGenerator.generate(jwtUser));
			return new ResponseEntity<List<String>>(lista, HttpStatus.OK);
		}else {
			log.warn("controller TokenController - user unauthorized");
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
	}

	private JwtUser existUser(Login login) {
		log.info("controller TokenController - calling existUser method");
		if(login.getUser().equals(validUser) && login.getPassword().equals(validPassword)) {
			JwtUser jwtUser = new JwtUser();
			jwtUser.setUserName(login.getUser());
			jwtUser.setId(1);
			jwtUser.setRole("Admin");
			return jwtUser;
		}else {
			return null;
		}
	}
}
