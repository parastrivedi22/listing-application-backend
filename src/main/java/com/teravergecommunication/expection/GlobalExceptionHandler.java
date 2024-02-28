package com.teravergecommunication.expection;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.teravergecommunication.pojo.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> resourceNotFoundException(Exception ex){
		return new ResponseEntity<>(new ApiResponse(ex.getMessage(), false), HttpStatus.NOT_FOUND);
		
	}
	@ExceptionHandler(MediaNotSupportException.class)
	public ResponseEntity<ApiResponse>mediaNotSupportException(Exception ex){
		return new ResponseEntity<>(new ApiResponse(ex.getMessage(), false), HttpStatus.BAD_REQUEST);
			
	}
}
