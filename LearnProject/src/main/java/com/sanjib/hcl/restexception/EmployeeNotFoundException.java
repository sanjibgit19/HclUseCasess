package com.sanjib.hcl.restexception;

public class EmployeeNotFoundException extends Exception {
	private final String errorMessage;
	private final String errorReason;

	public EmployeeNotFoundException(String errorMessage, String errorReason ) {
		this.errorMessage=errorMessage;
		this.errorReason=errorReason;
	}//
	
	public String getMessage() {
		return errorMessage;
	}//
	
	public String getErrorReason() {
		return errorReason;
	}

}//class
