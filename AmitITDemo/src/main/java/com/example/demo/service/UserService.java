package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;

public interface UserService {
	public void user(UserDto userDto);
	public void deleteUser(int id);
	public void updateUser(int id, User updateUser);
	public User getUser(int id);
	public List<User> users();

}
