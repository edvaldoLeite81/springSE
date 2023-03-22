package com.webservice.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.webservice.entities.User;
import com.webservice.repository.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
	
		User u1 = new User(null, "Edvaldo Leite", "eguilhermeleite@gmail.com","11962458794","12345");
		User u2 = new User(null, "Luciene Leite", "lsilvaleite14@gmail.com", "11977114962", "12124");
		User u3 = new User(null, "Davih Leite", "duilhermesilvaleite@gmail.com","11962458794","25456");
		User u4 = new User(null, "Godofredo das Neves", "godo@gmail.com", "11978456985", "45678");
		
		userRepository.saveAll(Arrays.asList(u1,u2,u3,u4));
	}
	
	

}
