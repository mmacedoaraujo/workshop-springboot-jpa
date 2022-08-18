package com.mmacedoaraujo.workshopspringbootjpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mmacedoaraujo.workshopspringbootjpa.entities.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
