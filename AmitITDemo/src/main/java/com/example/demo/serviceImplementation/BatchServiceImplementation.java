package com.example.demo.serviceImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.demo.dto.BatchDto;
import com.example.demo.entity.Batches;
import com.example.demo.entity.Course;
import com.example.demo.exception.BatcheException;
import com.example.demo.repository.BatchRepository;
import com.example.demo.repository.CourseRepository;
import com.example.demo.service.BatchService;

@Service
public class BatchServiceImplementation implements BatchService {
	@Autowired
	BatchRepository batchRepository;
	@Autowired
	CourseRepository courseRepository;

	@Override
	public void batch(BatchDto batchDto) {

		if (batchDto.getBatchName() == null || batchDto.getCapacity() == 0 || batchDto.getCourseId() == 0) {
			throw new BatcheException("Please provide required fields", HttpStatus.BAD_REQUEST);
		}
		Course course = courseRepository.findById(batchDto.getCourseId()).get();
		Batches batch = new Batches();
		batch.setBatchName(batchDto.getBatchName());
		batch.setCapacity(batch.getCapacity());
		batch.setDate(batch.getDate());
		batch.setCourse(course);
		batchRepository.save(batch);

	}

	@Override
	public void deleteBatch(int id) {
		if (!batchRepository.existsById(id)) {
			throw new BatcheException("Batch not found", HttpStatus.NOT_FOUND);
		}
		batchRepository.deleteById(id);
	}

	@Override
	public void updateBatch(int id, Batches updateBatch) {
		if (!batchRepository.existsById(id)) {
			throw new BatcheException("Batch not found", HttpStatus.NOT_FOUND);
		}

		Batches existBatches = batchRepository.findById(id).get();
		existBatches.setBatchName(updateBatch.getBatchName());
		existBatches.setCapacity(updateBatch.getCapacity());
		existBatches.setCourse(updateBatch.getCourse());
		existBatches.setDate(updateBatch.getDate());
		
		batchRepository.save(existBatches);
		
	}

	@Override
	public Batches getBatch(int id) {
		if (!batchRepository.existsById(id)) {
			throw new BatcheException("Batch not found", HttpStatus.NOT_FOUND);
		}
		return batchRepository.findById(id).get();
	}

	@Override
	public List<Batches> batches() {

		if (batchRepository.findAll().isEmpty()) {
			throw new BatcheException("No records", HttpStatus.NOT_FOUND);
		}
		return batchRepository.findAll();
	}

}
