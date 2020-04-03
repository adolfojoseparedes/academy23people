package com.people23.academy.utils;

import org.springframework.stereotype.Component;
import com.people23.academy.utils.exception.BadRequestException;
import lombok.extern.log4j.Log4j2;

/**
 * Utility class to define validation operations
 * 
 * @author 23 People Company
 *
 */
@Component
@Log4j2
public class BaseValidations implements IBaseValidations {
	
	/**
    * Method for validate object type rut and set bad request exception
    * @param rut student rut
    * @param field description for validated field
    * @return void not return value
    */
	public void validateObjectRut(String rut, String field) {
		log.info("utils BaseValidations - calling validateObjectRut method");
	    if (!validateRut(rut)) {
	    	log.warn("utils BaseValidations - calling bad request exception for invalid ");
	        throw new BadRequestException("Invalid " + field, "Verify submitted information", "23 People Academy");
	    }
	}
	
	/**
    * Method for validate object type rut and set bad request exception
    * @param age integer age
    * @param field description for validated field
    * @return void not return value
    */
	public void validateObjectAge(int age, String field) {
		log.info("utils BaseValidations - calling validateObjectAge method");
	    if (age <= 18) {
	    	log.warn("utils BaseValidations - calling bad request exception for invalid ");
	        throw new BadRequestException("Invalid " + field, "Verify submitted information", "23 People Academy");
	    }
	}
	
	/**
    * Method for validate only object type rut
    * @param rut student rut
    * @return boolean true or false of the validation rut
    */
	private boolean validateRut(String rut) {
		log.info("utils BaseValidations - calling validateRut method");
	    boolean validation = false;
	    try {
	        rut = rut.toUpperCase();
	        rut = rut.replace(".", "");
	        rut = rut.replace("-", "");
	        int rutAux = Integer.parseInt(rut.substring(0, rut.length() - 1));
	        char dv = rut.charAt(rut.length() - 1);
	        int m = 0, s = 1;
	        for (; rutAux != 0; rutAux /= 10) {
	            s = (s + rutAux % 10 * (9 - m++ % 6)) % 11;
	        }
	        if (dv == (char) (s != 0 ? s + 47 : 75)) {
	        	validation = true;
	        }

	    } catch (Exception e) {
	    	validation = false;
	    }
	    return validation;
	}
}
