package com.example.demo.serviceImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.example.demo.dto.CourseDto;
import com.example.demo.entity.Course;
import com.example.demo.exception.CourseException;
import com.example.demo.repository.CourseRepository;
import com.example.demo.service.CourseService;

@Service
public class CourseServiceImplementation implements CourseService {

	@Autowired
	CourseRepository courseRepository;

	@Override
	public void course(CourseDto coursedto) {
		
		if(coursedto.getCourseName()==null || coursedto.getDescription()==null || coursedto.getFees()==0) {
			throw new CourseException("Please Enter valid data" , HttpStatus.BAD_REQUEST);
		}

		Course course = new Course();
		course.setCourseName(coursedto.getCourseName());
		course.setDescription(coursedto.getDescription());
		course.setDuration(coursedto.getDuration());
		course.setFees(coursedto.getFees());
		course.setSyllabus(coursedto.getSyllabus());

		courseRepository.save(course);

	}

	@Override
	public void deleteCourse(int id) {
		if (!courseRepository.existsById(id)) {
			throw new CourseException("This course currently not available", HttpStatus.NOT_FOUND);
		}
		courseRepository.deleteById(id);
	}

	@Override
	public void updateCourse(int id, Course updateCourse) {
		// TODO Auto-generated method stub

	}

	@Override
	public Course getCourse(int id) {
		if (!courseRepository.existsById(id)) {
			throw new CourseException("This course currently not available", HttpStatus.NOT_FOUND);
		}
		return courseRepository.findById(id).get();
	}

	@Override
	public List<Course> courses() {
		if (courseRepository.findAll().isEmpty()) {
			throw new CourseException("Records are not available", HttpStatus.NOT_FOUND);
		}
		return courseRepository.findAll();
	}

}
