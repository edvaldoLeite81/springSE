package com.webservice.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

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
	public ResponseEntity<User> findById(Long id) {
		return userRepository.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}
	
	
	public User insert(User user) {
		return userRepository.save(user);
	}

}
