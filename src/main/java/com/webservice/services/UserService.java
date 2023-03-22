package com.webservice.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webservice.entities.User;
import com.webservice.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	// buscar todos
	public List<User> all() {
		return userRepository.findAll();
	}
	
	// buscar por id
	public User findById(Long id) {
		Optional<User> objUser = userRepository.findById(id);
		return objUser.get();
	}

}
