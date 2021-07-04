package com.pop.exception;

import java.util.logging.Logger;

import com.pop.constants.Message;

public class PopException extends RuntimeException{
	
	private static final Logger LOGGER = Logger.getLogger(PopException.class.getClass().getName());

	private static final long serialVersionUID = -6193422379578628214L;
	
	public PopException(Message message, String exceptionMessage){
		String errMessage = exceptionMessage==null?message.errorMesssage:exceptionMessage;
		LOGGER.log(message.errorType, 
				message.errorAlphanumericNumericCode+":"+errMessage, message.originatorClass);
	}

}
