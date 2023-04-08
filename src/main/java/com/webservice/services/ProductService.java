package com.webservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.webservice.entities.Product;
import com.webservice.exceptions.ResourceNotFoundException;
import com.webservice.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	// buscar todos
	public List<Product> all() {
		return productRepository.findAll();
	}

	// buscar por id
	public ResponseEntity<Product> findById(Long id) {
		//Optional<Product> objProduct = productRepository.findById(id);
		String message = "Resource With Id "+ id + " Not Found";
		return productRepository.findById(id).map(ResponseEntity::ok).orElseThrow(()-> new ResourceNotFoundException(id, message));
		
		//return objProduct.get();
	}


}
