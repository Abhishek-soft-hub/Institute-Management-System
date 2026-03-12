package com.example.demo.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CourseDto;
import com.example.demo.entity.Course;
import com.example.demo.service.CourseService;


@RestController
public class CourseController {
	@Autowired
	CourseService courseService;
	
	@PostMapping("course")
	public ResponseEntity<String> course(@RequestBody CourseDto courseDto){
		courseService.course(courseDto);
		return new ResponseEntity<String>(HttpStatus.CREATED);
		
	}
	
	@DeleteMapping("course/delete/{id}")
	public ResponseEntity<String> course(@PathVariable int id){
		courseService.deleteCourse(id);
		return new ResponseEntity<String>("Course are deleted" , HttpStatus.OK);
	}
	
	@GetMapping("course/{id}")
	public ResponseEntity<Course> getCourse(@PathVariable int id){
		return new ResponseEntity<Course>(courseService.getCourse(id), HttpStatus.OK);
		
	}
	 
	@GetMapping("courses")
	public ResponseEntity<List<Course>> courses(){
		return new ResponseEntity<List<Course>>(courseService.courses(), HttpStatus.OK);
		
		
	}

}
