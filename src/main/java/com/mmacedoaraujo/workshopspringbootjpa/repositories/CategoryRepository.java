package com.mmacedoaraujo.workshopspringbootjpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mmacedoaraujo.workshopspringbootjpa.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
