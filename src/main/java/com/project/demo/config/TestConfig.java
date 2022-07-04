package com.project.demo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.project.demo.entities.Deposit;
import com.project.demo.repositories.DepositRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	@Autowired
	private DepositRepository depositRepository;

	@Override
	public void run(String... args) throws Exception {

		Deposit u1 = new Deposit(null, 16, 7, 2022, null,null, 1, 5000);
		Deposit u2 = new Deposit(null, 10, 7, 2022, null,null, 1, 500);
 
		depositRepository.saveAll(Arrays.asList(u1, u2));

	}

}
