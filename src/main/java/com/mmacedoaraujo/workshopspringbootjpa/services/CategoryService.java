package com.mmacedoaraujo.workshopspringbootjpa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mmacedoaraujo.workshopspringbootjpa.entities.Category;
import com.mmacedoaraujo.workshopspringbootjpa.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepo;

	public List<Category> findAll() {
		return categoryRepo.findAll();
	}

	public Category findById(Long id) {
		Optional<Category> obj = categoryRepo.findById(id);

		return obj.get();
	}

}
