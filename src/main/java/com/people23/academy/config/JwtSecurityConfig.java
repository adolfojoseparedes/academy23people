package com.people23.academy.config;

import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;
import com.people23.academy.security.JwtAuthenticationEntryPoint;
import com.people23.academy.security.JwtAuthenticationProvider;
import com.people23.academy.security.JwtAuthenticationTokenFilter;
import com.people23.academy.security.JwtSuccessHandler;
import lombok.extern.log4j.Log4j2;

/**
 * Class JWT security configuration web
 * 
 * @author 23 People Company
 *
 */
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
@Component
@Log4j2
public class JwtSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private JwtAuthenticationProvider authenticationProvider;
	
	@Autowired
	private JwtAuthenticationEntryPoint entryPoint;
	
	/**
    * Method of authentication manager
    * @return AuthenticationManager Object class with singleton list provider
    */
	@Bean
	public AuthenticationManager authenticationManager() {
		log.info("component JwtSecurityConfig - calling authenticationManager method");
		return new ProviderManager(Collections.singletonList(authenticationProvider));
	}
	
	/**
    * Method of authentication for filter token
    * @return JwtAuthenticationTokenFilter Object class contain authentication manager and sucess handler
    */
	@Bean
	public JwtAuthenticationTokenFilter authenticationTokenFilter() {
		log.info("component JwtSecurityConfig - calling authenticationTokenFilter method");
		JwtAuthenticationTokenFilter filter = new JwtAuthenticationTokenFilter();
		filter.setAuthenticationManager(authenticationManager());
		filter.setAuthenticationSuccessHandler(new JwtSuccessHandler());
		return filter;
	}
	
	/**
    * Method of configure HTTP properties for request token
    * @param http It contain configuration web based security
    * @return void not return value
    */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		log.info("component JwtSecurityConfig - calling configure method");
		http.csrf().disable()
		.authorizeRequests().antMatchers("**/api/**").authenticated()
		.and()
		.exceptionHandling().authenticationEntryPoint(entryPoint)
		.and()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.addFilterBefore(authenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class);
		http.headers().cacheControl();
	}
}
