package com.webservice.exceptions;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@RestControllerAdvice
public class GlobalExceptionHandler {

	// validacao de campos 
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorResponse handleValidationException(MethodArgumentNotValidException ex) {

		List<String> errors = ex.getBindingResult().getFieldErrors().stream()
				.map(error -> error.getField() + ": " + error.getDefaultMessage()).collect(Collectors.toList());

		ErrorResponse errorResponse = new ErrorResponse();

		errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
		errorResponse.setMessage("validation failure");
		errorResponse.setErrors(errors);

		return errorResponse;
		
	}// validacao de campos

	/*
	 * @org.springframework.web.bind.annotation.ExceptionHandler(
	 * MethodArgumentNotValidException.class)
	 * 
	 * @ResponseStatus(HttpStatus.BAD_REQUEST) public Map<String, String>
	 * handleValidationExceptions(MethodArgumentNotValidException ex) {
	 * 
	 * Map<String,String> errors = new HashMap<>();
	 * 
	 * 
	 * ex.getBindingResult().getAllErrors().forEach((error) -> { String fieldName =
	 * ((FieldError) error).getField(); String errorMessage =
	 * error.getDefaultMessage(); String errorCode = error.getCode();
	 * 
	 * errors.put(fieldName, errorMessage); });
	 * 
	 * return errors;
	 * 
	 * }// class Map
	 */

	// recurso nao encontrado
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Object> handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {

		// instante atual com menos 3 horas
		// Instant moment = Instant.now().minus(3,ChronoUnit.HOURS);
		Instant moment = Instant.now();
		String message = ex.getMessage();
		APIError apiError = new APIError(moment, HttpStatus.NOT_FOUND.value(), message);

		return ResponseEntity.status(apiError.getStatus()).body(apiError);

	}// recurso nao encontrado
	

	//regra do bd 
	@ExceptionHandler(DatabaseException.class)
	public ResponseEntity<Object> handleDataBaseException(DatabaseException ex, WebRequest request) {

		// instante atual com menos 3 horas
		// Instant moment = Instant.now().minus(3,ChronoUnit.HOURS);
		Instant moment = Instant.now();
		String message = ex.getMessage();
		APIError apiError = new APIError(moment, HttpStatus.BAD_REQUEST.value(), message);

		return ResponseEntity.status(apiError.getStatus()).body(apiError);

	}//regra do bd 

	
	
	// classe para recurso nao encontrado e regra do bd
	private static class APIError {

		@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-ss'T'HH:mm:ss'Z'", timezone = "GMT")
		private Instant moment;
		private int status;
		private String message;

		public APIError() {
		}

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

	}// classe para recurso nao encontrado e regra do bd

	
	//classe para validar campos
	@Getter
	@Setter
	@NoArgsConstructor
	private static class ErrorResponse {

		private int status;
		private String message;
		private List<String> errors;

	}

}
