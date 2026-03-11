package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.EnrollementDto;
import com.example.demo.entity.Enrollement;
import com.example.demo.entity.Trainner;

public interface EnrollmentService {
	public void enrollment(EnrollementDto enrollementDto);
	public void deleteEnrollment(int id);
	public void updateEnrollment(int id, Trainner updateTrainner);
	public Enrollement getEnrollmentUser(int id);
	public List<Enrollement> enrollmentsUsers();

}
