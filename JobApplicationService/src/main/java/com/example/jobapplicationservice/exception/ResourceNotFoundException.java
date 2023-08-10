package com.example.jobapplicationservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{

	private static final long serialVersionUID = -5483004390450157569L;
	
	public ResourceNotFoundException(String resourceName , String fieldName , String fieldValue) {
		super(String.format("%s not found with %s : %s",  resourceName , fieldName , fieldValue));
	}


}
