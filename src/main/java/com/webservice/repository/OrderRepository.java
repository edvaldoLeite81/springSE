package com.webservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webservice.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
