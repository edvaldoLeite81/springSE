package com.webservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webservice.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
