package com.example.demo.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class EmailOtp {
	@Id
	private int id;
	private String email;
	private String otp;
	private LocalDate expiry;
	private boolean verified;
	
	

}
