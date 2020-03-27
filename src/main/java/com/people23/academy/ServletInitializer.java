package com.people23.academy;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * Class for servlet initializer
 * 
 * @author 23 People Company
 *
 */
public class ServletInitializer extends SpringBootServletInitializer {

	/**
    * Method  main for class
    * @return SpringApplicationBuilder spring application configuration for builder
    */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ApiRestAcademyApplication.class);
	}
}
