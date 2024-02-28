package com.teravergecommunication.expection;

public class MediaNotSupportException extends RuntimeException {

	
	private static final long serialVersionUID = 1L;

	private String message; 
	private String type ;
	public MediaNotSupportException(String type, String message) {
		super(String.format(" Type %s media is not supported ", type, message));
		this.message = message;
		this.type = type;
	}
	
	
}
