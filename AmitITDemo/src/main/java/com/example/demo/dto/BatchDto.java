package com.example.demo.dto;




import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class BatchDto {

	private String batchName;
	private int capacity;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate date;
	private int courseId;
	
}
