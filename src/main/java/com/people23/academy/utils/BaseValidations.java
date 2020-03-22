package com.people23.academy.utils;


import org.springframework.stereotype.Component;
import com.people23.academy.utils.exception.BadRequestException;
import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
public class BaseValidations implements IBaseValidations {

	public void validateObjectRut(String rutClient, String string) {
		log.info("utils BaseValidations - calling validateObjectRut method");
	    if (!validateRut(rutClient)) {
	    	log.warn("utils BaseValidations - calling bad request exception for invalid ");
	        throw new BadRequestException("Invalid " + string, "Verify submitted information", "23 People Academy");
	    }
	}
	
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
