package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.Users;

public interface UserService {
	public void user(UserDto usersDto);
	public void deleteUser(int id);
	public void updateUser(int id, Users updateUser);
	public Users getUser(int id);
	public List<Users> users();

}
