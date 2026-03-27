package com.example.demo.serviceImplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.EmailOtpServiceRepository;
import com.example.demo.service.EmailService;

@Service
public class EmailServiceImplementation implements EmailService {

	@Autowired
	EmailOtpServiceRepository emailOtpServiceRepository;
	
	Email

	@Override
	public String sendOtp(String email) {

		return null;
	}

	@Override
	public String verifyEmailOtp(String email, String otp) {
		// TODO Auto-generated method stub
		return null;
	}

}
