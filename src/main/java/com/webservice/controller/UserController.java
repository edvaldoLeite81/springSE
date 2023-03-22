package com.webservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webservice.entities.User;

@RestController
@RequestMapping("/users")
public class UserController {

	@GetMapping
	public ResponseEntity<User> findAll(){
		
		User us1 = new User(1L, "Edvaldo Leite", "eguilhermeleite@gmai.com", "11961257615", "1234");
		return ResponseEntity.ok().body(us1);
	}
}
