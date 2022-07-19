package com.LMS.LibraryManagementSystem.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BookNotFoundException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public BookNotFoundException()
	{
		super();
	}
	
	public BookNotFoundException(String msg)
	{
		super(msg);
	}
	

}
