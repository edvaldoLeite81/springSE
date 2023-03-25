package com.webservice.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.webservice.entities.Order;
import com.webservice.entities.User;
import com.webservice.enums.OrderStatus;
import com.webservice.repository.OrderRepository;
import com.webservice.repository.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Override
	public void run(String... args) throws Exception {
	
		User u1 = new User(null, "Edvaldo Leite", "eguilhermeleite@gmail.com","11962458794","12345", null);
		User u2 = new User(null, "Luciene Leite", "lsilvaleite14@gmail.com", "11977114962", "12124", null);
		User u3 = new User(null, "Davih Leite", "duilhermesilvaleite@gmail.com","11962458794","25456", null);
		User u4 = new User(null, "Godofredo das Neves", "godo@gmail.com", "11978456985", "45678", null);
		User u5 = new User(null, "Godofredina das Neves", "fredina@gmail.com", "11978456985", "45678", null);
		
		
		Order o1 = new Order(null, Instant.parse("2019-02-26T13:08:42Z"),1, u5);
		Order o2 = new Order(null, Instant.parse("2019-04-17T09:45:41Z"),1, u4);
		Order o3 = new Order(null, Instant.parse("2019-03-05T07:10:14Z"),2,u2);
		Order o4 = new Order(null, Instant.parse("2019-06-12T08:02:52Z"),4,u3);
		Order o5 = new Order(null, Instant.parse("2019-03-27T06:36:12Z"),3,u1);
		
		
		userRepository.saveAll(Arrays.asList(u1,u2,u3,u4,u5));
		orderRepository.saveAll(Arrays.asList(o1,o2,o3,o4,o5));
		
	}
	
	

}
