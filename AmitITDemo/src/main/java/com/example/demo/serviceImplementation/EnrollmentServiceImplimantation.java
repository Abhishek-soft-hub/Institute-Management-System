package com.example.demo.serviceImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.demo.dto.EnrollementDto;
import com.example.demo.entity.Batches;
import com.example.demo.entity.Enrollement;
import com.example.demo.entity.Trainner;
import com.example.demo.entity.User;
import com.example.demo.exception.UserException;
import com.example.demo.repository.BatchRepository;
import com.example.demo.repository.EnrollmentRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.EnrollmentService;

@Service
public class EnrollmentServiceImplimantation implements EnrollmentService {

	@Autowired
	EnrollmentRepository enrollmentRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	BatchRepository batchRepository;

	@Override
	public void enrollment(EnrollementDto enrollementDto) {

		User user = userRepository.findById(enrollementDto.getUserId()).orElseThrow(() -> new UserException("user not found", HttpStatus.BAD_REQUEST));
		Batches batch = batchRepository.findById(enrollementDto.getBatchId()).orElseThrow(() -> new RuntimeException("batch not foud"));
		Enrollement enrollement = new Enrollement();
		enrollement.setUser(user);
		enrollement.setBatch(batch);
		enrollement.setEnrollmentDate(enrollementDto.getEnrollmentDate());
		enrollement.setMode(enrollementDto.getMode());
		enrollement.setStatus(enrollementDto.getStatus());
		
		enrollmentRepository.save(enrollement);

	}

	@Override
	public void deleteEnrollment(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateEnrollment(int id, Trainner updateTrainner) {
		// TODO Auto-generated method stub

	}

	@Override
	public Trainner getEnrollmentUser(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Trainner> enrollmentsUsers() {
		// TODO Auto-generated method stub
		return null;
	}

}
