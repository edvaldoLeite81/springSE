package com.webservice.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webservice.entities.Category;
import com.webservice.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository catergoryRepository;

	// buscar todos
	public List<Category> all() {
		return catergoryRepository.findAll();
	}
	
	// buscar por id
	public Category findById(Long id) {
		Optional<Category> objCategory = catergoryRepository.findById(id);
		return objCategory.get();
	}

}
