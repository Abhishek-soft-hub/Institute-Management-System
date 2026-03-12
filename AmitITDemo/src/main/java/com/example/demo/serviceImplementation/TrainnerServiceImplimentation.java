package com.example.demo.serviceImplementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.demo.dto.TrainnerDto;
import com.example.demo.entity.Batches;
import com.example.demo.entity.Trainner;
import com.example.demo.entity.User;
import com.example.demo.exception.UserException;
import com.example.demo.repository.BatchRepository;
import com.example.demo.repository.TrainnerRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.TrainnerService;

@Service
public class TrainnerServiceImplimentation implements TrainnerService {

	@Autowired
	TrainnerRepository trainnerRepository;
	@Autowired
	BatchRepository batchRepository;
	@Autowired
	UserRepository userRepository;

	@Override
	public void trainner(TrainnerDto trainnerDto) {
		
		
		User user = userRepository.findById(trainnerDto.getUId()).get();
		List<Batches> batchList = new ArrayList<>();

		for (Integer batcheId : trainnerDto.getBatchIds()) {
			Batches batches = batchRepository.findById(batcheId).get();
			batchList.add(batches);
		}
		
		Trainner trainner = new Trainner();
		trainner.setUser(user);
		trainner.setExperince(trainnerDto.getExperince());
		trainner.setSpecialization(trainnerDto.getSpecialization());
		trainner.setBatches(batchList);
		
		trainnerRepository.save(trainner);
	}

	@Override
	public void deleteTrainner(int id) {
		if(!trainnerRepository.existsById(id)) {
			throw new UserException("Trainner not Found", HttpStatus.NOT_FOUND);
		}
		trainnerRepository.deleteById(id);
	}

	@Override
	public void updateTrainner(int id, Trainner updateTrainner) {
		// TODO Auto-generated method stub

	}

	@Override
	public Trainner getTrainner(int id) {
		if(!trainnerRepository.existsById(id)) {
			throw new UserException("Trainner not Found", HttpStatus.NOT_FOUND);
		}
		return trainnerRepository.findById(id).get();
	}

	@Override
	public List<Trainner> trainners() {
		if(trainnerRepository.findAll().isEmpty()) {
			throw new UserException("No records", HttpStatus.NOT_FOUND);
		}
		return trainnerRepository.findAll();
	}

}
