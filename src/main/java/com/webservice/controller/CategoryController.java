package com.webservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webservice.entities.Category;
import com.webservice.services.CategoryService;

@RestController
@RequestMapping("/categories")
public class CategoryController {

	@Autowired
	private CategoryService catergoryService;

	@GetMapping
	public ResponseEntity<List<Category>> findAll() {
		List<Category> listCategory = catergoryService.all();
		return ResponseEntity.ok().body(listCategory);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Category> findById(@PathVariable Long id) {
		Category objCategory = catergoryService.findById(id);
		return ResponseEntity.ok().body(objCategory);
	}
}
