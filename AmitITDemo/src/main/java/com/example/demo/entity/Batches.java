package com.example.demo.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Batches {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String batchName;
	private int capacity;
	private String Date;
	@ManyToOne
	@JoinColumn(name = "courseId")
	private Course course;
	@ManyToMany(mappedBy = "batches")
	private List<Trainner> trainners;
	@OneToMany(mappedBy = "batch")
	private List<Enrollement> enrollements;
	


}
