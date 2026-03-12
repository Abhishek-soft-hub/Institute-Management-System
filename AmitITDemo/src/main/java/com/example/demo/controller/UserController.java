package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UserDto;

import com.example.demo.service.UserService;

@RestController
public class UserController {
	@Autowired
	UserService userService;

	@PostMapping("user")
	public ResponseEntity<String> user(@RequestBody UserDto userDto) {
		userService.user(userDto);
		return new ResponseEntity<String>(HttpStatus.CREATED);

	}

}
