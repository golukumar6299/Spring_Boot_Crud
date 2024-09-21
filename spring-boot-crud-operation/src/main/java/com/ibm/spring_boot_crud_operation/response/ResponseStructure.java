package com.ibm.spring_boot_crud_operation.response;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class ResponseStructure<T> {

	private int statusCode;
	private String message;
	private T date;
}
