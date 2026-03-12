package com.example.demo.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;
@Data
@Entity
public class Enrollement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int enrollmentId;
	private LocalDate enrollmentDate;
	private String mode;
	private String status;
	private Boolean liveSessionAccess;
	private Boolean recordingAccess;
	private int totalFees;
	private int paidFees;
	private int remainigFees;
	private LocalDate feesDueDate;
	private LocalDate extendedDueDate;
	@ManyToOne
	@JoinColumn(name = "batchId")
	private Batches batch;
	@OneToOne
	@JoinColumn(name = "userId")
	private User user;
}
