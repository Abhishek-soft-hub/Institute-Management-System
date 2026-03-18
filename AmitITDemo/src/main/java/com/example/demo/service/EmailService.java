package com.example.demo.service;

public interface EmailService {

	public String sendOtp(String email);

	public String verifyEmailOtp(String email, String otp);
}
