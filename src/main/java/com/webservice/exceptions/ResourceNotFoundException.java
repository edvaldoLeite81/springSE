
package com.webservice.exceptions;

public class ResourceNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	

	public ResourceNotFoundException(Long id, String message) {
		super(message);
	}

}
