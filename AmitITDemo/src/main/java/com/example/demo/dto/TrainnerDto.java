package com.example.demo.dto;

import java.util.List;

import com.example.demo.entity.Batches;

import lombok.Data;

@Data
public class TrainnerDto {

	private int id;
	private int uId;
	private String specialization;
	private String experince;
	private List<Batches> batchIds;
}
