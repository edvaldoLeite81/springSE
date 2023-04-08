package com.webservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.webservice.entities.User;
import com.webservice.exceptions.DatabaseException;
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
		String notFound = "Resource With Id " + id + " Not Found";
		
		if (!userRepository.existsById(id)) {
			throw new ResourceNotFoundException(id, notFound);
			// return ResponseEntity.notFound().build();
		}
		user.setId(id);
		user = userRepository.save(user);
		return ResponseEntity.ok(user);
	}

	// deletar usuario
	public ResponseEntity<Void> delete(Long id) {
		String notFound = "Resource With Id " + id + " Not Found";
		String badRequest = "Resource " + id + " Cannot be deleted due to violating database rules";

		if (!userRepository.existsById(id)) {

			throw new ResourceNotFoundException(id, notFound);
			// return ResponseEntity.notFound().build();
		}

		try {
			userRepository.deleteById(id);

		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(id, badRequest);
		}

		return ResponseEntity.noContent().build();
	}

}
