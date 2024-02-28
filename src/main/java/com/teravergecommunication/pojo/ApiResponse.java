package com.teravergecommunication.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiResponse {

	private String message;
	private boolean sucess;
}
