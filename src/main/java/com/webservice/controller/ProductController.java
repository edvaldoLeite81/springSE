package com.webservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webservice.entities.Product;
import com.webservice.services.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping
	public ResponseEntity<List<Product>> findAll() {
		List<Product> listProduct = productService.all();
		return ResponseEntity.ok().body(listProduct);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id) {
		Product objProduct = productService.findById(id);
		return ResponseEntity.ok().body(objProduct);
	}
}
