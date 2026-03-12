package com.example.demo.dto;

import lombok.Data;

@Data
public class CourseDto {
	
	private String courseName;
	private String description;
	private String syllabus;
	private String duration;
	private int fees;
}
