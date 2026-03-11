package com.example.demo.dto;

import java.util.List;

import com.example.demo.entity.Trainner;

import lombok.Data;

@Data
public class BatchDto {

	private String batchName;
	private int capacity;
	private String Date;
	private int courseId;
	private List<Trainner> trainnerIds;
	
}
