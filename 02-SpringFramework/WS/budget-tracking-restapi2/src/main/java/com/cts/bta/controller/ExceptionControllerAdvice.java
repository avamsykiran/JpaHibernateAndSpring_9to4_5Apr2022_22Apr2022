package com.cts.bta.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import com.cts.bta.exception.BadTxnException;

@RestControllerAdvice
public class ExceptionControllerAdvice {
	
	Logger logger;
	
	public ExceptionControllerAdvice() {
		logger = LoggerFactory.getLogger(this.getClass());
	}

	@ExceptionHandler(BadTxnException.class)
	public ResponseEntity<String> handleBadTxnException(BadTxnException exception) {
		logger.error(exception.getMessage(), exception);
		return new ResponseEntity<String>(exception.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleUnhandledExceptions(Exception exception) {
		logger.error(exception.getMessage(), exception);
		return new ResponseEntity<String>(
				"An internal server error occured;We regret Inconvinience.",
				HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
