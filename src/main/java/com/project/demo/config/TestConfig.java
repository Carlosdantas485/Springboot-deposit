package com.project.demo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.project.demo.entities.Deposit;
import com.project.demo.entities.User;
import com.project.demo.repositories.DepositRepository;
import com.project.demo.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	@Autowired
	private DepositRepository depositRepository;

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {

		Deposit d1 = new Deposit(null, 20, 7, 2022, 1, 5000);
		Deposit d2 = new Deposit(null, 10, 8, 2022, 1, 50000);
 
		depositRepository.saveAll(Arrays.asList(d1, d2));
		
		User u1 = new User(null, "Carlos", "Dantas","carlosdanats485@gmail.com",983502027, 1996,05,06,  "carlos123");
		User u2 = new User(null, "Alberto", "filho","albertofilho485@gmail.com",987654321, 1996,05,06, "alberto123");
 
		userRepository.saveAll(Arrays.asList(u1, u2));

	}

}

