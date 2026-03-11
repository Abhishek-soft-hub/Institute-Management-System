package com.example.demo.serviceImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import com.example.demo.exception.UserException;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

@Service
public class UserServiceImplementation implements UserService {
	@Autowired
	UserRepository userRepository;

	@Override
	public void user(UserDto userDto) {

		if (!userDto.getEmail().contains("@")) {
			throw new UserException("Please provide valid Email", HttpStatus.BAD_REQUEST);
		}
		User user = new User();
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setMobileNumber(userDto.getMobileNumber());
		user.setRole("user");
		userRepository.save(user);

	}

	@Override
	public void deleteUser(int id) {
		if (!userRepository.existsById(id)) {
			throw new UserException("This user are not exist", HttpStatus.NOT_FOUND);
		}
		userRepository.deleteById(id);

	}

	@Override
	public void updateUser(int id, User updateUser) {

		User existUser = userRepository.findById(id)
				.orElseThrow(() -> new UserException("User is not found", HttpStatus.NOT_FOUND));

		if (existUser != null) {
			existUser.setName(updateUser.getName());
			existUser.setAddress(updateUser.getAddress());
			existUser.setAdhaarNumber(updateUser.getAdhaarNumber());
			existUser.setDateOfBirth(updateUser.getDateOfBirth());
			existUser.setEducation(updateUser.getEducation());
			existUser.setEmail(updateUser.getEmail());
			existUser.setExperiance(updateUser.getExperiance());
			existUser.setGender(updateUser.getGender());
			existUser.setMobileNumber(updateUser.getMobileNumber());
			existUser.setPassOutYear(updateUser.getPassOutYear());
			existUser.setPassword(updateUser.getPassword());
			existUser.setRole(updateUser.getRole());

			userRepository.save(existUser);
		}
	}

	@Override
	public User getUser(int id) {

		return userRepository.findById(id).orElseThrow(() -> new UserException("User not found", HttpStatus.NOT_FOUND));
	}

	@Override
	public List<User> users() {
		if (userRepository.findAll().isEmpty()) {
			throw new UserException("No Records", HttpStatus.BAD_REQUEST);
		}
		return userRepository.findAll();
	}

}
