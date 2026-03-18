package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.EmailOtp;
@Repository
public interface EmailOtpServiceRepository extends JpaRepository<EmailOtp, Integer>  {

}
