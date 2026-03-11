package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.TrainnerDto;
import com.example.demo.entity.Trainner;

public interface TrainnerService {
	
	public void trainner(TrainnerDto trainnerDto);
	public void deleteTrainner(int id);
	public void updateTrainner(int id, Trainner updateTrainner);
	public Trainner getTrainner(int id);
	public List<Trainner> trainners();

}
