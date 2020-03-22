package com.people23.academy.utils.exception;

import java.util.Date;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


/**
 * Error Request for wrong fields
 * 
 * @see Academy 23 People
 * @author 23 People
 *
 */
@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException {

    /**
     * Serial.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Solution.
     */
    private final String solution;

    /**
     * Code.
     */
    private final String code;

    /**
     * error time
     */
    private final Date time = new Date();

    /**
     * Empty Constructor.
     */
    public BadRequestException() {
        super();
        code = "";
        solution = "";
    }

    /**
     * Constructor.
     * 
     * @param message message.
     * @param solution solution.
     * @param code code.
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
