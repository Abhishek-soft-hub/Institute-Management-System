package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("admin")
public class UserControllerByAdmin {
	@Autowired
	UserService userService;

	@DeleteMapping("delete/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable int id) {
		userService.deleteUser(id);
		return new ResponseEntity<String>("User are deleted", HttpStatus.OK);
	}

	@PatchMapping("update/{id}")
	public ResponseEntity<String> updateUser(@PathVariable int id, @RequestBody User user) {
		userService.updateUser(id, user);
		return new ResponseEntity<String>("User are updated", HttpStatus.OK);
	}

	@GetMapping("user/{id}")
	public ResponseEntity<User> getUser(@PathVariable int id) {
		return new ResponseEntity<User>(userService.getUser(id), HttpStatus.OK);

	}

	@GetMapping("users")
	public ResponseEntity<List<User>> users() {
		return new ResponseEntity<List<User>>(userService.users(), HttpStatus.OK);

	}

}
