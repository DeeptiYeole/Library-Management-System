package com.LMS.LibraryManagementSystem.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class OrderNotFoundException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public OrderNotFoundException()
	{
		super();
	}
	
	public OrderNotFoundException(String msg)
	{
		super(msg);
	}
	

}
