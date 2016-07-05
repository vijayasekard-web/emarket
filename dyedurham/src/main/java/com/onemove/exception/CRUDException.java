package com.onemove.exception;

public class CRUDException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	private String message;
	public CRUDException(String message){
		setMessage(message);
	}
}
