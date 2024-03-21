package com.matrix.challenge.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.matrix.challenge.exception.ParametersException;
import com.matrix.challenge.exception.ProductNotFoundException;

@RestControllerAdvice
public class CustomExceptionHandler {
	
	private Map<String, String> res = new HashMap<String, String>();

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(ProductNotFoundException.class)
	public Map<String, String> handlerProductNotFound(ProductNotFoundException e) {
		this.res.put("message", e.getMessage());
		return res;
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(ParametersException.class)
	public Map<String, String> handlerParametersException(ParametersException e) {
		this.res.put("message", e.getMessage());
		return res;
	}
}
