package com.webservice.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webservice.entities.Order;
import com.webservice.entities.User;
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
	public Order findById(Long id) {
		Optional<Order> objOrder = orderRepository.findById(id);
		return objOrder.get();
	}

}
