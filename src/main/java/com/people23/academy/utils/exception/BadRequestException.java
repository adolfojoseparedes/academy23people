package com.people23.academy.utils.exception;

import java.util.Date;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


/**
 * Model class for handling bad request exception
 * 
 * @author 23 People Company
 *
 */
@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private final String solution;

    private final String code;

    private final Date time = new Date();

    /**
    * Constructor
    */
    public BadRequestException() {
        super();
        code = "";
        solution = "";
    }

    /**
	* Constructor
	* @param message message string
	* @param solution solution string
	* @param code code string
	*/
    public BadRequestException(String message, String solution, String code) {
        super(message);
        this.solution = solution;
        this.code = code;
    }

	public String getSolution() {
		return solution;
	}

	public String getCode() {
		return code;
	}

	public Date getTime() {
		return time;
	}
}
