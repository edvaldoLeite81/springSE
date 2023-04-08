package com.webservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.webservice.entities.User;
import com.webservice.exceptions.ResourceNotFoundException;
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
		String message = "Resource With Id " + id + " Not Found";
		return userRepository.findById(id).map(ResponseEntity::ok)
				.orElseThrow(() -> new ResourceNotFoundException(id, message));
	}

	// inserir usuario
	public User insert(User user) {
		return userRepository.save(user);
	}

	// atualizar
	public ResponseEntity<User> update(Long id, User user) {
		
		if (!userRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		user.setId(id);
		user = userRepository.save(user);

		return ResponseEntity.ok(user);
	}

	// deletar usuario
	public ResponseEntity<Void> delete(Long id) {

		if (!userRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		userRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}

}
