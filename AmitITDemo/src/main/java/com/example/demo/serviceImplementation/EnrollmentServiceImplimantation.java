package com.example.demo.serviceImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.demo.dto.EnrollementDto;
import com.example.demo.entity.Batches;
import com.example.demo.entity.Enrollement;
import com.example.demo.entity.Users;
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
	@Autowired
	UserRepository userRepository;

	@Override
	public void enrollment(EnrollementDto enrollementDto) {

		if(enrollementDto.getBatchId() == 0 || enrollementDto.getUserId()==0 || enrollementDto.getMode()==null ) {
			throw new UserException("Please provide required fields", HttpStatus.BAD_REQUEST);
		}
		Batches batch = batchRepository.findById(enrollementDto.getBatchId()).get();

		Users user = userRepository.findById(enrollementDto.getUserId()).get();

		Enrollement enrollement = new Enrollement();

		enrollement.setBatch(batch);

		enrollement.setUser(user);

		enrollement.setMode(enrollementDto.getMode());

		enrollement.setEnrollmentDate(enrollementDto.getLocalDate());

		enrollmentRepository.save(enrollement);

	}

	@Override
	public void deleteEnrollment(int id) {
		if (enrollmentRepository.existsById(id)) {
			
			throw new UserException("This Enrollement Are Not Exist", HttpStatus.NOT_FOUND);
		}
		
		enrollmentRepository.deleteById(id);

	}

	@Override
	public void updateEnrollment(int id, Enrollement updateEnrollment) {
		
		if (enrollmentRepository.existsById(id)) {
		
			throw new UserException("This Enrollement Are Not Exist", HttpStatus.NOT_FOUND);
		}

		Enrollement existEnrollment = enrollmentRepository.findById(id).get();

		existEnrollment.setExtendedDueDate(updateEnrollment.getExtendedDueDate());
		
		existEnrollment.setFeesDueDate(updateEnrollment.getFeesDueDate());
		
		existEnrollment.setLiveSessionAccess(updateEnrollment.getLiveSessionAccess());
		
		existEnrollment.setMode(updateEnrollment.getMode());
		
		existEnrollment.setPaidFees(updateEnrollment.getPaidFees());
		
		existEnrollment.setRecordingAccess(updateEnrollment.getRecordingAccess());
		
		existEnrollment.setRemainigFees(updateEnrollment.getRemainigFees());
		
		existEnrollment.setStatus(updateEnrollment.getStatus());
		
		existEnrollment.setTotalFees(updateEnrollment.getTotalFees());

		enrollmentRepository.save(existEnrollment);

	}

	@Override
	public Enrollement getEnrollmentUser(int id) {
		
		if (enrollmentRepository.existsById(id)) {
			
			throw new UserException("This Enrollement Are Not Exist", HttpStatus.NOT_FOUND);
		
		}
		
		return enrollmentRepository.findById(id).get();
	}

	@Override
	public List<Enrollement> enrollmentsUsers() {
		
		if (enrollmentRepository.findAll().isEmpty()) {
		
			throw new UserException("No Records Available", HttpStatus.NOT_FOUND);
		
		}
		
		return enrollmentRepository.findAll();
	}

}
