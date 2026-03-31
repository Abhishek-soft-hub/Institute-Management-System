package com.example.demo.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class Trainner {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@OneToOne
	@JoinColumn(name = "userId")
	private Users user;
	private String specialization;
	private String experince;
	@ManyToMany
	@JoinTable(name = "trainner_Batch", joinColumns = @JoinColumn(name = "trainerId"), inverseJoinColumns = @JoinColumn(name = "batchId"))
	private List<Batches> batches;

}
