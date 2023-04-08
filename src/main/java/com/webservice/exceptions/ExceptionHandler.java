package com.webservice.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.fasterxml.jackson.annotation.JsonFormat;

@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {

	@org.springframework.web.bind.annotation.ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Object> handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
		
		//instante atual com menos 3 horas
		//Instant moment = Instant.now().minus(3,ChronoUnit.HOURS);
		Instant moment = Instant.now();
		String message = ex.getMessage();
		APIError apiError = new APIError(moment, HttpStatus.NOT_FOUND.value(), message);
		
		return ResponseEntity.status(apiError.getStatus()).body(apiError);
		
	}

	
	
	

	// classe generica
	private static class APIError {
		
		@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-ss'T'HH:mm:ss'Z'", timezone = "GMT")
		private Instant moment;
		private int status;
		private String message;

		public APIError(Instant moment, int status, String message) {
			this.moment = moment;
			this.status = status;
			this.message = message;

		}// fim do construtor
		
		public Instant getMoment() {
			return moment;
		}

		public int getStatus() {
			return status;
		}

		public String getMessage() {
			return message;
		}

	}// fim da classe APIError

}// fim
