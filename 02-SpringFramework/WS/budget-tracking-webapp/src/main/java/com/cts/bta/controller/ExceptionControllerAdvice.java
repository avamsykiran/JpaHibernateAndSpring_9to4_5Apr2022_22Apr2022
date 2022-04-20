package com.cts.bta.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.cts.bta.exception.BadTxnException;

@ControllerAdvice
public class ExceptionControllerAdvice {
	
	Logger logger;
	
	public ExceptionControllerAdvice() {
		logger = LoggerFactory.getLogger(this.getClass());
	}

	@ExceptionHandler(BadTxnException.class)
	public ModelAndView handleBadTxnException(BadTxnException exception) {
		logger.error(exception.getMessage(), exception);
		return new ModelAndView("error-page","msg",exception.getMessage());
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handleUnhandledExceptions(Exception exception) {
		logger.error(exception.getMessage(), exception);
		return new ModelAndView("error-page","msg",
				"An internal server error occured;We regret Inconvinience.");
	}
	
}
