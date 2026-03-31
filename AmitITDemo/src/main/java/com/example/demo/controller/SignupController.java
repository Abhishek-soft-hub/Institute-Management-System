package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.dto.UserDto;
import com.example.demo.service.UserService;


@RestController
@RequestMapping("public")
public class SignupController {

	@Autowired
	UserService usersServiceImpl;

	@PostMapping("/signup")
	ResponseEntity<String> signup(@RequestBody UserDto usersDto) {
		usersServiceImpl.user(usersDto);
		return new ResponseEntity<String>("signup sucessful", HttpStatus.CREATED);
	}

}
