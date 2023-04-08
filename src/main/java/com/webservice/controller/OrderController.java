package com.webservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webservice.entities.Order;
import com.webservice.services.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@GetMapping
	public ResponseEntity<List<Order>> findAll() {
		List<Order> listOrder = orderService.all();
		return ResponseEntity.ok().body(listOrder);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Order> findById(@PathVariable Long id) {
		return orderService.findById(id);
	}
}
