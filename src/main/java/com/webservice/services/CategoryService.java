package com.webservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.webservice.entities.Category;
import com.webservice.exceptions.ResourceNotFoundException;
import com.webservice.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	// buscar todos
	public List<Category> all() {
		return categoryRepository.findAll();
	}
	
	// buscar por id
	public ResponseEntity<Category> findById(Long id) {
		String message = "Resource With Id "+ id + " Not Found";
		return categoryRepository.findById(id).map(ResponseEntity::ok).orElseThrow(()-> new ResourceNotFoundException(id, message));
	}
	
	

}
