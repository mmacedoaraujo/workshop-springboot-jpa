package com.mmacedoaraujo.workshopspringbootjpa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mmacedoaraujo.workshopspringbootjpa.entities.Order;
import com.mmacedoaraujo.workshopspringbootjpa.repositories.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepo;
	
	public List<Order> findAll() {
		return orderRepo.findAll();
	}

	public Order findById(Long id) {
		Optional<Order> obj = orderRepo.findById(id);

		return obj.get();
	}
}
