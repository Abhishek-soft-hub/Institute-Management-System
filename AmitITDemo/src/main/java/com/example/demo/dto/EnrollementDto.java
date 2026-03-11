package com.example.demo.dto;

import lombok.Data;

@Data
public class EnrollementDto {
	
	private String name;
	private int batchId;
	private String email;
	private long contactNumber;
	private String address;
	private String mode;
	private String status;
	
}
