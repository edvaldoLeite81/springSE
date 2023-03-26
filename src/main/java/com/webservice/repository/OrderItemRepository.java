package com.webservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webservice.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

}
