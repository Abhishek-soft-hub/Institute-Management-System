package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.BatchDto;
import com.example.demo.entity.Batches;

public interface BatchService {
	
	public void batch(BatchDto batchDto);
	public void deleteBatch(int id);
	public void updateBatch(int id, Batches updateBatch);
	public Batches getBatch(int id);
	public List<Batches> batches();
}
