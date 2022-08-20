package com.mmacedoaraujo.workshopspringbootjpa.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.mmacedoaraujo.workshopspringbootjpa.entities.Category;
import com.mmacedoaraujo.workshopspringbootjpa.entities.Order;
import com.mmacedoaraujo.workshopspringbootjpa.entities.OrderItem;
import com.mmacedoaraujo.workshopspringbootjpa.entities.Product;
import com.mmacedoaraujo.workshopspringbootjpa.entities.User;
import com.mmacedoaraujo.workshopspringbootjpa.entities.enums.OrderStatus;
import com.mmacedoaraujo.workshopspringbootjpa.repositories.CategoryRepository;
import com.mmacedoaraujo.workshopspringbootjpa.repositories.OrderItemRepository;
import com.mmacedoaraujo.workshopspringbootjpa.repositories.OrderRepository;
import com.mmacedoaraujo.workshopspringbootjpa.repositories.ProductRepository;
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

	@Autowired
	private ProductRepository productRepo;

	@Autowired
	private OrderItemRepository orderItemRepo;

	@Override
	public void run(String... args) throws Exception {

		Category category1 = new Category(null, "Electronics");
		Category category2 = new Category(null, "Books");
		Category category3 = new Category(null, "Computers");

		Product product1 = new Product(null, "The Lord of the Rings", "Lorem Ipsum dolor sit amet, consecteur.", 90.5,
				"");
		Product product2 = new Product(null, "Smart TV", "Lorem Ipsum dolor sit amet, consecteur.", 2190.0, "");
		Product product3 = new Product(null, "Macbook Pro", "Lorem Ipsum dolor sit amet, consecteur.", 1250.0, "");
		Product product4 = new Product(null, "Pc Gamer", "Lorem Ipsum dolor sit amet, consecteur.", 1200.0, "");
		Product product5 = new Product(null, "Rails for Dummies", "Lorem Ipsum dolor sit amet, consecteur.", 100.99,
				"");
		productRepo.saveAll(Arrays.asList(product1, product2, product3, product4, product5));
		categoryRepo.saveAll(Arrays.asList(category1, category2, category3));

		product1.getCategories().add(category2);
		product2.getCategories().add(category1);
		product2.getCategories().add(category3);
		product3.getCategories().add(category3);
		product4.getCategories().add(category3);
		product5.getCategories().add(category2);

		productRepo.saveAll(Arrays.asList(product1, product2, product3, product4, product5));

		User user1 = new User(null, "Maria", "maria@gmail.com", "999009898998", "89812398109328");
		User user2 = new User(null, "Alex Green", "alex@gmail.com", "9879287987", "0192381098");

		Order order1 = new Order(null, Instant.parse("2022-08-17T19:53:07Z"), user1, OrderStatus.PAID);
		Order order2 = new Order(null, Instant.parse("2022-08-18T15:53:07Z"), user2, OrderStatus.WAITING_PAYMENT);
		Order order3 = new Order(null, Instant.parse("2022-08-16T10:53:07Z"), user1, OrderStatus.WAITING_PAYMENT);

		userRepo.saveAll(Arrays.asList(user1, user2));
		orderRepo.saveAll(Arrays.asList(order1, order2, order3));

		OrderItem orderItem1 = new OrderItem(order1, product1, 2, product1.getPrice());
		OrderItem orderItem2 = new OrderItem(order1, product3, 1, product3.getPrice());
		OrderItem orderItem3 = new OrderItem(order2, product3, 2, product3.getPrice());
		OrderItem orderItem4 = new OrderItem(order3, product5, 2, product5.getPrice());

		orderItemRepo.saveAll(Arrays.asList(orderItem1, orderItem2, orderItem3, orderItem4));
	}

}
