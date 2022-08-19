package com.mmacedoaraujo.workshopspringbootjpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mmacedoaraujo.workshopspringbootjpa.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
