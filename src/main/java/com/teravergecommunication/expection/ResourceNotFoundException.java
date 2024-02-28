package com.teravergecommunication.expection;

public class ResourceNotFoundException extends RuntimeException {

	 
	private static final long serialVersionUID = 132435478654L;
	
	private String resourceName;
	private String fieldName;
	private Integer id;
	
	
	public ResourceNotFoundException(String resourceName, String fieldName, Integer id) {
		super(String.format("%s not found with %s : %s", resourceName, fieldName, id));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.id = id;
	}
	
	

}
