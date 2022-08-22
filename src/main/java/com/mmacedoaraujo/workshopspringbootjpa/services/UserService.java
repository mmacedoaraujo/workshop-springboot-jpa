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

	public void delete(Long id) {
		userRepo.deleteById(id);
	}

	public User update(Long id, User obj) {
		User entity = userRepo.getReferenceById(id);
		updateData(entity, obj);
		return userRepo.save(entity);

	}

	private void updateData(User entity, User obj) {
		entity.setUserName(obj.getUserName());
		entity.setUserEmail(obj.getUserEmail());
		entity.setUserPhone(obj.getUserPhone());
	}

}
