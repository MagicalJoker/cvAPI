package edu.altair.cv.exceptions;

import org.springframework.http.HttpStatus;

public class ResourceNotFoundException extends ApiException {

	public ResourceNotFoundException(String recurso, Object identificador) {
		super(HttpStatus.NOT_FOUND, recurso + " no encontrado: " + identificador);
	}

}
