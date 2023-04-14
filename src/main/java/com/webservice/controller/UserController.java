package com.webservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.webservice.entities.User;
import com.webservice.services.UserService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		List<User> listUser = userService.all();
		return ResponseEntity.ok().body(listUser);
	}

	@GetMapping("/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) {
		return userService.findById(id);
	}
	
	//inserir usuario
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@Transactional
	public User insert(@Valid @RequestBody User user){
		return userService.insert(user);
	}
	
	//atualizar
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<User> update(@Valid @PathVariable Long id, @RequestBody User user){
		return userService.update(id, user);
	}
	
	//deletar usuario
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		 return userService.delete(id);
	}
}
