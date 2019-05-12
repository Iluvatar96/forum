package com.Alpaca.forum.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED, reason = "Wrong Password")
public class IcorrectPasswordException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2798133693948626151L;

}
