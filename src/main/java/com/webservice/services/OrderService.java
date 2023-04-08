package com.webservice.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.webservice.entities.Order;
import com.webservice.entities.User;
import com.webservice.exceptions.ResourceNotFoundException;
import com.webservice.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;

	// buscar todos
	public List<Order> all() {
		return orderRepository.findAll();
	}

	// buscar por id
	public ResponseEntity<Order> findById(Long id) {
		String message = "Resource With Id " + id + " Not Found";
		return orderRepository.findById(id).map(ResponseEntity::ok)
				.orElseThrow(() -> new ResourceNotFoundException(id, message));
	}

}
