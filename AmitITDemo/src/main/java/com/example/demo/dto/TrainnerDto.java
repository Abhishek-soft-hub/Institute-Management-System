package com.example.demo.dto;

import java.util.List;

import lombok.Data;

@Data
public class TrainnerDto {

	private int uId;
	private String specialization;
	private String experince;
	private List<Integer> batchIds;
}
