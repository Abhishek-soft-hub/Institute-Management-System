package com.example.demo.serviceImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.dto.BatchDto;
import com.example.demo.entity.Batches;
import com.example.demo.repository.BatchRepository;
import com.example.demo.service.BatchService;

@Service
public class BatchServiceImplementation implements BatchService {
	@Autowired
	BatchRepository batchRepository;

	@Override
	public void batch(BatchDto batchDto) {
		Batches batch = new Batches();
		batch.setBatchName(batchDto.getBatchName());
		batch.setCapacity(batch.getCapacity());
		batch.setDate(batch.getDate());
		batch.setTrainners(batchDto.getTrainnerIds());
		batchRepository.save(batch);
		
	}

	@Override
	public void deleteBatch(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateBatch(int id, Batches updateBatch) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Batches getBatch(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Batches> batches() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
