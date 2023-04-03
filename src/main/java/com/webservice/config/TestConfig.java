package com.webservice.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.webservice.entities.Category;
import com.webservice.entities.Order;
import com.webservice.entities.OrderItem;
import com.webservice.entities.Product;
import com.webservice.entities.User;
import com.webservice.repository.CategoryRepository;
import com.webservice.repository.OrderItemRepository;
import com.webservice.repository.OrderRepository;
import com.webservice.repository.ProductRepository;
import com.webservice.repository.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@Override
	public void run(String... args) throws Exception {
		Category cat1 = new Category(null, "Computer");
		Category cat2 = new Category(null, "Book");
		Category cat3 = new Category(null, "Eletronic");
		
		categoryRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
		
		Product p1 = new Product(null, "The Lord of the Ring", "Lorem ipsum dolor sit amet, consectetur", 90.5, null);
		Product p2 = new Product(null, "Smart TV 62'", "Nulla eu impediet purus. Maecenas ante", 2190.5, null);
		Product p3 = new Product(null, "Macbook Pro", "Nam, eleifend maximus tortor, at mollis", 12500.0, null);
		Product p4 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus", 100.99, null);
		Product p5 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus", 6250.00, null);
		
		productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		
		User u1 = new User(null, "Edvaldo Leite", "eguilhermeleite@gmail.com","11962458794","12345", null);
		User u2 = new User(null, "Luciene Leite", "lsilvaleite14@gmail.com", "11977114962", "12124", null);
		User u3 = new User(null, "Davih Leite", "duilhermesilvaleite@gmail.com","11962458794","25456", null);
		User u4 = new User(null, "Godofredo das Neves", "godo@gmail.com", "11978456985", "45678", null);
		User u5 = new User(null, "Godofredina das Neves", "fredina@gmail.com", "11978456985", "45678", null);
		
		userRepository.saveAll(Arrays.asList(u1,u2,u3,u4,u5));
		
		Order o1 = new Order(null, Instant.parse("2019-02-26T13:08:42Z"),1, u5);
		Order o2 = new Order(null, Instant.parse("2019-04-17T09:45:41Z"),1, u4);
		Order o3 = new Order(null, Instant.parse("2019-03-05T07:10:14Z"),2,u2);
		Order o4 = new Order(null, Instant.parse("2019-06-12T08:02:52Z"),4,u3);
		Order o5 = new Order(null, Instant.parse("2019-03-27T06:36:12Z"),3,u1);
		
		orderRepository.saveAll(Arrays.asList(o1,o2,o3,o4,o5));
		
		p1.getCategories().add(cat2);
		p2.getCategories().add(cat3);
		p2.getCategories().add(cat1);
		p3.getCategories().add(cat1);
		p4.getCategories().add(cat2);
		p5.getCategories().add(cat1);
		
		productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
	
		OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
		OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
		OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
		OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());
		
		orderItemRepository.saveAll(Arrays.asList(oi1,oi2,oi3,oi4));
	}
	

}
