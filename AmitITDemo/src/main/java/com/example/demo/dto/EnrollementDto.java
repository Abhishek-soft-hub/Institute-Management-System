package com.example.demo.dto;

import lombok.Data;

@Data
public class EnrollementDto {
	
	private int userId;
	private int batchId;
	private String enrollmentDate;
	private String mode;
	private String status;

}
