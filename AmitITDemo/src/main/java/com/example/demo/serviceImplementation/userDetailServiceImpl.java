package com.example.demo.serviceImplementation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User;

import com.example.demo.entity.Users;
import com.example.demo.exception.UserException;

import com.example.demo.repository.UserRepository;


@Service
public class userDetailServiceImpl implements UserDetailsService {

	@Autowired
	UserRepository userRepository;
	
	 @Autowired
	 private PasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {

	Optional<Users> optional	= userRepository.findByName(name);
		if (optional.isEmpty()) {
			throw new UserException("Not Found", HttpStatus.NOT_FOUND);
		}
		Users user = optional.get();
	

		List<GrantedAuthority> lga = new ArrayList<GrantedAuthority>();

		for (String roles : Arrays.asList(user.getRole().split(","))) {
			GrantedAuthority ga = new SimpleGrantedAuthority(roles.trim());
			lga.add(ga);
		}
	
		return new User(user.getName(), user.getPassword(), lga);
	
	}
		 public void resetPassword(String email, String newPassword) {

		        Users user = userRepository.findByEmail(email)
		                .orElseThrow(() -> new RuntimeException("User not found"));

		        user.setPassword(passwordEncoder.encode(newPassword));
		        userRepository.save(user);

		

}
}
