package com.sanjib.hcl.restexception;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestController
//@RestControllerAdvice
@ControllerAdvice
public class AppGlobalExceptionHandler extends ResponseEntityExceptionHandler {

	//@Override
	public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		System.out.println("Entering to handler method for validation");
		List<String> details = new ArrayList<>();
		details = ex.getFieldErrors().stream().map(e1->e1.getField()+" : "+e1.getDefaultMessage()).collect(Collectors.toList());
		
		ErrorResponse error=new ErrorResponse(4000L, details);
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<ApiError> handleException(EmployeeNotFoundException ex) {
		// String details=ex.getLocalizedMessage();
		String errorMessage = ex.getMessage();
		String errorReason = ex.getErrorReason();
		ApiError error = new ApiError(4000L, errorMessage, errorReason, new Date());
		ResponseEntity<ApiError> responseEntity = new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
		return responseEntity;
	}// handleEmployeeNotFoundException()

}// class
