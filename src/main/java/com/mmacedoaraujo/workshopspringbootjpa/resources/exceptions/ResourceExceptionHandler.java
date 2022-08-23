package com.mmacedoaraujo.workshopspringbootjpa.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.mmacedoaraujo.workshopspringbootjpa.services.exceptions.DatabaseException;
import com.mmacedoaraujo.workshopspringbootjpa.services.exceptions.ResourceNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException ex, HttpServletRequest request) {
		String error = "Resource not found";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError standardError = new StandardError(Instant.now(), status.value(), error, ex.getMessage(),
				request.getRequestURI());

		return ResponseEntity.status(status).body(standardError);
	}

	@ExceptionHandler(DatabaseException.class)
	public ResponseEntity<StandardError> database(DatabaseException ex, HttpServletRequest request) {
		String error = "Database error";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError standardError = new StandardError(Instant.now(), status.value(), error, ex.getMessage(),
				request.getRequestURI());

		return ResponseEntity.status(status).body(standardError);
	}
}
