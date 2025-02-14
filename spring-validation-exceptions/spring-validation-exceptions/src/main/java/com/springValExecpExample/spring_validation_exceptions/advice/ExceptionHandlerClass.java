package com.springValExecpExample.spring_validation_exceptions.advice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerClass {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleException(MethodArgumentNotValidException exception) {

		Map<String, String> errorMap = new HashMap<>();
		
		exception.getBindingResult().getFieldErrors().forEach(error -> {

			errorMap.put(error.getField(), error.getDefaultMessage());
		});
		
		return errorMap;
	}
}
