package com.mmacedoaraujo.workshopspringbootjpa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mmacedoaraujo.workshopspringbootjpa.entities.User;
import com.mmacedoaraujo.workshopspringbootjpa.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;

	public List<User> findAll() {
		return userRepo.findAll();
	}

	public User findByID(Long id) {
		Optional<User> obj = userRepo.findById(id);
		return obj.get();
	}

	public User insert(User user) {
		return userRepo.save(user);
	}

}
