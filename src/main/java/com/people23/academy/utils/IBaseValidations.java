package com.people23.academy.utils;

/**
 * Interface for utility base validations
 * 
 * @author 23 People Company
 *
 */
public interface IBaseValidations {

	void validateObjectRut(String rutClient, String string);
	
	void validateObjectAge(int age, String field);
}
