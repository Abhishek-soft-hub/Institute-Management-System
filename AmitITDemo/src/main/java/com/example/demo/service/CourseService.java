package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.CourseDto;
import com.example.demo.entity.Course;

public interface CourseService {
	public void course(CourseDto coursedto);
	public void deleteCourse(int id);
	public void updateCourse(int id, Course updateCourse);
	public Course getCourse(int id);
	public List<Course> courses();
	

}
