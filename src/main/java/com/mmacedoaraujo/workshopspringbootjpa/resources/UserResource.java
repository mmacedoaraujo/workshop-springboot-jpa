package com.mmacedoaraujo.workshopspringbootjpa.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mmacedoaraujo.workshopspringbootjpa.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@GetMapping
	public ResponseEntity<User> findAll() {
		User user = new User(1L, "Maria", "maria@gmail.com", "0000000", "111111");
		return ResponseEntity.ok().body(user);
	}
}
