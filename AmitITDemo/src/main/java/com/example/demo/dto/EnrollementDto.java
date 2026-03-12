package com.example.demo.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class EnrollementDto {
	private int userId;
	private int batchId;
	private String mode;
	private LocalDate localDate;
	
}
