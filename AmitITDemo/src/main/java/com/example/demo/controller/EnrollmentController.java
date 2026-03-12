package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.EnrollementDto;

import com.example.demo.service.EnrollmentService;

@RestController
@RequestMapping("user")
public class EnrollmentController {

	@Autowired
	EnrollmentService enrollmentService;

	@PostMapping("enrollment")
	public ResponseEntity<String> enrollment(@RequestBody EnrollementDto enrollementDto) {
		enrollmentService.enrollment(enrollementDto);
		return new ResponseEntity<String>("Enrollment are done", HttpStatus.CREATED);

	}

}
