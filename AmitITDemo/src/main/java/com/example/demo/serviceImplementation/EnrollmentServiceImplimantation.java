package com.example.demo.serviceImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.demo.dto.EnrollementDto;
import com.example.demo.entity.Batches;
import com.example.demo.entity.Enrollement;
import com.example.demo.entity.Trainner;
import com.example.demo.exception.BatcheException;
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
	BatchRepository batchRepository;

	@Override
	public void enrollment(EnrollementDto enrollementDto) {

		Batches batch = batchRepository.findById(enrollementDto.getBatchId())
				.orElseThrow(() -> new BatcheException("Batch not found", HttpStatus.NOT_FOUND));
		Enrollement enrollement = new Enrollement();
		enrollement.setName(enrollementDto.getName());
		enrollement.setEmail(enrollementDto.getEmail());
		enrollement.setContactNumber(enrollementDto.getContactNumber());
		enrollement.setAddress(enrollementDto.getAddress());
		enrollement.setBatch(batch);
	}

	@Override
	public void deleteEnrollment(int id) {
		if(enrollmentRepository.existsById(id)) {
			throw new UserException("This Enrollement Are Not Exist", HttpStatus.NOT_FOUND);
		}
		enrollmentRepository.deleteById(id);

	}

	@Override
	public void updateEnrollment(int id, Trainner updateTrainner) {
		if(enrollmentRepository.existsById(id)) {
			throw new UserException("This Enrollement Are Not Exist", HttpStatus.NOT_FOUND);
		}
		
	}

	@Override
	public Enrollement getEnrollmentUser(int id) {
		if(enrollmentRepository.existsById(id)) {
			throw new UserException("This Enrollement Are Not Exist", HttpStatus.NOT_FOUND);
		}
		return enrollmentRepository.findById(id).get();
	}

	@Override
	public List<Enrollement> enrollmentsUsers() {
		if(enrollmentRepository.findAll().isEmpty()) {
			throw new UserException("No Records Available", HttpStatus.NOT_FOUND);
		}
		return enrollmentRepository.findAll();
	}

}
