package com.mmacedoaraujo.workshopspringbootjpa.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.mmacedoaraujo.workshopspringbootjpa.entities.User;
import com.mmacedoaraujo.workshopspringbootjpa.repositories.UserRepository;
import com.mmacedoaraujo.workshopspringbootjpa.services.exceptions.DatabaseException;
import com.mmacedoaraujo.workshopspringbootjpa.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;

	public List<User> findAll() {
		return userRepo.findAll();
	}

	public User findByID(Long id) {
		Optional<User> obj = userRepo.findById(id);
		// throwing exception
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public User insert(User user) {
		return userRepo.save(user);
	}

	public void delete(Long id) {
		try {
			userRepo.deleteById(id);
		} catch (EmptyResultDataAccessException ex) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException ex) {
			throw new DatabaseException(ex.getMessage());
		}
	}

	public User update(Long id, User obj) {
		try {
			User entity = userRepo.getReferenceById(id);
			updateData(entity, obj);
			return userRepo.save(entity);
		} catch (EntityNotFoundException ex) {
			throw new ResourceNotFoundException(id);
		}

	}

	private void updateData(User entity, User obj) {
		entity.setUserName(obj.getUserName());
		entity.setUserEmail(obj.getUserEmail());
		entity.setUserPhone(obj.getUserPhone());
	}

}
