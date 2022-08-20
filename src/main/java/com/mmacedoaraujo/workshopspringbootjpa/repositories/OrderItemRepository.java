package com.mmacedoaraujo.workshopspringbootjpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mmacedoaraujo.workshopspringbootjpa.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
