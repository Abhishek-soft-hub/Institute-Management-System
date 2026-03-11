package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;
@Data
@Entity
public class Enrollement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int enrollmentId;
	@OneToOne
	@JoinColumn(name = "userId")
	private User user;
	@OneToOne
	@JoinColumn(name = "batchId")
	private Batches batch;
	private String enrollmentDate;
	private String mode;
	private String status;
	
}
