package com.mmacedoaraujo.workshopspringbootjpa.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.mmacedoaraujo.workshopspringbootjpa.entities.Category;
import com.mmacedoaraujo.workshopspringbootjpa.entities.Order;
import com.mmacedoaraujo.workshopspringbootjpa.entities.User;
import com.mmacedoaraujo.workshopspringbootjpa.entities.enums.OrderStatus;
import com.mmacedoaraujo.workshopspringbootjpa.repositories.CategoryRepository;
import com.mmacedoaraujo.workshopspringbootjpa.repositories.OrderRepository;
import com.mmacedoaraujo.workshopspringbootjpa.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private OrderRepository orderRepo;

	@Autowired
	private CategoryRepository categoryRepo;

	@Override
	public void run(String... args) throws Exception {

		User user1 = new User(null, "Maria", "maria@gmail.com", "999009898998", "89812398109328");
		User user2 = new User(null, "Alex Green", "alex@gmail.com", "9879287987", "0192381098");

		Order order1 = new Order(null, Instant.parse("2022-08-17T19:53:07Z"), user1, OrderStatus.PAID);
		Order order2 = new Order(null, Instant.parse("2022-08-18T15:53:07Z"), user2, OrderStatus.WAITING_PAYMENT);
		Order order3 = new Order(null, Instant.parse("2022-08-16T10:53:07Z"), user1, OrderStatus.WAITING_PAYMENT);

		Category category1 = new Category(null, "Electronics");
		Category category2 = new Category(null, "Books");
		Category category3 = new Category(null, "Computers");

		categoryRepo.saveAll(Arrays.asList(category1, category2, category3));
		userRepo.saveAll(Arrays.asList(user1, user2));
		orderRepo.saveAll(Arrays.asList(order1, order2, order3));
	}

}