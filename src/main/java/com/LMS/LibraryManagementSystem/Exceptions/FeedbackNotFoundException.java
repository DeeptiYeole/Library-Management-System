package com.LMS.LibraryManagementSystem.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class FeedbackNotFoundException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public FeedbackNotFoundException()
	{
		super();
	}
	
	public FeedbackNotFoundException(String msg)
	{
		super(msg);
	}
	

}
