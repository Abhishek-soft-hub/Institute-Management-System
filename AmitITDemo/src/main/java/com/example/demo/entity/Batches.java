package com.example.demo.entity;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

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
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate date;
	@ManyToOne
	@JoinColumn(name = "courseId")
	@JsonBackReference
	private Course course;
	@ManyToMany(mappedBy = "batches")
	private List<Trainner> trainner;
	@OneToMany(mappedBy = "batch")
	private List<Enrollement> enrollements;
	


}
