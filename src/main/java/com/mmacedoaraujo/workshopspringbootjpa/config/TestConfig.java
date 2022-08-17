package com.mmacedoaraujo.workshopspringbootjpa.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.mmacedoaraujo.workshopspringbootjpa.entities.User;
import com.mmacedoaraujo.workshopspringbootjpa.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepo;

	@Override
	public void run(String... args) throws Exception {
		
		User user1 = new User(null, "Maria", "maria@gmail.com", "999009898998", "89812398109328");
		User user2 = new User(null, "Alex Green", "alex@gmail.com", "9879287987", "0192381098");
		
		userRepo.saveAll(Arrays.asList(user1, user2));
	}

}
