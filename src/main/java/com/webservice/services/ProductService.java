package com.webservice.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webservice.entities.Product;
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
	public Product findById(Long id) {
		Optional<Product> objProduct = productRepository.findById(id);
		return objProduct.get();
	}

}
